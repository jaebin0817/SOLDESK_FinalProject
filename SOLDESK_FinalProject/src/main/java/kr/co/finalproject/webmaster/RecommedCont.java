package kr.co.finalproject.webmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecommedCont {

	RecommedDAO dao = null;
	
	public RecommedCont() {		
	  dao = new RecommedDAO();
      System.out.println("-----RecommedCont() 객체 생성");				
	}
	
	@RequestMapping("themelist.do")
	public String themeList() {
		return "webmaster/recmanage/themeList";
	}
	
	@RequestMapping("themeadd.do")
	public String themeAdd() {
		return "webmaster/recmanage/themeAdd";
	}

	@RequestMapping("recadd.do")
	public String recAdd() {
		return "webmaster/recmanage/recForm";
	}
	
	
	
	
}//class end
