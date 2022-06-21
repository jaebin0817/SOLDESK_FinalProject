package kr.co.finalproject.webmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.member.MemberDAO;
import kr.co.finalproject.member.MemberDTO;
import kr.co.finalproject.party.PartyInfoDAO;
import kr.co.finalproject.party.PartyInfoDTO;
import kr.co.finalproject.party.PartyMemberDAO;

@Controller
public class WebmasterCont {

	private PartyInfoDAO partydao = null;
	private PartyMemberDAO partymemdao = null;
	private MemberDAO memberdao = null;
	
	public WebmasterCont() {
		partydao = new PartyInfoDAO();
		partymemdao = new PartyMemberDAO();
		memberdao = new MemberDAO();
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
	
	
	@RequestMapping("/partyread.do")
	public ModelAndView partyread(int party_id) {
		ModelAndView mav=new ModelAndView();
				
		PartyInfoDTO partyDTO=null;
		
		partyDTO=partydao.partyread(party_id);
		
		mav.setViewName("webmaster/partymanage/partyread");
		mav.addObject("partyDTO", partyDTO);
		mav.addObject("list", partymemdao.readParty(party_id));
		
		return mav;
	}
	
	
	@RequestMapping("/memberlist.do")
	public ModelAndView memberlist(MemberDTO dto) {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("webmaster/membermanage/memberlist");
		mav.addObject("dto", dto);
		mav.addObject("list", memberdao.memberlist());
		
		return mav;
	}
	
	
	
	
	
	
}
