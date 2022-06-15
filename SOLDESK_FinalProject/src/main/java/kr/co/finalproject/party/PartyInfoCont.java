package kr.co.finalproject.party;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PartyInfoCont {
	
	PartyInfoDAO dao=null;
	
	public PartyInfoCont() {
		dao=new PartyInfoDAO(); 
		System.out.println("-----PartyInfoCont() 객체 생성");
	}//constructor end
	
	//결과확인 http://localhost:9090/party/partyadd.do
	@RequestMapping(value = "party/partyadd.do",  method = RequestMethod.GET)
	public String partyadd() {
		return "party/partyadd";
	}//partyadd() end
	

	@RequestMapping(value = "party/partyadd.do",  method = RequestMethod.POST)
	public ModelAndView partyadd(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		
		String ott_name=req.getParameter("ott_name");
		String party_role=req.getParameter("party_role");
		int ott_price=0;
		
		//OTT테이블 만들까..?? 로고랑 해서..??
		if(ott_name.equals("netflix")) {
			ott_price=17000;
		}else if(ott_name.equals("tving")) {
			ott_price=13900;
		}else if(ott_name.equals("watcha")) {
			ott_price=12900;
		}else if(ott_name.equals("disney")) {
			ott_price=9900;
		}

		mav.addObject("ott_name", ott_name);
		mav.addObject("ott_price", ott_price);
		
		if(party_role.equals("party_host")) {
			
			mav.setViewName("party/host/intro");
			
		}else if(party_role.equals("party_member")) {
			
			mav.setViewName("party/member");
			
		}
		
		return mav;
		
	}//partyadd() end
	
	
	
	
	
	
	
	
	@RequestMapping(value = "host/payback.do",  method = RequestMethod.POST)
	public ModelAndView payback(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		
		/*
		String ott_name=req.getParameter("ott_name");
		int ott_price=Integer.parseInt(req.getParameter("ott_price"));
		
		int service_fee=400; //파티장 수수료
		
		int payback_amount=0;
		
		payback_amount=(ott_price/4)*3-service_fee;
		
		mav.addObject("service_fee", service_fee);
		mav.addObject("ott_name", ott_name);
		mav.addObject("ott_price", ott_price);
		mav.addObject("payback_amount", payback_amount);
		*/
		
		mav.setViewName("redirect:/party/host/payback.jsp");
		//mav.setViewName("party/host/payback");
		//mav.setViewName("payback");
		//mav.setViewName("../../party/host/payback");
		
		//return "/payback";
		//return "host/payback";
		
		return mav;
		
		
	}//payback() end
	
	
	
	
	@RequestMapping(value = "host/account.do",  method = RequestMethod.POST)
	public ModelAndView account(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("party/host/accountInsert");//등록된 계좌가 없으면 insert로
		
		//mav.setViewName("party/host/accountUpdate"); //등록된 계좌가 있으면 update로
	
		return mav;
		
	}//payback() end
	
	
	
	
	
	
	
	
	
	
	
	//결과확인 http://localhost:9090/party/host/checkoutTest.do
	@RequestMapping("party/host/checkoutTest.do")
	public String checkoutTest() {
		return "party/host/checkout";
	}//partyadd() end
	
	
	
	@RequestMapping("party/host/create.do")
	public ModelAndView create(@ModelAttribute PartyInfoDTO dto) {

		ModelAndView mav=new ModelAndView();
		mav.setViewName("party/host/msgView");
		
		int cnt=dao.insert(dto);
	
		if(cnt==0) {
			
			String msg="<p>파티 등록 실패</p>";
			mav.addObject("msg", msg);

		
		}else {
			
			String msg="<p>파티 등록 성공</p>";
			mav.addObject("msg", msg);
			
		}//if end
		
		return mav;
	
	}//partyadd() end
	
	
	
	

	
	
	
	
}//class end
