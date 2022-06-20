package kr.co.finalproject.contlistgroup;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.review.ReviewDAO;
import kr.co.finalproject.review.ReviewDTO;

@Controller
public class ContlistController {

	ContlistDAO dao = null;
	ReviewDAO dao2 = null;

	public ContlistController() {

		dao = new ContlistDAO();
		dao2 = new ReviewDAO();
		System.out.println("----ContlistController() 객체 생성");
	}// constructor end

	@RequestMapping("/contlist/contlist.do")
	public ModelAndView contlist() {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<ContlistDTO> list = null;

		list = dao.contlistall();
		mav.setViewName("contlist/contlist");
		mav.addObject("list", list);

		return mav;
	}

	@RequestMapping("contlist/contlistread.do")
	   public ModelAndView contlistread(ContlistDTO dto, ReviewDTO dto2,HttpServletRequest req) {
	      ModelAndView mav=new ModelAndView();
	      int mcode=Integer.parseInt(req.getParameter("mcode"));
	
	      
	      dto=dao.contlistread(mcode);
	      dto2=dao2.reviewAll(mcode);
	      
	      mav.setViewName("contlist/contlistread");
	      mav.addObject("dto", dto);
	      mav.addObject("dto2", dto2);
	      
	      return mav;
	   }

}// class end
