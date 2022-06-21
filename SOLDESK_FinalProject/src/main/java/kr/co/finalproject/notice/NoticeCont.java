package kr.co.finalproject.notice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeCont {
	
	NoticeDAO dao=null;
	
	public NoticeCont() {
		dao=new NoticeDAO();
		System.out.println("-----NoticeCont() 객체생성");
	}//NoticeCont() 
	
	
	//결과확인 http://localhost:9090/notice/notice.do
	@RequestMapping(value = "notice/notice.do")
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/noticelist");
		mav.addObject("list", dao.list());
		return mav;
	}//notice() end
	
	@RequestMapping(value = "notice/noticemaster.do")
	public ModelAndView master() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/noticemaster");
		mav.addObject("list", dao.list());
		return mav;
	}//master() end
	
	@RequestMapping(value = "notice/noticeForm.do", method = RequestMethod.POST)
	public ModelAndView write() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/noticeForm");
		return mav;
	}//write() end
	
	@RequestMapping(value = "notice/noticecreate.do", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute NoticeDTO dto) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/msgView");
		
		int cnt=dao.create(dto);
		if(cnt==0) {
			String msg="<p>글 등록 실패</p>";
            mav.addObject("msg", msg);
		}else {
			String msg="<p>글 등록 성공</p>";
            mav.addObject("msg", msg);
		}//if end
		return mav;
	}//create() end
	
	@RequestMapping(value = "notice/noticeread.do", method = RequestMethod.GET)
	public ModelAndView read(@ModelAttribute NoticeDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/noticeread");
		int n_num=Integer.parseInt(req.getParameter("n_num"));
		
			
		dto=dao.read(n_num);
		if(dto==null){
			String msg="<p>해당 글 없음</p>";
            mav.addObject("msg", msg);
		}else{
			dao.incrementCnt(n_num);
			mav.addObject("dto", dto);
			String msg="<p>글 불러옴</p>";
            mav.addObject("msg", msg);
		}//if end
		
		return mav;
	}//read() end
	
	@RequestMapping(value = "notice/noticemasterread.do", method = RequestMethod.GET)
	public ModelAndView masterread(@ModelAttribute NoticeDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/noticemasterread");
		int n_num=Integer.parseInt(req.getParameter("n_num"));
		
			
		dto=dao.read(n_num);
		if(dto==null){
			String msg="<p>해당 글 없음</p>";
            mav.addObject("msg", msg);
		}else{
			dao.incrementCnt(n_num);
			mav.addObject("dto", dto);
			String msg="<p>글 불러옴</p>";
            mav.addObject("msg", msg);
		}//if end
		
		return mav;
	}//read() end
	
	@RequestMapping(value = "notice/noticedelelte.do", method = RequestMethod.POST)
	public ModelAndView delete(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/msgView");
		int n_num=Integer.parseInt(req.getParameter("n_num"));
		
		int cnt=dao.delete(n_num);
		if(cnt==0) {
			String msg="<p>해당 글 삭제 실패</p>";
            mav.addObject("msg", msg);
		}else {
			String msg="<p>해당 글 삭제 성공</p>";
            mav.addObject("msg", msg);
		}//if end
		
		return mav;
	}//delete() end
	
	
	@RequestMapping(value = "notice/noticeupdate.do", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute NoticeDTO dto,HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/noticeupdate");
		int n_num=Integer.parseInt(req.getParameter("n_num"));
		mav.addObject("n_num", n_num);
		dto=dao.read(n_num);
		mav.addObject("dto", dto);
		return mav;
	}//write() end
	
	
	
	@RequestMapping(value = "notice/noticeupdateproc.do", method = RequestMethod.POST)
	public ModelAndView updateproc(@ModelAttribute NoticeDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/msgView");
		int n_num=Integer.parseInt(req.getParameter("n_num"));
		mav.addObject("n_num", n_num);
		
		int cnt=dao.updateproc(dto,n_num);
		if(cnt==0){
			String msg="<p>해당 글 수정 실패</p>";
            mav.addObject("msg", msg);
		}else {
			String msg="<p>해당 글 수정 성공</p>";
            mav.addObject("msg", msg);
		}//if end
		
		return mav;
	}
	
	

	
}//class end