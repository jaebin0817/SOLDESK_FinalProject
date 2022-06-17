package kr.co.finalproject.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberCont {
	
	private memberDAO dao = null;
	
	public MemberCont() {
		dao = new memberDAO();
		System.out.println("-----MemberContr() 객체 생성");
	}
	
	@RequestMapping(value = "/m_manage/member_info.do", method = RequestMethod.GET)
	public ModelAndView member_info(String mem_id) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("m_manage/member_info");
		memberDTO dto = dao.read(mem_id);
		mav.addObject("dto", dto);
		return mav;	
	}
	
	@RequestMapping(value = "/m_manage/member_info.do", method = RequestMethod.POST)
	public ModelAndView member_infoProc(@ModelAttribute memberDTO dto,  HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("m_manage/member_info");
		
		int cnt = dao.update(dto);
		if(cnt==0) {
			String msg="<p>회원 정보 수정 실패</p>";
			String link1="<input type='button' value='다시시도' onclick='javascript:history.back()'>";
            String link2="<input type='button' value='마이페이지' onclick='location.href=\"mypage.do\"'>";
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
	
	
	
}
