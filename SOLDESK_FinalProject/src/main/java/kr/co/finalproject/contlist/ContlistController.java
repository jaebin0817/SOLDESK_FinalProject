package kr.co.finalproject.contlist;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.review.ReviewDAO;
import kr.co.finalproject.review.ReviewDTO;
import kr.co.finalproject.search.SearchKeyDAO;
import kr.co.finalproject.search.SearchKeyDTO;

@Controller
public class ContlistController {

   ContlistDAO dao = null;
   ReviewDAO dao2 = null;
   SearchKeyDAO dao3 = null;

   public ContlistController() {
      dao = new ContlistDAO();
      dao2 = new ReviewDAO();
      dao3 = new SearchKeyDAO();
      System.out.println("-----ContlistCont() 객체 생성");
      System.out.println("-----ReviewDAO() 객체 생성");
      System.out.println("-----SearchKeyDAO() 객체 생성");
   }// constructor end

   @RequestMapping("/contlist/contlist.do")
   public ModelAndView contlist() {
      ModelAndView mav = new ModelAndView();

      ArrayList<ContlistDTO> list = null;

      list = dao.contlistAll();

      mav.setViewName("contlist/contlist");
      mav.addObject("list", list);

      return mav;
   }

   @RequestMapping("contlist/contlistread.do")
   public ModelAndView contlistread(ContlistDTO dto, ReviewDTO dto2, SearchKeyDTO dto3, HttpServletRequest req) {
      ModelAndView mav = new ModelAndView();
      int mcode = Integer.parseInt(req.getParameter("mcode"));
      
      dto=dao.contlistread(mcode);
      String key_code = dto.getKey_code();
      ArrayList<String> keycodelist=new ArrayList<String>() ;
      StringTokenizer kc = new StringTokenizer(key_code, " || ");
      
      while(kc.hasMoreTokens()) { //토큰할 문자가 있는지?
          
    	  keycodelist.add(kc.nextToken());
    	  
      }

      ArrayList<String> keylist=new ArrayList<String>() ;
      StringTokenizer st = new StringTokenizer(key_code, " || ");
      while(st.hasMoreTokens()) { //토큰할 문자가 있는지?
          
    	  keylist.add(dao3.SearchKeyAll(st.nextToken()));
    	  
      }
      
      dto2 = dao2.reviewAll(mcode);
      mav.setViewName("contlist/contlistread");
      mav.addObject("dto", dto);
      mav.addObject("dto2", dto2);
      mav.addObject("keylist",keylist);
      mav.addObject("keycodelist",keycodelist);

      
      return mav;
   }

   
   @RequestMapping("contlist/search.do")
   public ModelAndView search(String key_name) {
      ModelAndView mav = new ModelAndView();

      ArrayList<ContlistDTO> list = null;
      
      String key_code=dao3.SearchKeyCode(key_name);
      
      list = dao.searchPart(key_code);

      mav.setViewName("contlist/contlist");
      mav.addObject("list", list);

      return mav;
   }
   
   
   
   
}// class end