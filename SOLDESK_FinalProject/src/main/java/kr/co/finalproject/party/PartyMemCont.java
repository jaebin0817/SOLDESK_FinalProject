<<<<<<< HEAD
package kr.co.finalproject.party;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PartyMemCont {
	
	PartyMemDAO dao=null;
	
	
	public PartyMemCont() {
		System.out.println("----PartyMemCont 객체생성");
	}//end
	
	//결과확인 http://localhost:9090/party/member.do
	@RequestMapping(value = "party/member.do" , method = RequestMethod.GET)
	public String memberCard() {
		return "party/member/memberIns";
	}//memberCard()
	
	@RequestMapping(value = "party/member.do" , method = RequestMethod.POST)
	public ModelAndView memberMatch(@ModelAttribute PartyMemDTO dto, HttpServletRequest req, HttpServletResponse resp) {
		
		String card_m = req.getParameter("card_m");
		String card_y = req.getParameter("card_y");
		String card_exp= card_m + "/" + card_y;
		dto.setCard_exp(card_exp);		
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("party/member/memberMatch");
		
		int cnt=dao.cardIns(dto);
		if(cnt==0) {
            String msg="<p>카드 등록 실패</p>";
            String link1="<input type='button' value='다시시도' onclick='javascript:history.back()'>";
            String link2="<input type='button' value='그룹목록' onclick='location.href=\"member.do\"'>";
            mav.addObject("msg", msg);
            mav.addObject("link1", link1);
            mav.addObject("link2", link2);
		}else {
            String msg="<p>카드 등록 성공</p>";
            String link1="<input type='button' value='계속등록' onclick='location.href=\"create.do\"'>";
            String link2="<input type='button' value='그룹목록' onclick='location.href=\"member.do\"'>";
            mav.addObject("msg", msg);
            mav.addObject("link1", link1);
            mav.addObject("link2", link2); 
		}//if end
		
		
		
		
		return mav;
	}//memberMatch() end

}//class end
=======
package kr.co.finalproject.party;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PartyMemCont {

	PartyMemDAO dao=new PartyMemDAO();
	PartyMatchDAO dao2 = new PartyMatchDAO();


	public PartyMemCont() {
		System.out.println("-----PartyMemCont() 객체 생성");
	}//end

	//결과확인 http://localhost:9090/party/member.do
	@RequestMapping(value = "party/member.do" , method = RequestMethod.GET)
	public String memberCard() {
		return "party/member/memberIns";
	}//memberCard()

	@RequestMapping(value = "party/member.do" , method = RequestMethod.POST)
	public ModelAndView memberaccount(@ModelAttribute PartyMemDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("party/member/memberMatch");
		
		String ott_name=req.getParameter("ott_name");
		int ott_price=Integer.parseInt(req.getParameter("ott_price"));
		mav.addObject("ott_name", ott_name);
		mav.addObject("ott_price", ott_price);
		
		String mem_id="kimkim12";//session정보 받아오기
		
		String card_m = req.getParameter("card_m");
		String card_y = req.getParameter("card_y");
		String card_exp= card_m + "/" + card_y;
		dto.setCard_exp(card_exp);
		dto.setMem_id(mem_id);
		
		mav.addObject("mem_id",mem_id);

		int cnt=dao.cardIns(dto);
		if(cnt==0) {
            String msg="<p>카드 등록 실패</p>";
            String link1="<input type='button' value='다시시도' onclick='javascript:history.back()'>";
            String link2="<input type='button' value='그룹목록' onclick='location.href=\"member.do\"'>";
            mav.addObject("msg", msg);
            mav.addObject("link1", link1);
            mav.addObject("link2", link2);
		}else {
            String msg="<p>카드 등록 성공</p>";
            String link1="<input type='button' value='계속등록' onclick='location.href=\"create.do\"'>";
            String link2="<input type='button' value='그룹목록' onclick='location.href=\"member.do\"'>";
            mav.addObject("msg", msg);
            mav.addObject("link1", link1);
            mav.addObject("link2", link2); 
		}//if end
		return mav;
	}//memberMatch() end
	
	@RequestMapping(value = "party/membermatch.do" , method = RequestMethod.POST)
	public ModelAndView memberMatch(@ModelAttribute  PartyMatchDTO dto , HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("party/member/memberMatching");
		
		String ott_name=req.getParameter("ott_name");
		int ott_price=Integer.parseInt(req.getParameter("ott_price"));
		String mem_id=req.getParameter("mem_id");
		mav.addObject("ott_name", ott_name);
		mav.addObject("ott_price", ott_price);
		
		dto.setMem_id(mem_id);
		
		int cnt=dao2.memberwait(dto);
		if(cnt==0) {
            String msg="<p>매칭 대기 실패</p>";
            mav.addObject("msg", msg);
		}else {
            String msg="<p>매칭 대기등록 성공</p>";
            mav.addObject("msg", msg);
		}//if end
		
		return mav;
	}//memberMatch

}//class end
>>>>>>> branch 'main' of https://github.com/jaebin0817/SOLDESK_FinalProject.git
