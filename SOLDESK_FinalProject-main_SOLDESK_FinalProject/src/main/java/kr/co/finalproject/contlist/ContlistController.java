package kr.co.finalproject.contlist;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.review.ReviewDAO;
import kr.co.finalproject.review.ReviewDTO;
import kr.co.finalproject.search.SearchKeyDAO;
import kr.co.finalproject.search.SearchKeyDTO;
import net.utility.Paging;
import net.utility.Utility;

@Controller
public class ContlistController {

   ContlistDAO dao = null;
   ReviewDAO dao2 = null;
   SearchKeyDAO dao3 = null;
   WatchListDAO dao4 = null;
   PeopleDAO pdao=null;

   
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
 

    // 댓글 AJAX 처리하기.
   /*
   @ResponseBody
   @RequestMapping(value="/contlist/contlistread.do", method = RequestMethod.POST)
   public ArrayList<ReviewDTO> reviewlist(HttpServletRequest req, HttpServletResponse resp, ReviewDTO dto2) {
	   try {
		   ArrayList<ReviewDTO> reviewalllist = null;
		   int mcode = Integer.parseInt(req.getParameter("mcode"));
		   String mem_id= dto2.getMem_id();
		  dto2.setMcode(mcode);
		  dto2.setMem_id(mem_id);
		  
		  reviewalllist=dao2.reviewAll(mcode);
		  

		   
	
	   }catch (Exception e) {
		   System.out.println("ajax 실패: " +e);
	   }
	   return ;
   }
   */
   
