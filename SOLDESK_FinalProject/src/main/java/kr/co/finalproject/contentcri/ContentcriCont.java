package kr.co.finalproject.contentcri;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.contlist.ContlistDAO;

@Controller
public class ContentcriCont {
	private ContentcriDAO dao = null;
	private ContlistDAO contdao = null;
	
	public ContentcriCont() {
		dao = new ContentcriDAO();
		contdao = new ContlistDAO();
		System.out.println("-----ContentcriCont() 객체 생성");
	}
	
	@RequestMapping(value= "/content_cri.do", method = RequestMethod.GET)
	public String insert() {
		return "content_cri/content_cri";
	}
	
	@RequestMapping(value= "/content_cri.do", method = RequestMethod.POST)
	public ModelAndView insertProc(HttpServletRequest req, ContentcriDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("content_cri/content_cri");
		HttpSession session = req.getSession();
		String s_mem_id = session.getAttribute("s_mem_id").toString();
		String s_mcode = req.getParameter("mcode");
		
		int cnt = dao.insert(dto);
		if(cnt==0) {
			String msg="<p> 실패</p>";
			String link1="<input type='button' value='다시시도' onclick='javascript:history.back()'>";
            mav.addObject(msg);
            mav.addObject(link1);
		}else {
			String msg="<p>성공</p>";
			String link2="<input type='button' value='컨텐츠 리스트' onclick='location.href=\"content_cri.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("link2", link2);   
		}
		
		return mav;
	}//insertProc() end
	
}//class end
