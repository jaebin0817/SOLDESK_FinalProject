package kr.co.finalproject.webmaster;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.contlist.ContlistDAO;
import kr.co.finalproject.contlist.ContlistDTO;
import net.utility.UploadSaveManager;

@Controller
public class RecommendCont {

	RecommendDAO dao = null;
	
	public RecommendCont() {		
	  dao = new RecommendDAO();
      System.out.println("-----RecommendCont() 객체 생성");				
	}
	
	@RequestMapping("themelist.do")
	public ModelAndView themeList(ThemesDTO dto) {
	    ModelAndView mav = new ModelAndView();
		ArrayList<ThemesDTO> list=new ArrayList<ThemesDTO>();
	    
		list=dao.readThemes();

	    mav.setViewName("webmaster/recmanage/themeList");
        mav.addObject("list", list);
        return mav;
	}
	
	@RequestMapping("themeadd.do")
	public String themeAdd() {
		return "webmaster/recmanage/themeAdd";
	}

	@RequestMapping("recadd.do")
	public ModelAndView recAdd(HttpServletRequest req) {
	    ModelAndView mav = new ModelAndView();
	    
	    int t_num = Integer.parseInt(req.getParameter("t_num"));
		
	    mav.setViewName("webmaster/recmanage/recForm");
        mav.addObject("t_num", t_num);
        return mav;

	}
	
	
	@RequestMapping("theme.do")
	public ModelAndView themeRead(ThemesDTO dto, HttpServletRequest req) {
	    ModelAndView mav = new ModelAndView();
		ArrayList<RecommendDTO> list=null;
		
		int t_num = Integer.parseInt(req.getParameter("theme"));
		
		list=dao.readRecThemes(t_num);
		dto=dao.readTheme(t_num);
		
	    mav.setViewName("webmaster/recmanage/recList");
        mav.addObject("list", list);
        mav.addObject("dto", dto);
        return mav;
	}
	
	
	@RequestMapping("themeins.do")
	public ModelAndView themeIns(ThemesDTO dto, HttpServletRequest req) {
	    ModelAndView mav = new ModelAndView();

	    String basePath=req.getSession().getServletContext().getRealPath("/storage");
	    MultipartFile t_photoMF=dto.getT_photoMF();
	    
	    String t_photo=UploadSaveManager.saveFileSpring30(t_photoMF, basePath);
	    dto.setT_photo(t_photo);
	    
	    int cnt= dao.insert(dto);
	    
        if(cnt==0){
            String msg="<p>테마 등록 실패</p>";
            mav.addObject("msg", msg);
         }else {
            String msg="<p>테마 등록 성공</p>";
            mav.addObject("msg", msg);
         }
	    
	    mav.setViewName("webmaster/msgView");
        return mav;
	}
	
	
	
	@RequestMapping("themeread.do")
	public ModelAndView themeread(RecommendDTO dto, HttpServletRequest req) {
	    ModelAndView mav = new ModelAndView();
	    ContlistDAO contdao = new ContlistDAO();
	    
		int r_num = Integer.parseInt(req.getParameter("r_num"));
	    
	    dto=dao.readRecTheme(r_num);
	    
	    String mcodes=dto.getMcodes();
  	    int mcode=0;	    
	    ArrayList<ContlistDTO> contents = new ArrayList<ContlistDTO>();
	    
	    StringTokenizer st = new StringTokenizer(mcodes, " || ");
	      while(st.hasMoreTokens()) {
	    	  
	    	  mcode=Integer.parseInt(st.nextToken());
	    	  contents.add(contdao.contlist(mcode));
	    	  
	      }	    
	    
	    //System.out.println("컨텐츠 목록: "+contents);
	    

        mav.addObject("dto", dto);	    
        mav.addObject("list", contents);	    
        mav.setViewName("webmaster/recmanage/recRead");
        return mav;
	}

	
    @ResponseBody		
	@RequestMapping("moviesuggest.do")
	public ArrayList<ContlistDTO> moviesuggest(@RequestParam Map<String, Object> map, ContlistDTO dto) {

       ArrayList<ContlistDTO> suggestList=null;
       ContlistDAO contdao = new ContlistDAO();
	   
		try {
			  String keyword = (String)map.get("keyword");
			  suggestList=contdao.contentSearch(keyword);
			  //System.out.println(keyword);
		      //System.out.println(suggestList);
		      
		}catch (Exception e) {
			System.out.println("응답실패: " + e);
		}
	      
	   return suggestList;

	}

    
    
    
	@RequestMapping("recins.do")
	public ModelAndView recIns(RecommendDTO dto, HttpServletRequest req) {
	    ModelAndView mav = new ModelAndView();

	    String basePath=req.getSession().getServletContext().getRealPath("/storage");
	    MultipartFile r_photoMF=dto.getR_photoMF();
	    
	    
	    
	    String r_photo=UploadSaveManager.saveFileSpring30(r_photoMF, basePath);
	    dto.setR_photo(r_photo);
	    
	    int cnt= dao.insert(dto);
	    
        if(cnt==0){
            String msg="<p>테마 등록 실패</p>";
            mav.addObject("msg", msg);
         }else {
            String msg="<p>테마 등록 성공</p>";
            mav.addObject("msg", msg);
         }
	    
	    mav.setViewName("webmaster/msgView");
        return mav;
	}
	
	
	
}//class end
