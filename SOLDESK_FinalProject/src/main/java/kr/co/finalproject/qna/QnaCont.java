package kr.co.finalproject.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


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
		
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("s_mem_id")==null || session.getAttribute("s_mem_lv")==null || session.getAttribute("s_mem_pw")==null) {
			mav.setViewName("qna/qnalist");
			mav.addObject("list", dao.list());
		}else {
			String mem_lv=session.getAttribute("s_mem_lv").toString();
			mav.addObject("mem_lv", mem_lv);
			mav.setViewName("qna/qnalist");
			mav.addObject("list", dao.list());
			}
		return mav;
	}//notice() end
	
	@RequestMapping(value = "qna/qnaread.do", method = RequestMethod.GET)
	public ModelAndView read(@ModelAttribute QnaDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("qna/qnaread");
		int qna_num=Integer.parseInt(req.getParameter("qna_num"));
		

		dto=dao.read(qna_num); 
		if(dto==null){
			String msg="<p>해당 글 없음</p>";
	        mav.addObject("msg", msg);
		}else{
			//dao.incrementCnt(qna_num);
			//String mem_id=session.getAttribute("s_mem_id").toString();
			//mav.addObject("mem_id", mem_id);
			mav.addObject("dto", dto);
			String msg="<p>글 불러옴</p>";
	        mav.addObject("msg", msg);
		}//if end
		/*
			if(session.getAttribute("s_mem_id")==null || session.getAttribute("s_mem_lv")==null || session.getAttribute("s_mem_pw")==null) {
				String msg="<p>로그인 해주세요</p>";
	            mav.addObject("msg", msg);
			}else {
		}//if end*/
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
	}
	
	
	
	
	
	
}//class end