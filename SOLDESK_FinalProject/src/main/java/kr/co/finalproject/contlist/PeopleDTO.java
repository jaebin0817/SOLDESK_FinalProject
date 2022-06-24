package kr.co.finalproject.contlist;

import org.springframework.web.multipart.MultipartFile;

public class PeopleDTO {

	private String pno;
	private String pname;
	private String pphoto;
	
	private MultipartFile pphotoMF;
	
	public PeopleDTO() {}

	public String getPno() {
		return pno;
	}

	public void setPno(String pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPphoto() {
		return pphoto;
	}

	public void setPphoto(String pphoto) {
		this.pphoto = pphoto;
	}

	public MultipartFile getPphotoMF() {
		return pphotoMF;
	}

	public void setPphotoMF(MultipartFile pphotoMF) {
		this.pphotoMF = pphotoMF;
	}

	@Override
	public String toString() {
		return "PeopleDTO [pno=" + pno + ", pname=" + pname + ", pphoto=" + pphoto + ", pphotoMF=" + pphotoMF + "]";
	}
	
	
	
	
	
	
	
}//class end