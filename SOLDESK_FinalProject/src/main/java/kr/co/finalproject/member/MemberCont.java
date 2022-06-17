package kr.co.finalproject.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberCont {
	
	private memberDAO dao = null;
	int check=0;
	public MemberCont() {
		dao = new memberDAO();
		System.out.println("-----MemberContr() 객체 생성");
	}
	
	@RequestMapping(value = "mypage.do", method = RequestMethod.GET)
	public String mypage() {
		return "m_manage/login";
	}
	
	@RequestMapping(value ="mypage", method = RequestMethod.POST)
	public ModelAndView mypage(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage");
		
		
		return mav;
	}
	
	@RequestMapping(value = "member_info.do", method = RequestMethod.GET)
	public ModelAndView member_info(String mem_id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("m_manage/member_info");
		memberDTO dto = dao.read(mem_id);
		mav.addObject("dto", dto);
		return mav;	
	
	}
	
	@RequestMapping(value = "member_info.do", method = RequestMethod.POST)
	public ModelAndView member_infoProc(@ModelAttribute memberDTO dto,  HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("m_manage/member_info");
		
		int cnt = dao.update(dto);
		if(cnt==0) {
			String msg="<p>회원 정보 수정 실패</p>";
			String link1="<input type='button' value='다시시도' onclick='javascript:history.back()'>";
            String link2="<input type='button' value='마이페이지' onclick='location.href=\"member_info.do\"'>";
            mav.addObject(msg);
            mav.addObject(link1);
            mav.addObject(link2);
		}else {
			String msg="<p>회원 정보 수정 성공</p>";
			String link2="<input type='button' value='마이페이지' onclick='location.href=\"mypage.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("link2", link2);   
		}
		return mav;
	}
	
	@RequestMapping(value = "/member_join.do", method = RequestMethod.GET)
	public String member_join() {
		return "m_manage/member_join";
	}
	
	@RequestMapping(value = "/member_join.do", method = RequestMethod.POST)
	public ModelAndView member_joinProc(@ModelAttribute memberDTO dto, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member_join");
		
		String mem_id = req.getParameter("mem_id").trim();
		String mem_pw = req.getParameter("mem_pw").trim();
		String mem_phone = req.getParameter("mem_phone").trim();
		String mem_ph1 = mem_phone.substring(3, 6);
		String mem_ph2 = mem_phone.substring(7, 10);
		String mem_email = req.getParameter("mem_email").trim();
		String mem_reg = req.getParameter("mem_reg").trim();
		String mem_birth = req.getParameter("mem_birth").trim();
		String mem_gender = mem_birth.substring(6);
		
		dto.setMem_id(mem_id);
		dto.setMem_pw(mem_pw);
		dto.setMem_phone(mem_phone+"-"+mem_ph1+"-"+mem_ph2);
		dto.setMem_email(mem_email);
		dto.setMem_reg(mem_reg);
		dto.setMem_birth(mem_birth.substring(0,5)+"-"+mem_gender);
		
		int cnt=dao.insert(dto);

		if(cnt==0) {
			String msg="<p>회원 가입 실패</p>";
			String link1="<input type='button' value='다시시도' onclick='javascript:history.back()'>";
            String link2="<input type='button' value='홈' onclick='location.href=\"home.do\"'>";
            mav.addObject(msg);
            mav.addObject(link1);
            mav.addObject(link2);
		}else {
			String msg="<p>회원 가입 성공</p>";
			String link2="<input type='button' value='홈' onclick='location.href=\"home.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("link2", link2);   
		}
		return mav;
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
				
				check=0;
			}else {
				
				session.setAttribute("s_mem_id", mem_id);
				session.setAttribute("s_mem_pw", mem_pw);
				session.setAttribute("s_mem_lv", mem_lv);
				
				String msg="<h2>로그인 결과</h2><p>로그인 성공</p>";
				mav.addObject("msg", msg);
				
				check=1;
				
			}
			
			mav.setViewName("m_manage/mypage");
			
			return mav;
		}
	
	@RequestMapping("/member_bank.do")
	public String member_bank() {
		return "m_manage/member_bank";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) {
		
		ModelAndView mav =new ModelAndView();
		HttpSession session = req.getSession();
		
		session.removeAttribute("s_mem_id");
		session.removeAttribute("s_mem_pw");
		session.removeAttribute("s_mem_lv");
		
		mav.setViewName("index");
		
		return mav;
	}
	
}
