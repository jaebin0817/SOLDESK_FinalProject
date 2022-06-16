package kr.co.finalproject.party;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
			
			mav.setViewName("party/member/memberIns");
			
		}
		
		return mav;
		
	}//partyadd() end
	
	
	@RequestMapping(value = "party/host/payback.do", method = RequestMethod.POST)
	public ModelAndView payback(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		
		String ott_name=req.getParameter("ott_name");
		int ott_price=Integer.parseInt(req.getParameter("ott_price"));
		
		int service_fee=400; //파티장 수수료
		
		int payback_amount=0;
		int payback_day=0;
		int first_payback_month=0;
		
		payback_amount=(ott_price/4)*3-service_fee;
		
		GregorianCalendar now=new GregorianCalendar();
		payback_day=now.get(Calendar.DATE);
		first_payback_month=now.get(Calendar.MONTH)+2;
		
		mav.addObject("service_fee", service_fee);
		mav.addObject("ott_name", ott_name);
		mav.addObject("ott_price", ott_price);
		mav.addObject("payback_amount", payback_amount);
		mav.addObject("payback_day", payback_day);
		mav.addObject("first_payback_month", first_payback_month);

		mav.setViewName("party/host/payback");
		
		return mav;
		
	}//payback() end
	
	
	
	
	@RequestMapping(value = "party/host/account.do",  method = RequestMethod.POST)
	public ModelAndView account(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		PartyInfoDTO dto=null;
		
		String s_mem_id="";//실제로는 session정보 받아올것
		
		dto=dao.readBank(s_mem_id);
		
		if(dto==null) {	
			mav.setViewName("party/host/accountInsert");//등록된 계좌가 없으면 insert로
			
		}else {
			mav.setViewName("party/host/accountUpdate");//등록된 계좌가 있으면 update로
		}
		
		String ott_name=req.getParameter("ott_name");
		int ott_price=Integer.parseInt(req.getParameter("ott_price"));
		int payback_amount=Integer.parseInt(req.getParameter("payback_amount"));
		
		mav.addObject("ott_name", ott_name);
		mav.addObject("ott_price", ott_price);
		mav.addObject("payback_amount", payback_amount);
		
		return mav;
		
	}//account() end
	
	
	
	@RequestMapping(value = "party/host/ottinfo.do",  method = RequestMethod.POST)
	public ModelAndView ottinfo(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		
		String ott_name=req.getParameter("ott_name");
		int ott_price=Integer.parseInt(req.getParameter("ott_price"));
		int payback_amount=Integer.parseInt(req.getParameter("payback_amount"));
		String bank_name=req.getParameter("bank_name").trim();
		String bank_account=req.getParameter("bank_account").trim();
		
		mav.addObject("ott_name", ott_name);
		mav.addObject("ott_price", ott_price);
		mav.addObject("payback_amount", payback_amount);
		mav.addObject("bank_name", bank_name);
		mav.addObject("bank_account", bank_account);
		
		mav.setViewName("party/host/ottinfo");
		
		return mav;
		
	}//ottinfo() end
	
	
	@RequestMapping(value = "party/host/checkout.do",  method = RequestMethod.POST)
	public ModelAndView checkout(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		
		String s_mem_id="";//실제로는 session정보 받아올것
		
		String ott_name=req.getParameter("ott_name");
		int ott_price=Integer.parseInt(req.getParameter("ott_price"));
		int payback_amount=Integer.parseInt(req.getParameter("payback_amount"));
		String bank_name=req.getParameter("bank_name").trim();
		String bank_account=req.getParameter("bank_account").trim();
		String ott_id=req.getParameter("ott_id").trim();
		String ott_pw=req.getParameter("ott_pw").trim();

		
		mav.addObject("ott_name", ott_name);
		mav.addObject("ott_price", ott_price);
		mav.addObject("payback_amount", payback_amount);
		mav.addObject("bank_name", bank_name);
		mav.addObject("bank_account", bank_account);
		mav.addObject("ott_id", ott_id);
		mav.addObject("ott_pw", ott_pw);
		mav.addObject("s_mem_id", s_mem_id);
		
		mav.setViewName("party/host/checkout");
		
		return mav;
		
	}//checkout() end
	

	
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
