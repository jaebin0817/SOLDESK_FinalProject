package kr.co.finalproject.qna;

import org.springframework.stereotype.Controller;

@Controller
public class QnaCont {
	
	QnaDAO dao=null;
	
	public QnaCont() {	
		dao = new QnaDAO();
		System.out.println("-----QnaCont() 객체생성");	
	}
	
	
	
	
	
}//class end
