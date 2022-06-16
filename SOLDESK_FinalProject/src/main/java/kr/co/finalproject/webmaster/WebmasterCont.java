package kr.co.finalproject.webmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.party.PartyInfoDAO;
import kr.co.finalproject.party.PartyInfoDTO;

@Controller
public class WebmasterCont {

	private PartyInfoDAO partydao = null;
	
	public WebmasterCont() {
		partydao = new PartyInfoDAO();
		System.out.println("-----WebmasterCont() 객체 생성");
	}
	
	
	@RequestMapping("webmaster/webmaster.do")
	public String webmaster() {
		return "webmaster/webmaster";
	}
	
	
	@RequestMapping("/partylist.do")
	public ModelAndView partylist(PartyInfoDTO partyDTO) {
		ModelAndView mav=new ModelAndView();
				
		mav.setViewName("webmaster/partymanage/partylist");
		mav.addObject("list", partydao.partylist());
		
		return mav;
	}
	
	
	
	
	
	
	
}
