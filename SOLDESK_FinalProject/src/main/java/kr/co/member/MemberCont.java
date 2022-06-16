package kr.co.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberCont {
	
	private memberDAO dao = null;
	
	public MemberCont() {
		dao = new memberDAO();
		System.out.println("-----MemberController() 객체 생성");
	}
	
	@RequestMapping("/m_manage/member_info.do")
	public String member_info() {
		return "m_manage/member_info";
	}
}
