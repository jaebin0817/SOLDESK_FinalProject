package kr.co.finalproject.qna;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Paging;
import net.utility.Utility;



@Controller
public class QnaCont {
	
	QnaDAO dao=null;
	
	public QnaCont() {	
		dao = new QnaDAO();
		System.out.println("-----QnaCont() 객체생성");	
	}
	
	//결과확인 http://localhost:9090/qna/qna.do
	@RequestMapping(value = "qna/qna.do")
	public ModelAndView list(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		
		String word=req.getParameter("word");//검색어
		String col=req.getParameter("col");//검색칼럼
		word=Utility.checkNull(word); //문자열값이 null이면 빈문자열로 치환
		col =Utility.checkNull(col);
		
		int recordPerPage=5;
		
		int nowPage=1;
		if(req.getParameter("nowPage")!=null){
			nowPage=Integer.parseInt(req.getParameter("nowPage"));
		}//if end
		int totalRecord=dao.count(col, word);
			
		HttpSession session = req.getSession();
		
		if(session.getAttribute("s_mem_id")!=null && session.getAttribute("s_mem_lv")!=null && session.getAttribute("s_mem_pw")!=null) {
			String mem_lv=session.getAttribute("s_mem_lv").toString();
			mav.addObject("mem_lv", mem_lv);
		}
		mav.setViewName("qna/qnalist");
		String paging=new Paging().paging3(totalRecord, nowPage, recordPerPage, col, word, "qna.do");
		mav.addObject("paging",paging);
		mav.addObject("list", dao.list3(col, word, nowPage, recordPerPage));

		
		return mav;
	}//list) end

	
	@RequestMapping(value = "qna/qnaread.do", method = RequestMethod.GET)
	public ModelAndView read(@ModelAttribute QnaDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("qna/qnaread");
		int qna_num=Integer.parseInt(req.getParameter("qna_num"));
		
		HttpSession session = req.getSession();
		
		
		dto=dao.read(qna_num); 
		if(dto==null){
			String msg="<p>해당 글 없음</p>";
	        mav.addObject("msg", msg);
		}else{
			dao.incrementCnt(qna_num);
	        if(session.getAttribute("s_mem_id")==null || session.getAttribute("s_mem_lv")==null || session.getAttribute("s_mem_pw")==null) {
				String msg="<p>로그인 후 글 수정 및 삭제 가능합니다</p>";
				mav.addObject("dto", dto);
	            mav.addObject("msg", msg);
			}else {	
				mav.addObject("dto", dto);
				String msg="<p>로그인 됨</p>";
		        mav.addObject("msg", msg);
		        String mem_id=session.getAttribute("s_mem_id").toString();
				mav.addObject("mem_id", mem_id);
			}//if end
		}//if end
		
			
		return mav;
	}//read() end
	
	@RequestMapping(value = "qna/qnaForm.do", method = RequestMethod.POST)
	public ModelAndView Form() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("qna/qnaForm");
		return mav;
	}//notice() end
	
	@RequestMapping(value = "qna/qnaProc.do", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute QnaDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("qna/msgView");
		
		String ip = req.getRemoteAddr();
		
		HttpSession session = req.getSession();
		
		dto.setIp(ip);
		if(session.getAttribute("s_mem_id")==null || session.getAttribute("s_mem_lv")==null || session.getAttribute("s_mem_pw")==null) {
			String msg="<p>로그인 해주세요</p>";
            mav.addObject("msg", msg);
		}else {
			String mem_id=session.getAttribute("s_mem_id").toString();
			dto.setMem_id(mem_id);
			int cnt=dao.create(dto);
			if(cnt==0) {
	            String msg="<p>qna 등록 실패</p>";
	            mav.addObject("msg", msg);
			}else {
				String msg="<p>qna 등록 성공</p>";
	            mav.addObject("msg", msg);
				//mav.setViewName("index");
			}//if end
		}
		return mav;
	}//create end
	
	@RequestMapping(value = "qna/qnadelete.do", method = RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute QnaDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("qna/msgView");
		
		HttpSession session = req.getSession();
		
		int qna_num=Integer.parseInt(req.getParameter("qna_num"));
		String qna_pw=req.getParameter("qna_pw");
		
		if(session.getAttribute("s_mem_id").toString().equals("webmaster")) {
			int cnt=dao.deletemaster(qna_num);
			if(cnt==0) {
				String msg="<p>웹마스터 글삭제실패</p>";
	            mav.addObject("msg", msg);
			}else {
				String msg="<p>웹마스터 글 삭제가 완료 되었습니다</p>";
	            mav.addObject("msg", msg);
			}//if end
		}else {
			int cnt2=dao.delete(qna_num, qna_pw);
			if(cnt2==0) {
				String msg="<p>비밀번호가 일치하지 않습니다</p>";
	            mav.addObject("msg", msg);
			}else{
				String msg="<p>글 삭제가 완료 되었습니다</p>";
	            mav.addObject("msg", msg);
			}//if end
		}//if end
		return mav;
	}//delete end
	
	@RequestMapping(value = "qna/qnaupdate.do", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute QnaDTO dto,HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("qna/qnaupdate");
		int qna_num=Integer.parseInt(req.getParameter("qna_num"));
		mav.addObject("qna_num", qna_num);
		dto=dao.read(qna_num);
		mav.addObject("dto", dto);
		return mav;
	}//write() end
	
	@RequestMapping(value = "qna/qnaupdateProc.do", method = RequestMethod.POST)
	public ModelAndView updateProc(@ModelAttribute QnaDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("qna/msgView");
		
		HttpSession session = req.getSession();
		
		String qna_pw=req.getParameter("qna_pw");
		
		
		if(session.getAttribute("s_mem_id").toString().equals("webmaster")) {
			int cnt=dao.updatemasterproc(dto);
			if(cnt==0) {
				String msg="<p>웹마스터 글 수정 실패</p>";
	            mav.addObject("msg", msg);
			}else {
				String msg="<p>웹마스터 글 수정이 완료 되었습니다</p>";
	            mav.addObject("msg", msg);
			}//if end
		}else {
			int cnt=dao.updateproc(dto, qna_pw);
			if(cnt==0) {
				String msg="<p>비밀번호가 일치하지 않습니다</p>";
	            mav.addObject("msg", msg);
			}else{
				String msg="<p>글 수정이 완료 되었습니다</p>";
	            mav.addObject("msg", msg);
			}//if end
		}//if end
		return mav;
	}//delete end
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class end