   @RequestMapping("/contlist/contlistread.do")
   public ModelAndView contlistread(ContlistDTO dto, ReviewDTO dto2, SearchKeyDTO dto3, PeopleDTO pdto, HttpServletRequest req) {
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
      
      pdao=new PeopleDAO();
      
      String directors = dto.getDirector();
      String actors = dto.getActor();
      ArrayList<PeopleDTO> directorlist = new ArrayList<>();
      ArrayList<PeopleDTO> actorlist = new ArrayList<>();
    
      
      StringTokenizer dirSt = new StringTokenizer(directors, ", ");
      while(dirSt.hasMoreTokens()) { //토큰할 문자가 있는지?
          
    	  directorlist.add(pdao.readDirector(dirSt.nextToken()));
    	  
      }
      
      StringTokenizer actSt = new StringTokenizer(actors, ", ");
      while(actSt.hasMoreTokens()) { //토큰할 문자가 있는지?
          
    	  String pno = actSt.nextToken();
    	  //System.out.println(pno);

    	  actorlist.add(pdao.readActor(pno));
      }
     
      ArrayList<ReviewDTO> reviewlist = new ArrayList<ReviewDTO>();
      reviewlist = dao2.reviewThree(mcode);
      
      mav.setViewName("contlist/contlistread");
      mav.addObject("dto", dto);
      mav.addObject("keylist",keylist);
      mav.addObject("keycodelist",keycodelist);
      mav.addObject("directorlist",directorlist);
      mav.addObject("actorlist",actorlist);
      mav.addObject("reviewlist",reviewlist);
      
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
      searchkey=searchkey.replace(" ", "");
     
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


	
    @ResponseBody	
	@RequestMapping("contlist/ottsearch.do")
	private ArrayList<ContlistDTO> ottsearch(@RequestParam Map<String, Object> map) {
		
        ArrayList<ContlistDTO> list = null;
    	
		try {
			
			System.out.println("검색키워드: "+(String)map.get("key_name")); 
			
			String ott= (String)map.get("ott");
			
			String netflix="X";
			String watcha="X"; 
			String tving="X"; 
			String disney="X";
			
			String searchkey=(String)map.get("searchkey");
			String key_name=(String)map.get("key_name"); 
			//System.out.println(searchkey.equals("")); 
			//System.out.println(key_name.equals("")); 
			String key_code=""; 
			String pno="";

			
			if(!(key_name.equals(""))) {//key_name이 검색된 상태라면				
				key_code=dao3.SearchKeyCode(key_name);				
			}
			
			
			if(ott.equals("netflix")) {
				netflix="O";
			}else if(ott.equals("watcha")) {
				watcha="O"; 
			}else if(ott.equals("tving")) {
				tving="O"; 
			}else if(ott.equals("disney")) {
				disney="O"; 
			}
			
			
		    list = dao.ottRead(netflix, watcha, tving, disney, searchkey, key_code, pno);
			
		}catch (Exception e) {
			System.out.println("응답실패: " + e);
		}
		
		return list;
		
	}//ottsearch() end
	
   
    
    @ResponseBody	
	@RequestMapping("ottsearch.do")
	private ArrayList<ContlistDTO> ottsearchkey(@RequestParam Map<String, Object> map) {
		
        ArrayList<ContlistDTO> list = null;
    	
		try {
			//메인 페이지에서 검색된 상태일 때
			
			System.out.println("검색어: "+(String)map.get("searchkey")); 
			System.out.println("검색키워드: "+(String)map.get("key_name")); 
			System.out.println("검색키코드: "+(String)map.get("key_code")); 

			
			String ott= (String)map.get("ott");
			
			String netflix="X";
			String watcha="X"; 
			String tving="X"; 
			String disney="X";
			
			String searchkey=(String)map.get("searchkey");
			String searchname=(String)map.get("searchkey");
			String key_code=(String)map.get("key_code"); 
			String pno="";
			if(!(searchkey.equals(""))) {
				  searchkey=searchkey.replace(" ", "");			      
			      searchname=searchname.replace(" ", "");			      
			      pno=dao.readPno(searchname);
				
			}
			System.out.println(searchkey);
			System.out.println(searchname);
			System.out.println(pno);
			
			if(ott.equals("netflix")) {
				netflix="O";
			}else if(ott.equals("watcha")) {
				watcha="O"; 
			}else if(ott.equals("tving")) {
				tving="O"; 
			}else if(ott.equals("disney")) {
				disney="O"; 
			}
			
			
		    list = dao.ottRead(netflix, watcha, tving, disney, searchkey, key_code, pno);
			
		}catch (Exception e) {
			System.out.println("응답실패: " + e);
		}
		
		return list;
		
	}//ottsearch() end
    
	
    @RequestMapping("peoplesearch.do")
    public ModelAndView peoplesearch(HttpServletRequest req) {
       ModelAndView mav = new ModelAndView();
       
       String pno=req.getParameter("pno");
       String pname=req.getParameter("pname");

       
       ArrayList<ContlistDTO> list = null;
       
       String msg=pname+" : 검색 결과";
       
       list = dao.searchPeople(pno);

       mav.setViewName("contlist/contlist");
       mav.addObject("list", list);
       mav.addObject("msg", msg);

       return mav;
    }
	
    
    @RequestMapping(value = "contlist/reviewForm.do", method = RequestMethod.GET)
    
    public ModelAndView reviewAll(HttpServletRequest req) {
       ModelAndView mav=new ModelAndView();
       
       	int mcode = Integer.parseInt(req.getParameter("mcode"));
    
          mav.setViewName("review/reviewForm");
          mav.addObject("mcode", mcode);

       return mav;

    }
    
    
    @RequestMapping(value = "contlist/contlistins.do", method = RequestMethod.POST)
    public ModelAndView rev_ins(@ModelAttribute ContlistDTO dto, ReviewDTO dto2, HttpServletRequest req) {
       ModelAndView mav=new ModelAndView();
       
       int mcode = Integer.parseInt(req.getParameter("mcode"));
       dto2.setMcode(mcode);
       
       HttpSession session = req.getSession();
       String mem_id =session.getAttribute("s_mem_id").toString();
       dto2.setMem_id(mem_id);
       
       String rev_spo=Utility.checkNull(req.getParameter("rev_spo"));
    

          if(rev_spo.equals("O")) { 
             dto2.setRev_spo("O");
          }else {
             dto2.setRev_spo("X");
          }
          
       int cnt = dao2.rev_ins(dto2);
       
       
       if(cnt==1) {//리뷰 입력 성공, 컨텐츠 리스트의 별점을 수정
          
          //1) 새로 넣은 리뷰의 별점+기존에 있던 별점을 평균내서 가져오기 DAO select 
          double mrate = (int)dao2.rev_rateHap(mcode);
          //2) 1)1에서 불러온 값을 매개변수로 넘겨서 CONTLIST를 update 해준다
          dao.mrateUpdate(mrate, mcode);
          
       }else {
          System.out.println("리뷰  입력 실패");
       }
       
          ArrayList<ContlistDTO> list = null;

          list = dao.contlistAll();
       
           mav.setViewName("contlist/contlist");
          mav.addObject("list", list);
          mav.addObject("mcode", mcode);

       return mav;

    }
   
    
    @RequestMapping(value = "contlist/reviewdelete.do", method = RequestMethod.POST)
    public ModelAndView delete(@ModelAttribute ReviewDTO dto2, ContlistDTO dto, HttpServletRequest req) {
       ModelAndView mav=new ModelAndView();
       mav.setViewName("review/msgView");//어디로 보낼지 바꾸기
       int rev_code=Integer.parseInt(req.getParameter("rev_code"));
       
       int cnt=dao2.delete(rev_code, dto2.getMcode());
       if(cnt==0) {   
          String msg="<p>해당 글 삭제 실패</p>";
            mav.addObject("msg", msg);
       }else {
          String msg="<p>해당 글 삭제 성공</p>";
            mav.addObject("msg", msg);
       }//if end
       
       return mav;
    }//delete() end
    
    
    @RequestMapping(value = "reviewupdate.do", method = RequestMethod.POST)
    public ModelAndView update(@ModelAttribute ReviewDTO dto2, HttpServletRequest req) {
       ModelAndView mav=new ModelAndView();
       int rev_code=Integer.parseInt(req.getParameter("rev_code"));
       dto2= dao2.readReviewOne(rev_code);
       
       HttpSession session = req.getSession(); 
       
       String s_mem_id="";
       
       if(session.getAttribute("s_mem_id")!=null) {
    	   s_mem_id=session.getAttribute("s_mem_id").toString();
       }
       
       String mem_id=dto2.getMem_id();
       
       if(!(s_mem_id.equals(mem_id))) {//세션정보의 글의 작성자가 일치하지 않을때는 수정페이지로 넘어가지 않음
          
          String msg="<p> 작성자 본인만 글을 수정할 수 있습니다</p>";
             mav.addObject("msg", msg);
           mav.setViewName("review/msgView");

       }else {
          mav.addObject("dto2", dto2);
           mav.setViewName("review/reviewUpdate");         
       }
       
       return mav;
    
      
       
    }// update() end
    

    
    
    
    @RequestMapping(value = "reviewupdateproc.do", method = RequestMethod.POST)
    public ModelAndView updateproc(@ModelAttribute ReviewDTO dto2,  HttpServletRequest req) {
       ModelAndView mav=new ModelAndView();
       mav.setViewName("review/msgView");
       
       String rev_spo=Utility.checkNull(req.getParameter("rev_spo"));
       
       if(rev_spo.equals("O")) { 
          dto2.setRev_spo("O");
       }else {
          dto2.setRev_spo("X");
       }
        
       HttpSession session = req.getSession();
       
       String s_mem_id=session.getAttribute("s_mem_id").toString();
       int rev_code = Integer.parseInt(req.getParameter("rev_code"));
          
          int cnt = dao2.updateproc(dto2, rev_code, s_mem_id);
          
          if(cnt==0) {
             String msg="<p> 글 수정 실패</p>";
                mav.addObject("msg", msg);
          }else {
             String msg="<p> 글 수정이 완료 되었습니다</p>";
                mav.addObject("msg", msg);
          }//if end
       
       return mav;
    
    }
    
    
    @RequestMapping("/contlist/reviewList.do")
    public ModelAndView reviewListAjax(HttpServletRequest req) {
       ModelAndView mav = new ModelAndView();
       int mcode = Integer.parseInt(req.getParameter("mcode"));
       ArrayList<ReviewDTO> list = null;
       
       int recordPerPage=3;
       int nowPage=1;
       if(req.getParameter("nowPage")!=null){
          nowPage=Integer.parseInt(req.getParameter("nowPage"));
       }//if end
       
       list = dao2.list(nowPage, recordPerPage, mcode);
       System.out.println(list);
       mav.setViewName("review/reviewListAjax");
       mav.addObject("list", list);
       mav.addObject("nowPage", nowPage);

       return mav;
    }

    
    
    
     @ResponseBody	
 	@RequestMapping("contlist/morereviews.do")
 	private ArrayList<ReviewDTO> morereviews(@RequestParam Map<String, Object> map) {
 		
        ArrayList<ReviewDTO> list = null;
    	
 		try {
 			String strMcode= (String)map.get("mcode");
 			int mcode= Integer.parseInt(strMcode);
 			String strNowPage= (String)map.get("page");
 			int nowPage = Integer.parseInt(strNowPage);
 			
 			//System.out.println(nowPage);
 			
 		      int recordPerPage=3;
 		    list = dao2.list(nowPage, recordPerPage, mcode);
 		    
 		    //System.out.println(list);
 		    
 		}catch (Exception e) {
 			System.out.println("응답실패: " + e);
 		}
 		
 		return list;
 		
 	}//morecontents() end
  
    
    
    
    
    
    /*
    @RequestMapping(value = "/contlist/searchCategory", method = RequestMethod.POST)
    public String modalPopUp(ContlistDTO dto) {



        return "/contlist/searchCategory";
    }
    */
    
   
}// class end