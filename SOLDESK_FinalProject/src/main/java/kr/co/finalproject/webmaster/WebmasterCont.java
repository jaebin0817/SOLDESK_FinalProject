package kr.co.finalproject.webmaster;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.finalproject.contlist.ContlistDAO;
import kr.co.finalproject.contlist.ContlistDTO;
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
	public ModelAndView contins(HttpServletRequest req, ContlistDTO dto) {
		ModelAndView mav=new ModelAndView();
		
		String basePath=req.getSession().getServletContext().getRealPath("/storage");
		MultipartFile mthumMF=dto.getMthumMF();
		
		String mthum=UploadSaveManager.saveFileSpring30(mthumMF, basePath);
		dto.setMthum(mthum);
				
		String netflix=Utility.checkNull(req.getParameter("netflix"));	
		String watcha=Utility.checkNull(req.getParameter("watcha"));	
		String tving=Utility.checkNull(req.getParameter("tving"));	
		String diseny=Utility.checkNull(req.getParameter("diseny"));	
		
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
		
		if(diseny.equals("O")) { 
			dto.setDiseny("O");
		}else {
			dto.setDiseny("X");
		}

		
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

	
	
	@RequestMapping("/contupdate.do")
	public ModelAndView contupdate(ContlistDTO dto, int mcode) {
		ModelAndView mav=new ModelAndView();
		
		contdao = new ContlistDAO();
		
		mav.addObject("list", contdao.contlistAll());
		mav.setViewName("webmaster/contentmanage/contmanage");
		
		return mav;

	}
	
	
	
}//class end
