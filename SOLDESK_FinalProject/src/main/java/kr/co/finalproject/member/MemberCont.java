package kr.co.finalproject.member;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Utility;

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
		return "m_manage/mypage";
	}
	
	@RequestMapping(value ="mypage.do", method = RequestMethod.POST)
	public ModelAndView mypage(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage");

		
		return mav;
	}
	
	@RequestMapping(value = "member_info.do", method = RequestMethod.GET)
	   public ModelAndView member_info(HttpServletRequest req) {
	      ModelAndView mav = new ModelAndView();
	      
	      HttpSession session = req.getSession();
	      String mem_id=session.getAttribute("s_mem_id").toString();
	      
	      mav.setViewName("m_manage/member_info");
	      mav.addObject("dto", dao.read(mem_id));
	      return mav;   
	   }
	
	@RequestMapping(value = "member_info.do", method = RequestMethod.POST)
	public ModelAndView member_infoProc(@ModelAttribute memberDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("m_manage/msgView");
		
		String mem_id = req.getParameter("mem_id");
		String mem_pw = req.getParameter("mem_pw").trim();
		String new_pw = req.getParameter("new_pw").trim();
		
		String mem_phone = req.getParameter("mem_phone").trim();
		String mem_email = req.getParameter("mem_email");
		String mem_birth = req.getParameter("mem_birth");
		
		dto.setMem_id(mem_id);
		dto.setMem_pw(mem_pw);
		dto.setNew_pw(new_pw);
		dto.setMem_phone(mem_phone);
		dto.setMem_email(mem_email);
		dto.setMem_birth(mem_birth);
		
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
	public ModelAndView member_joinProc(@ModelAttribute memberDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("m_manage/msgView");
		
		String mem_id = req.getParameter("mem_id").trim();
		String mem_pw = req.getParameter("mem_pw").trim();
		String mem_phone = req.getParameter("mem_phone").trim();
		String mem_email = req.getParameter("mem_email").trim();
		String mem_birth = req.getParameter("mem_birth").trim();
		
		dto.setMem_id(mem_id);
		dto.setMem_pw(mem_pw);
		dto.setMem_phone(mem_phone);
		dto.setMem_email(mem_email);
		dto.setMem_birth(mem_birth);

		
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
	   //http://localhost:9090/login.do
	   @RequestMapping(value = "/login.do", method = RequestMethod.GET)
	   public ModelAndView login(HttpServletRequest req) {
	      
	      ModelAndView mav =new ModelAndView();
	      
	      Cookie[] cookies=req.getCookies();//사용자 PC에 저장된 모든 쿠키값 가져오기
	      String c_id="";
	      
	      if(cookies!=null){//쿠키가 존재하는지?
	         for(int i=0; i<cookies.length; i++){ //모든 쿠키값을 검색함
	            Cookie cookie=cookies[i];       //쿠키 하나씩 가져오기
	            if(cookie.getName().equals("c_id")==true){
	               c_id=cookie.getValue();       //쿠키변수값 가져오기
	            }//if end
	         }//for end
	      }//if end
	      
	      mav.addObject("c_id", c_id);
	      mav.setViewName("m_manage/login");
	      
	      return mav;
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
	         session.setAttribute("s_mem_lv", mem_lv);
	         
	         String c_id=Utility.checkNull(req.getParameter("c_id"));   
	         Cookie cookie=null;
	         if(c_id.equals("SAVE")){//아이디 저장에 체크를 했다면
	            
	            //쿠키변수선언 new Cookie("변수명", 값)
	            cookie=new Cookie("c_id", mem_id);
	            
	            //쿠키의 생존기간 1개월
	            cookie.setMaxAge(60*60*24*30);   //각 브라우저 쿠키 삭제의 영향을 받는다
	            
	         }else{
	            cookie=new Cookie("c_id", "");
	            cookie.setMaxAge(0);
	         }//if end
	         
	         resp.addCookie(cookie);   //요청한 사용자 PC에 쿠키값을 저장
	         
	         
	         String msg="<h2>로그인 결과</h2><p>로그인 성공</p>";
	         mav.addObject("msg", msg);
	         
	      }
	      
	      mav.setViewName("m_manage/msgView");
	      
	      return mav;
	   }
	
	@RequestMapping(value = "/member_retire.do", method = RequestMethod.GET)
	public String member_retire() {
		return "m_manage/member_retire";
	}
	
	@RequestMapping(value = "/member_retire.do", method = RequestMethod.POST)
	public ModelAndView mem_reitreProc(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("m_manage/msgView");
		 HttpSession session = req.getSession();
	     String mem_id=session.getAttribute("s_mem_id").toString();
	     String mem_pw = req.getParameter("mem_pw");
		
		int cnt = dao.delete(mem_id, mem_pw);
		
		if(cnt==0) {
			String msg="<p>회원 탈퇴 실패</p>";
			String link1="<input type='button' value='다시시도' onclick='javascript:history.back()'>";
            String link2="<input type='button' value='홈' onclick='location.href=\"mem_retire.do\"'>";
            mav.addObject(msg);
            mav.addObject(link1);
            mav.addObject(link2);
		}else {
			String msg="<p>회원 탈퇴 성공</p>";
			String link2="<input type='button' value='홈' onclick='location.href=\"home.do\"'>";
			mav.addObject("msg", msg);
			mav.addObject("link2", link2);   
			
			session.removeAttribute("s_mem_id");
			session.removeAttribute("s_mem_pw");
			session.removeAttribute("s_mem_lv");
		}
		
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
	
	
	@RequestMapping("find_info.do")
	public String find_info() {
		return "m_manage/find_info";
	}
	
	@RequestMapping(value = "/findidscr.do", method = RequestMethod.GET)
	public String find_id_form() {
		return "m_manage/findidscr";
	}
	
	@RequestMapping(value = "/findpwscr.do", method = RequestMethod.GET)
	public String find_pw_form() {
		return "m_manage/findpwscr";
	}
	
	@RequestMapping(value="/IdCheck.do", method = RequestMethod.POST)
	public void idcheck(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			String mem_id = req.getParameter("mem_id");
			PrintWriter out=resp.getWriter();
			
			memberDAO dao = new memberDAO();
			
			int result = dao.ckId(mem_id);
			if(result ==1){
				System.out.println("사용가능한 아이디입니다");
			}else if(result == 0){
				System.out.println("중복된 아이디입니다");
			}
			System.out.println(result);
			out.write(result + "");
			out.flush(); 
            out.close();
            
		}catch (Exception e) {
			System.out.println("응답실패: " + e);
		}
	}
}
