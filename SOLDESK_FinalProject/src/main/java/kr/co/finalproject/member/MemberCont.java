package kr.co.finalproject.member;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.contentcri.ContentcriDAO;
import kr.co.finalproject.contentcri.ContentcriDTO;
import kr.co.finalproject.contlist.ContlistDTO;
import kr.co.finalproject.contlist.WatchListDAO;
import kr.co.finalproject.contlist.WatchListDTO;
import kr.co.finalproject.search.SearchKeyDAO;
import net.utility.Utility;


@Controller
public class MemberCont {

	private MemberDAO dao = null;
	private SubscribeInfoDAO subdao =null;
	private WatchListDAO watchdao=null;
	private SearchKeyDAO skdao =null;
	private ContentcriDAO cridao = null;

	public MemberCont() {
		dao = new MemberDAO();
		subdao = new SubscribeInfoDAO();
		watchdao = new WatchListDAO();
		skdao = new SearchKeyDAO();
		cridao = new ContentcriDAO();
		System.out.println("-----MemberCont() 객체 생성");
	}

	
	@RequestMapping("/m_manage/mypage.do")
	public String mypage() {
		return "m_manage/mypage";
	}
	
	
	@RequestMapping("/m_manage/member_info.do")
	public String member_info() {
		return "m_manage/member_info";
	}
	
	
	//http://localhost:9090/login.do
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest req) {
		
		ModelAndView mav =new ModelAndView();
		
		Cookie[] cookies=req.getCookies();//사용자 PC에 저장된 모든 쿠키값 가져오기
		String c_id="";
		
		if(cookies!=null){//쿠키가 존재하는지?
			for(int i=0; i<cookies.length; i++){ //모든 쿠키값을 검색함
				Cookie cookie=cookies[i];		 //쿠키 하나씩 가져오기
				if(cookie.getName().equals("c_id")==true){
					c_id=cookie.getValue();		 //쿠키변수값 가져오기
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
				cookie.setMaxAge(60*60*24*30);	//각 브라우저 쿠키 삭제의 영향을 받는다
				
			}else{
				cookie=new Cookie("c_id", "");
				cookie.setMaxAge(0);
			}//if end
			
			resp.addCookie(cookie);	//요청한 사용자 PC에 쿠키값을 저장
			
			
			String msg="<h2>로그인 결과</h2><p>로그인 성공</p>";
			mav.addObject("msg", msg);
			
		}
		
		mav.setViewName("m_manage/msgView");
		
		return mav;
	}

	
	@RequestMapping(value = "/logout.do", method = RequestMethod.POST)
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse resp) {
		
		ModelAndView mav =new ModelAndView();
		HttpSession session = req.getSession();
		
		session.removeAttribute("s_mem_id");
		session.removeAttribute("s_mem_pw");
		session.removeAttribute("s_mem_lv");
		
		mav.setViewName("redirect:/home.do");
		
		return mav;
	}

	
	
	@RequestMapping(value = "/m_manage/member_info.do", method = RequestMethod.GET)
	public ModelAndView member_info(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = req.getSession();
		String mem_id=session.getAttribute("s_mem_id").toString();
		
		mav.setViewName("m_manage/member_info");
		mav.addObject("dto", dao.read(mem_id));
		return mav;	
	}
	
	
	@RequestMapping(value = "member_info.do", method = RequestMethod.POST)
	public ModelAndView member_infoProc(@ModelAttribute MemberDTO dto, HttpServletRequest req) {
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
	
	
	@RequestMapping("/m_manage/member_bank.do")
	public String member_bank() {
		return "m_manage/member_bank";
	}
	
	
	@RequestMapping("/m_manage/mysubscribe.do")
	public ModelAndView mysubscribe(HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = req.getSession();
		
		String mem_id=(String) session.getAttribute("s_mem_id");
		
		mav.addObject("totalOttFee", subdao.totalPay(mem_id));
		mav.addObject("list", subdao.mySubread(mem_id));
		mav.setViewName("m_manage/mysubscribe");
		return mav;
	}
	
	
	@RequestMapping("/agreement.do")
	public String agreement() {
		return "m_manage/agreement";
	}
	
	
	@RequestMapping("/m_manage/mycontent.do")
	public String mycontent() {
		return "m_manage/mycontent";
	}
	
	
	@RequestMapping(value = "/member_join.do", method = RequestMethod.GET)
	public String memberjoin() {
		return "m_manage/member_join";
	}
	

	@RequestMapping(value = "/member_join.do", method = RequestMethod.POST)
	public ModelAndView member_joinProc(@ModelAttribute MemberDTO dto, HttpServletRequest req) {
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
	
	@RequestMapping(value = "/likecontent.do", method = RequestMethod.GET)
	public ModelAndView likecontent(HttpServletRequest req, ContentcriDTO dto) {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		String mem_id=session.getAttribute("s_mem_id").toString();
		
		List<ContlistDTO> likelist = new ArrayList<>();
		likelist = cridao.likecontent(mem_id);
		
		mav.setViewName("m_manage/content/likecontent");
		mav.addObject("like_list", likelist);
		
		return mav;
	}
	
	@RequestMapping(value = "/pointcontent.do", method = RequestMethod.GET)
	public ModelAndView pointcontent(HttpServletRequest req, ContentcriDTO dto) {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = req.getSession();
		String mem_id=session.getAttribute("s_mem_id").toString();
		
		List<ContlistDTO> pointlist = new ArrayList<>();
		pointlist = cridao.pointcontent(mem_id);
		
		mav.setViewName("m_manage/content/pointcontent");
		mav.addObject("point_list", pointlist);
		
		return mav;
	}
	
	@RequestMapping(value = "/watchlist.do", method = RequestMethod.GET)
	public ModelAndView watchlist(HttpServletRequest req, WatchListDTO dto) {
		
		watchdao = new WatchListDAO();
		
		ModelAndView mav=new ModelAndView();
	    HttpSession session = req.getSession();
        String mem_id=session.getAttribute("s_mem_id").toString();
        
        //가장 많이 본 장르 읽어오기
        ArrayList<String> genrelist=new ArrayList<String>();
        genrelist=watchdao.genreRead(mem_id);
        
        //System.out.println(genrelist);
        int size=genrelist.size();
        
		Set<String> set = new HashSet<String>(genrelist);        				
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (String str : set) {
			int count = Collections.frequency(genrelist, str);
			map.put(str, count);
		}

		ArrayList<String> gernes= new ArrayList<String>();
		ArrayList<Integer> ratios= new ArrayList<Integer>();
		
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
		    @Override
		    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
			return o2.getValue() - o1.getValue();
		    }
		});
		
		int i=1;
		int sum=0;
		for(Map.Entry<String, Integer> entry : entryList){

			gernes.add(entry.getKey());
			double dratio=Math.round((entry.getValue()/(double)size)*100.0);
			int ratio=(int)dratio;
			ratios.add(ratio);
			sum+=ratio;
			i++;
			
			if(i>4) { 
				gernes.add("기타");
				ratios.add(100-sum);
				break; 
			}
		}
        
		ArrayList<String> key_names= new ArrayList<String>();		
		for(int idx=0; idx<gernes.size(); idx++) {
			
			if(idx==4) {
				key_names.add("기타");
				break;
			}
			
			key_names.add(skdao.SearchKeyAll(gernes.get(idx)));			
		}
		
		
		mav.setViewName("m_manage/content/watchlist");
		mav.addObject("mem_id", mem_id);
		mav.addObject("gernes", gernes);
		mav.addObject("ratios", ratios);
		mav.addObject("key_names", key_names);		
		mav.addObject("watchlist", watchdao.watchread(mem_id));

		return mav;
		
	}
	
	@RequestMapping("find_info.do")
	public String find_info() {
		return "m_manage/find_info";
	}
	
	@RequestMapping(value = "/findidscr.do", method = RequestMethod.GET)
	public String findid_form() {
		return "m_manage/findidscr";
	}
	
	@RequestMapping(value="/find_id.do", method = RequestMethod.POST)
	public void findid_Proc(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			String mem_email = req.getParameter("mem_email");
			String mem_phone = req.getParameter("mem_phone");
			PrintWriter out = resp.getWriter();
			
			MemberDAO dao = new MemberDAO();
			
			int result = dao.findId(mem_phone, mem_email);
			if(result == 0) {
				System.out.println("아이디를 찾았습니다.");
			}else {
				System.out.println("아이디가 없습니다.");
			}
			
			System.out.println(result);
			out.write(result + "");
			out.flush(); 
            out.close();
			
		}catch(Exception e) {
			System.out.println("서버 연결 실패");
		}
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
			
			MemberDAO dao = new MemberDAO();
			
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
	
	
	@RequestMapping(value="/EmailCheck.do", method = RequestMethod.POST)
	public void emailcheck(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			String mem_email = req.getParameter("mem_email");
			PrintWriter out=resp.getWriter();
			
			MemberDAO dao = new MemberDAO();
			
			int result = dao.ckEmail(mem_email);
			if(result ==1){
				System.out.println("사용가능한 이메일입니다");
			}else if(result == 0){
				System.out.println("중복된 이메일입니다");
			}
			System.out.println(result);
			out.write(result + "");
			out.flush(); 
            out.close();
            
		}catch (Exception e) {
			System.out.println("응답실패: " + e);
		}
	}
	
		
		
	
}//class end