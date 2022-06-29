package kr.co.finalproject.contentcri;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ContentcriCont {
   private ContentcriDAO dao = null;
   
   int cnt = 0;
   public ContentcriCont() {
      dao = new ContentcriDAO();
      System.out.println("-----ContentcriCont() 객체 생성");
   }
   
   @RequestMapping(value= "content_cri.do", method = RequestMethod.GET)
   public String insert() {
      return "content_cri/content_cri";
   }
   

   
}//class end