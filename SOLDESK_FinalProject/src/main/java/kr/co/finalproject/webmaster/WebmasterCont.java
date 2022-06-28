package kr.co.finalproject.webmaster;

import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.contlist.ContlistDAO;
import kr.co.finalproject.contlist.ContlistDTO;
import kr.co.finalproject.contlist.PeopleDAO;
import kr.co.finalproject.contlist.PeopleDTO;
import kr.co.finalproject.member.MemberDAO;
import kr.co.finalproject.member.MemberDTO;
import kr.co.finalproject.party.PartyInfoDAO;
import kr.co.finalproject.party.PartyInfoDTO;
import kr.co.finalproject.party.PartyMemberDAO;
import kr.co.finalproject.search.SearchKeyDAO;
import kr.co.finalproject.search.SearchKeyDTO;
import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class WebmasterCont {

   private PartyInfoDAO partydao = null;
   private PartyMemberDAO partymemdao = null;
   private MemberDAO memberdao = null;
   private SearchKeyDAO skeydao = null;
   private ContlistDAO contdao = null;

   
   public WebmasterCont() {
      partydao = new PartyInfoDAO();
      partymemdao = new PartyMemberDAO();
      memberdao = new MemberDAO();
      System.out.println("-----WebmasterCont() 객체 생성");
   }
   
   
   @RequestMapping("webmaster/webmaster.do")
   public String webmaster() {
      return "webmaster/webmaster";
   }
   
   
   @RequestMapping("/partylist.do")
   public ModelAndView partylist(PartyInfoDTO partyDTO) {
      ModelAndView mav=new ModelAndView();
            
      mav.setViewName("webmaster/partymanage/partylist");
      mav.addObject("list", partydao.partylist());
      
      return mav;
   }
   
   
   @RequestMapping("/partyread.do")
   public ModelAndView partyread(String party_id) {
      ModelAndView mav=new ModelAndView();
            
      PartyInfoDTO partyDTO=null;
      
      partyDTO=partydao.partyread(party_id);
      
      mav.setViewName("webmaster/partymanage/partyread");
      mav.addObject("partyDTO", partyDTO);
      mav.addObject("list", partymemdao.readParty(party_id));
      
      return mav;
   }
   
   
   @RequestMapping("/memberlist.do")
   public ModelAndView memberlist(MemberDTO dto) {
      ModelAndView mav=new ModelAndView();
      
      mav.setViewName("webmaster/membermanage/memberlist");
      mav.addObject("dto", dto);
      mav.addObject("list", memberdao.memberlist());
      
      return mav;
   }
   
   
   @RequestMapping("/addcontent.do")
   public ModelAndView addcontent(SearchKeyDTO dto) {
      ModelAndView mav=new ModelAndView();
      
      skeydao = new SearchKeyDAO();
      
      mav.setViewName("webmaster/contentmanage/addcontent");
      mav.addObject("list", skeydao.readall());
      
      return mav;

   }
   
   
   @RequestMapping("/contmanage.do")
   public ModelAndView contentrlist(ContlistDTO dto) {
      ModelAndView mav=new ModelAndView();
      
      contdao = new ContlistDAO();
      
      mav.addObject("list", contdao.contlistAll());
      mav.setViewName("webmaster/contentmanage/contmanage");
      
      return mav;

   }
   

   
   @RequestMapping("/contins.do")
   public ModelAndView contins(HttpServletRequest req, ContlistDTO dto, PeopleDTO pdto) {
      ModelAndView mav=new ModelAndView();
      contdao = new ContlistDAO();
      
      String basePath=req.getSession().getServletContext().getRealPath("/storage");
      MultipartFile mthumMF=dto.getMthumMF();
      
      String mthum=UploadSaveManager.saveFileSpring30(mthumMF, basePath);
      dto.setMthum(mthum);
            
      String netflix=Utility.checkNull(req.getParameter("netflix"));   
      String watcha=Utility.checkNull(req.getParameter("watcha"));   
      String tving=Utility.checkNull(req.getParameter("tving"));   
      String disney=Utility.checkNull(req.getParameter("disney"));   
      
      if(netflix.equals("O")) { 
         dto.setNetflix("O");
      }else {
         dto.setNetflix("X");
      }
      
      if(watcha.equals("O")) { 
         dto.setWatcha("O");
      }else {
         dto.setWatcha("X");
      }
      
      if(tving.equals("O")) { 
         dto.setTving("O");
      }else {
         dto.setTving("X");
      }
      
      if(disney.equals("O")) { 
         dto.setDisney("O");
      }else {
         dto.setDisney("X");
      }      
      
      String directors = req.getParameter("directors");
      directors.replaceAll(" ", "");
      String actors = req.getParameter("actors");
      actors.replaceAll(" ", "");

      System.out.println(directors);
      System.out.println(actors);     
      
      String director="";
      String actor="";
      
      StringTokenizer stDir = new StringTokenizer(directors, ", ");
      while(stDir.hasMoreTokens()) {
    	  
    	  //토큰해서 검색한 감독코드
    	  String names=stDir.nextToken();
    	  String searchedDir=contdao.readDirector(names);
    	  
    	  if(searchedDir==null){
    		  //기존의 감독리스트에 감독이 없다면
    		  //people테이블에 감독추가
    		  PeopleDAO pdao=new PeopleDAO();
    		  
    		  String pcode="D";
    		  String pno=pdao.createPno(pcode);
    		  
    		  pdto.setPname(names);
    		  pdto.setPphoto("");

    		  int cnt=pdao.insertPeople(pdto, pno);
    		  
    		  if(cnt!=0) {
    			  System.out.println("인물추가성공");
    			  director+=pno;
    		  }else {
    			  System.out.println("인물추가실패");
    		  }    		      		  
    	  }else {
    		  director+=searchedDir;
    	  }
    	  director+=", ";
      }//while end
      
      StringTokenizer stAct = new StringTokenizer(actors, ", ");
      while(stAct.hasMoreTokens()) {
    	  
    	  //토큰해서 검색한 배우코드
    	  String names=stAct.nextToken();
    	  String searchedAct=contdao.readActor(names);
    	  
    	  if(searchedAct==null){
    		  //기존의 리스트에 없다면 people테이블에 배우추가
    		  PeopleDAO pdao=new PeopleDAO();
    		  
    		  String pcode="A";
    		  String pno=pdao.createPno(pcode);
    		  
    		  pdto.setPname(names);
    		  pdto.setPphoto("");
    		  
    		  int cnt=pdao.insertPeople(pdto, pno);
    		  
    		  if(cnt!=0) {
    			  System.out.println("인물추가성공");
    			  actor+=pno;
    		  }else {
    			  System.out.println("인물추가실패");
    		  }    		      		  
    	  }else {
    		  actor+=searchedAct;
    	  }
    	  actor+=", ";
       }//while end
      
      dto.setDirector(director);
      dto.setActor(actor);
      
      contdao = new ContlistDAO();
      int cnt=contdao.insert(dto);
      
      if(cnt==0){
         String msg="<p>컨텐츠 등록 실패</p>";
         mav.addObject("msg", msg);
      }else {
         String msg="<p>컨텐츠 등록 성공</p>";
         mav.addObject("msg", msg);
      }
      
      
      mav.setViewName("webmaster/msgView");
      
      return mav;

   }
   
 
   

   
   @RequestMapping(value = "/contupdate.do", method = RequestMethod.GET)
   public ModelAndView contupdate(ContlistDTO dto, HttpServletRequest req) {
      ModelAndView mav=new ModelAndView();
      
      int mcode = Integer.parseInt(req.getParameter("mcode"));
       
      contdao = new ContlistDAO();
      skeydao = new SearchKeyDAO();
      
      dto=contdao.contlist(mcode);
      
      String actor=dto.getActor();
      String director=dto.getDirector();
      String key_code=dto.getKey_code();
      
      System.out.println("감독코드 : "+ actor);
      System.out.println("배우코드 : "+ director);
      System.out.println("키코드 : "+ key_code);
      
      String actors="";
      String directors="";
      ArrayList<String> key_codes=new ArrayList<String>();
      
      StringTokenizer stAct = new StringTokenizer(actor, ", ");
      while(stAct.hasMoreTokens()) {
    	  actors+=contdao.readPname(stAct.nextToken());
    	  actors+=", ";
      }
      
      StringTokenizer stDir = new StringTokenizer(director, ", ");
      while(stDir.hasMoreTokens()) {
    	  directors+=contdao.readPname(stDir.nextToken());
    	  directors+=", ";
      }
      
      StringTokenizer stKc = new StringTokenizer(key_code, " || ");
      while(stKc.hasMoreTokens()) {
    	  
    	  key_codes.add(stKc.nextToken());
    	  
      }
      
      System.out.println("감독 : "+ directors);
      System.out.println("배우 : "+ actors);
      System.out.println("키코드 : " + key_codes);
      
      mav.addObject("actors", actors);
      mav.addObject("directors", directors);
      mav.addObject("list", skeydao.readall());
      mav.addObject("key_codes", key_codes);
      mav.addObject("dto", contdao.contlist(mcode));
      mav.setViewName("webmaster/contentmanage/updatecontent");
      
      return mav;
   }
   

   @RequestMapping(value = "/contupdate.do", method = RequestMethod.POST)
   public ModelAndView contupdateproc(ContlistDTO dto, PeopleDTO pdto, HttpServletRequest req) {
      ModelAndView mav=new ModelAndView();
      
      contdao = new ContlistDAO();

      String netflix=Utility.checkNull(req.getParameter("netflix"));   
      String watcha=Utility.checkNull(req.getParameter("watcha"));   
      String tving=Utility.checkNull(req.getParameter("tving"));   
      String disney=Utility.checkNull(req.getParameter("disney"));   
      
      if(netflix.equals("O")) { 
         dto.setNetflix("O");
      }else {
         dto.setNetflix("X");
      }
      
      if(watcha.equals("O")) { 
         dto.setWatcha("O");
      }else {
         dto.setWatcha("X");
      }
      
      if(tving.equals("O")) { 
         dto.setTving("O");
      }else {
         dto.setTving("X");
      }
      
      if(disney.equals("O")) { 
         dto.setDisney("O");
      }else {
         dto.setDisney("X");
      }           
      
      
      int mcode = Integer.parseInt(req.getParameter("mcode"));
      ContlistDTO oldDTO=contdao.contlist(mcode); 
      String oldMthum=oldDTO.getMthum();
      
      System.out.println("기존 포스터: " + oldMthum);
      
      String basePath=req.getSession().getServletContext().getRealPath("/storage");
      MultipartFile mthumMF=dto.getMthumMF();      
      String mthum=UploadSaveManager.saveFileSpring30(mthumMF, basePath);
      
      System.out.println("변경 포스터:" + mthum);
      
      if(mthum=="") {
    	  dto.setMthum(oldMthum);
      }else {
    	  dto.setMthum(mthum);
      }
      
      String directors = req.getParameter("directors");
      directors.replaceAll(" ", "");
      String actors = req.getParameter("actors");
      actors.replaceAll(" ", "");     
      
      String director="";
      String actor="";
      
      StringTokenizer stDir = new StringTokenizer(directors, ",");
      while(stDir.hasMoreTokens()) {
    	  
    	  //토큰해서 검색한 감독코드
    	  String names=stDir.nextToken();
    	  String searchedDir=contdao.readDirector(names);
    	  
    	  if(searchedDir==null){
    		  //기존의 감독리스트에 감독이 없다면
    		  //people테이블에 감독추가
    		  PeopleDAO pdao=new PeopleDAO();
    		  
    		  String pcode="D";
    		  String pno=pdao.createPno(pcode);
    		  
    		  pdto.setPname(names);
    		  pdto.setPphoto("");

    		  int cnt=pdao.insertPeople(pdto, pno);
    		  
    		  if(cnt!=0) {
    			  System.out.println("인물추가성공");
    			  director+=pno;
    		  }else {
    			  System.out.println("인물추가실패");
    		  }    		      		  
    	  }else {
    		  director+=searchedDir;
    	  }
    	  director+=", ";
      }//while end
      
      StringTokenizer stAct = new StringTokenizer(actors, ",");
      while(stAct.hasMoreTokens()) {
    	  
    	  //토큰해서 검색한 배우코드
    	  String names=stAct.nextToken();
    	  String searchedAct=contdao.readActor(names);
    	  
    	  if(searchedAct==null){
    		  //기존의 리스트에 없다면 people테이블에 배우추가
    		  PeopleDAO pdao=new PeopleDAO();
    		  
    		  String pcode="A";
    		  String pno=pdao.createPno(pcode);
    		  
    		  pdto.setPname(names);
    		  pdto.setPphoto("");

    		  int cnt=pdao.insertPeople(pdto, pno);
    		  
    		  if(cnt!=0) {
    			  System.out.println("인물추가성공");
    			  actor+=pno;
    		  }else {
    			  System.out.println("인물추가실패");
    		  }    		      		  
    	  }else {
    		  actor+=searchedAct;
    	  }
    	  actor+=", ";
       }//while end
      
      dto.setDirector(director);
      dto.setActor(actor);
      
      int cnt=0;
      cnt=contdao.contUpdate(dto);

      if(cnt==0){
          String msg="<p>컨텐츠 수정 실패</p>";
          mav.addObject("msg", msg);
       }else {
          String msg="<p>컨텐츠 수정 성공</p>";
          mav.addObject("msg", msg);
       }
       
       
       mav.setViewName("webmaster/msgView");
      
      return mav;

   }
   
}//class end