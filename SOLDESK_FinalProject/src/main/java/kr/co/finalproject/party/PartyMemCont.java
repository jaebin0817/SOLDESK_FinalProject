package kr.co.finalproject.party;

import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PartyMemCont {

	PartyMemDAO dao=new PartyMemDAO();
	PartyMatchDAO dao2 = new PartyMatchDAO();
	PartyInfoDAO dao3 = new PartyInfoDAO();
	PartyMemberDAO dao4 = new PartyMemberDAO();

	public PartyMemCont() {
		System.out.println("-----PartyMemCont() 객체 생성");
	}//end

	//결과확인 http://localhost:9090/party/member.do
	/*
	@RequestMapping(value = "party/member.do" , method = RequestMethod.GET)
	public String memberCard() {
		return "party/member/memberIns";
	}//memberCard()*/

	@RequestMapping(value = "party/member.do" , method = RequestMethod.POST)
	public ModelAndView memberaccount(@ModelAttribute PartyMemDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
			
		String ott_name=req.getParameter("ott_name");
		int ott_price=Integer.parseInt(req.getParameter("ott_price"));
		
		int service_fee=500; //파티원 수수료
		
		int payback_amount=0;
		int party_pcost=0;
		
		payback_amount=(ott_price/4)*3;
		
		party_pcost=(ott_price/4)*1+service_fee;
		
		mav.addObject("ott_name", ott_name);
		mav.addObject("ott_price", ott_price);
		mav.addObject("party_pcost", party_pcost);
		mav.addObject("payback_amount", payback_amount);
		
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
            mav.addObject("msg", msg);
            mav.setViewName("party/member/msgView");
		}else {
			mav.setViewName("party/member/memberMatch");
		}//if end
		return mav;
	}//memberMatch() end
	
	@RequestMapping(value = "party/membermatch.do" , method = RequestMethod.POST)
	public ModelAndView memberMatchWait(@ModelAttribute  PartyMatchDTO dto, PartyInfoDTO dto2 , PartyMemberDTO dto3, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		
		
		String ott_name=req.getParameter("ott_name");
		int ott_price=Integer.parseInt(req.getParameter("ott_price"));
		String mem_id=req.getParameter("mem_id");//세션변수
		int party_pcost=Integer.parseInt(req.getParameter("party_pcost"));

		Date now = new Date();
	    SimpleDateFormat dateFrm = new SimpleDateFormat("yyyyMMddHHmmss");

	    String dateToStr = dateFrm.format(now);
		
	    String party_ordnumber= dateToStr;
	    
	    /*
		for(int i=0; i<=8000; i++) {
			if(cnt3==0) {
				int
			} 누군가 심심하면 고쳐줘~~
			String party_ordnumber= dateToStr+i;
			
		}//for end
		*/
	    dto3.setParty_ordnumber(party_ordnumber);
	    dto3.setParty_pcost(party_pcost);
	    dto3.setMem_id(mem_id);//세션으로 아이디 가져오기
	    
		
		mav.addObject("ott_name", ott_name);
		mav.addObject("ott_price", ott_price);
		mav.addObject("party_pcost", party_pcost);
		mav.addObject("party_ordnumber", party_ordnumber);
		mav.addObject("mem_id",mem_id);
		
		dto.setMem_id(mem_id);//세션으로 아이디 가져오기
		
		dto2=dao3.read(ott_name);
		if(dto2==null){
			int cnt=dao2.memberwait(dto);
			if(cnt==0) {
	            String msg="<h3>매칭 대기 실패</h3>";
	            mav.addObject("msg", msg);
	            mav.setViewName("party/member/msgView");
			}else {
	            mav.setViewName("party/member/memberMatching");
			}//if end
		}else {
			int cntmatch=dao3.match(dto2);
			if(cntmatch==0) {
				String msg="<p>매칭 실패</p>";
	            mav.addObject("msg", msg);
	            mav.setViewName("party/member/msgView");
			}else {
				int result=dao4.ordersheet(dto2, dto3);
				if(result==0){
					String msg="<p>매칭만 성공 되었습니다 주문서 발급은 아직입니다</p>";
		            mav.addObject("msg", msg);
		            mav.setViewName("party/member/msgView");
				}else {
		            mav.setViewName("party/member/memberMatched");
				}//if end
			}//if end
			
		}//if end			
		
		return mav;
	}//memberMatch end
	

}//class end