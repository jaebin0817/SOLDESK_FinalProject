package kr.co.finalproject.contlistgroup;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContlistController {
	
	ContlistDAO dao = null;
	
	public ContlistController() {
		
		dao = new ContlistDAO();
		System.out.println("----ContlistController() 객체 생성");
	}// constructor end


	
	
	   @RequestMapping("/contlist/contlist.do")
	   public ModelAndView contlist() {
	      ModelAndView mav=new ModelAndView();
	            
	      ArrayList<ContlistDTO> list=null;
	      
	      list=dao.contlistall();
	      
	      mav.setViewName("contlist/contlist");
	      mav.addObject("list", list);
	      
	      return mav;
	   }
	
	
}// class end
