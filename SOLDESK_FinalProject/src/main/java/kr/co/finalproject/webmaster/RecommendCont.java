package kr.co.finalproject.webmaster;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
	public String recAdd() {
		return "webmaster/recmanage/recForm";
	}
	
	
	@RequestMapping("theme.do")
	public ModelAndView themeRead(ThemesDTO dto, HttpServletRequest req) {
	    ModelAndView mav = new ModelAndView();
		ArrayList<RecommendDTO> list=null;
	    
		int t_num = Integer.parseInt(req.getParameter("theme"));
		
		list=dao.readRecThemes(t_num);

	    mav.setViewName("webmaster/recmanage/recList");
        mav.addObject("list", list);
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
	
	
}//class end
