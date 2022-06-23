package kr.co.finalproject.contentcri;

import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.contlist.ContlistDAO;

@Controller
public class ContentcriCont {
	private ContentcriDAO dao = null;
	private ContlistDAO contdao = null;
	int cnt = 0;
	public ContentcriCont() {
		dao = new ContentcriDAO();
		contdao = new ContlistDAO();
		System.out.println("-----ContentcriCont() 객체 생성");
	}
	@RequestMapping(value= "content_cri.do", method = RequestMethod.GET)
	public String content_cri() {
		return "content_cri/content_cri";
	}
	
	@RequestMapping(value= "content_crilike.do", method = RequestMethod.POST)
	public ModelAndView cri_likeinsert(HttpServletRequest req, ContentcriDTO dto, ContentcriDTO contentcridto) {
		ModelAndView mav = new ModelAndView();
		Map<String, Object> resultMap = new HashMap<>();

		HttpSession session = req.getSession();
		cnt = Integer.parseInt(req.getParameter("mcode"));
		String mem_id=(String) session.getAttribute("s_mem_id");
		int crilike_check = dto.getCri_like();
		
		dto.setMem_id(mem_id);
		dto.setMcode(cnt);
		
		contentcridto = dto;
		
		System.out.println(cnt);
		if(crilike_check == 0) {
			dto.setCri_like(1);
			crilike_check = 1;
		}else {
			dto.setCri_like(0);
			crilike_check = 0;
		}
		
		
		contentcridto =  dao.read(cnt, mem_id);
		System.out.println(dto + " " + crilike_check);
		
		if(contentcridto == null) {
			dao.insert(dto);
		} else {
			dao.update(dto);
		}
		mav.setViewName("content_cri/content_cri");
		mav.addObject(resultMap);
		
		return mav;
	}//cri_likeinsert() end

	
}//class end
