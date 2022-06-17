package kr.co.finalproject.contlist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContlistController {

	public ContlistController() {
		System.out.println("-----ContlistCont() 객체 생성");
	}// constructor end


	// 결과확인 http://localhost:9090/contlist.do
	@RequestMapping("/contlist/contlist.do")
	public ModelAndView contlist() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contlist/contlist");
		return mav;
	}// contlist() end

	// 결과확인 http://localhost:9090/contlist.do
	@RequestMapping("/contlist/contlist_1.do")
	public ModelAndView contlist_1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contlist/contlist_1");
		return mav;
	}// contlist_1() end
	
	// 결과확인 http://localhost:9090/contlist.do
	@RequestMapping("/contlist/contlist_2.do")
	public ModelAndView contlist_2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contlist/contlist_2");
		return mav;
	}// contlist_1() end

}// class end