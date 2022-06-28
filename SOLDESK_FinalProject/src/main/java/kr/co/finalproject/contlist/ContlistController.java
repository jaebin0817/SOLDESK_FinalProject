package kr.co.finalproject.contlist;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
   WatchListDAO dao4 = null;

   
   public ContlistController() {
      dao = new ContlistDAO();
      dao2 = new ReviewDAO();
      dao3 = new SearchKeyDAO();
      dao4 = new WatchListDAO();
      System.out.println("-----ContlistCont() 객체 생성");
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
      HttpSession session = req.getSession();

      
      while(kc.hasMoreTokens()) { //토큰할 문자가 있는지?
          
    	  keycodelist.add(kc.nextToken());
    	  
      }
      
      ArrayList<String> keylist=new ArrayList<String>() ;
      for(int i=0; i<keycodelist.size(); i++) {
    	  keylist.add(dao3.SearchKeyAll(keycodelist.get(i)));

      }
      
      
      if(session.getAttribute("s_mem_id")!=null && session.getAttribute("s_mem_lv")!=null && session.getAttribute("s_mem_pw")!=null) {

			String mem_lv=session.getAttribute("s_mem_lv").toString();
			mav.addObject("mem_lv", mem_lv);    	  
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
      String msg=key_name+" : 검색 결과";
      
      list = dao.searchPart(key_code);

      mav.setViewName("contlist/contlist");
      mav.addObject("list", list);
      mav.addObject("msg", msg);

      return mav;
   }
   
   
   @RequestMapping(value = "contlist/contlistwatch.do", method = RequestMethod.POST)
   public ModelAndView create(ContlistDTO contdto, WatchListDTO dto, HttpServletRequest req) {
	   ModelAndView mav = new ModelAndView();
	   
       int mcode = Integer.parseInt(req.getParameter("mcode"));
      
       contdto=dao.contlist(mcode);
       String maudio=contdto.getMaudio(); 
	   
       mav.setViewName("contlist/contentwatch");
       mav.addObject("maudio", maudio);
	   
	   HttpSession session = req.getSession();
	   String mem_id=session.getAttribute("s_mem_id").toString();
	   
	   Date now = new Date();
	   SimpleDateFormat dateFrm = new SimpleDateFormat("yyyyMMddHHmmss");

	   String dateToStr = dateFrm.format(now);	   
	      
	   String watch_reg= dao4.watchregCreate(dateToStr);
	   
	   dto.setWatch_reg(watch_reg);
	   dto.setMem_id(mem_id);
	   
	   int cnt=dao4.create(dto);
		if(cnt==0) {
			System.out.println("시청 목록 등록 실패");
		}else {
			System.out.println("시청 목록 등록 성공");
		}//if end
	   
	   return mav;
   }
   
   
   @RequestMapping("mainsearch.do")
   public ModelAndView mainsearch(HttpServletRequest req) {
      ModelAndView mav = new ModelAndView();
      
      String searchkey=req.getParameter("searchkey").trim();
      String searchname=req.getParameter("searchkey").trim();
      searchname=searchname.replace(" ", "");
      
      String pno=dao.readPno(searchname);
      
      ArrayList<ContlistDTO> list = null;
      
      String msg=searchkey+" : 검색 결과";
      
      list = dao.mainsearch(searchkey, pno);

      mav.setViewName("contlist/contlist");
      mav.addObject("list", list);
      mav.addObject("msg", msg);

      return mav;
   }
   
   
   @RequestMapping("keysearch.do")
   public ModelAndView keysearch(HttpServletRequest req) {
      ModelAndView mav = new ModelAndView();
      
      String key_code=req.getParameter("key_code");
      String key_name=req.getParameter("key_name");

      
      ArrayList<ContlistDTO> list = null;
      
      String msg="#"+key_name+" : 검색 결과";
      
      list = dao.searchPart(key_code);

      mav.setViewName("contlist/contlist");
      mav.addObject("list", list);
      mav.addObject("msg", msg);

      return mav;
   }

   
   
	@RequestMapping("contlist/reviewForm.do")
	public ModelAndView rev_create(ContlistDTO dto, ReviewDTO dto2) {
		ModelAndView mav=new ModelAndView();		
		
		int mcode = dto2.getMcode();
		dto2 = dao2.reviewAll(mcode);
	
			mav.setViewName("contlist/reviewForm");
			mav.addObject("mcode", mcode);			
			mav.addObject("dto", dto);
			mav.addObject("dto2", dto2);

		return mav;

	}
	
	
	
	
	
	
	   @RequestMapping("/contlist/contlistAjax.do")
	   public ModelAndView contlistAjax(ContlistDTO dto) {
	      ModelAndView mav = new ModelAndView();

	      ArrayList<ContlistDTO> list = null;

	      list = dao.contlistAll();
	      /*
	      JSONObject obj = new JSONObject();
	      
	      JSONArray jArray = new JSONArray();
	      JSONParser parser = new JSONParser();
	      
	      for(int i=0; i<list.size(); i++) {
	    	  
	    	  JSONObject sObject = new JSONObject();
	    	  sObject.put("mtitle", list.get(i).getMtitle());
	    	  sObject.put("mthum", list.get(i).getMthum());
	    	  sObject.put("netflix", list.get(i).getNetflix());
	    	  sObject.put("watcha", list.get(i).getWatcha());
	    	  sObject.put("tving", list.get(i).getTving());
	    	  sObject.put("disney", list.get(i).getDisney());
	    	  sObject.put("mrate", list.get(i).getMrate());
	    	  jArray.add(sObject);
	    	  System.out.println(jArray);
	      }
	      */
	      
	      
	      mav.setViewName("contlist/contlistAjax");
	      mav.addObject("list", list);

	      return mav;
	   }
	
	
	@RequestMapping("contlist/ottsearch.do")
	private void ottsearch(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			
			String message="<span style='color:red;font-weight:bold'>넷플릭스 선택됨</span>";
			
			resp.setContentType("text/plain; charset=UTF-8");
			PrintWriter out=resp.getWriter();
			
			out.println(message);
			out.flush();//out객체에 남아 있는 버퍼의 내용을 클리어
			out.close();
			
		}catch (Exception e) {
			System.out.println("응답실패: " + e);
		}
		
	}
	
	
	
   
   
   
}// class end