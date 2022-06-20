package kr.co.finalproject.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoticeCont {
	
	NoticeDAO dao=null;
	
	public NoticeCont() {
		dao=new NoticeDAO();
		System.out.println("-----NoticeCont() 객체생성");
	}
	
	//결과확인 http://localhost:9090/notice/notice.do
	@RequestMapping(value = "notice/notice.do")
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("notice/noticelist");
		mav.addObject("list", dao.list());
		
		return mav;
	}//notice() end

	
}//class end