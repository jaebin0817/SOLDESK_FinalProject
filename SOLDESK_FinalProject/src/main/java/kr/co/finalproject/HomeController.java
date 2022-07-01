package kr.co.finalproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.contlist.ContlistDAO;
import kr.co.finalproject.contlist.WatchListDAO;
import kr.co.finalproject.search.SearchKeyDAO;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("-----HomeController() 객체 생성");
	}//constructor end

	//결과확인 http://localhost:9090/home.do
	@RequestMapping("home.do")
	public ModelAndView home() {
		ModelAndView mav=new ModelAndView();
		ContlistDAO dao=new ContlistDAO();
		WatchListDAO watchdao=new WatchListDAO();
		SearchKeyDAO searchdao=new SearchKeyDAO();
		
		mav.addObject("list", dao.contlistAll());
		mav.addObject("rank", watchdao.rankRead());
		mav.addObject("keywords", searchdao.readRandom());
		mav.setViewName("index");
		return mav;
	}//home() end

	
	//결과확인 http://localhost:9090/test.do
	@RequestMapping("test.do")
	public ModelAndView test() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("test");
		return mav;
	}//home() end
	
	
	//결과확인 http://localhost:9090/home3.do
	@RequestMapping("home3.do")
	public ModelAndView home3() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index_v3");
		return mav;
	}//home() end
	
	
}//class end