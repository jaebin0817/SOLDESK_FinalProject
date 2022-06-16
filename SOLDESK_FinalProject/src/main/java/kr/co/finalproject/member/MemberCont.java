package kr.co.finalproject.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberCont {

	private memberDAO dao = null;

	public MemberCont() {
		dao = new memberDAO();
		System.out.println("-----MemberCont() 객체 생성");
	}

	@RequestMapping("/m_manage/member_info.do")
	public String member_info() {
		return "m_manage/member_info";
	}
	
	
	//http://localhost:9090/login.do
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "m_manage/login";
	}
	
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav =new ModelAndView();
		HttpSession session = req.getSession();
		
		String mem_id=req.getParameter("id").trim();
		String mem_pw=req.getParameter("passwd").trim();
		
		String mem_lv=null;
		mem_lv=dao.loginRead(mem_id, mem_pw);
		
		if(mem_lv==null) {
			
			String msg="<h2>로그인 결과</h2><p>로그인 실패<br>아이디와 비밀번호를 확인해주세요</p>";
			mav.addObject("msg", msg);
			
		}else {
			
			session.setAttribute("s_mem_id", mem_id);
			session.setAttribute("s_mem_pw", mem_pw);
			session.setAttribute("s_mem_lv ", mem_lv);
			
			String msg="<h2>로그인 결과</h2><p>로그인 성공</p>";
			mav.addObject("msg", msg);
			
		}
		
		mav.setViewName("m_manage/msgView");
		
		return mav;
	}

	
	
}