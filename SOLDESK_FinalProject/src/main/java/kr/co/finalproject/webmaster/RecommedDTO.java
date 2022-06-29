package kr.co.finalproject.webmaster;

public class RecommedDTO {

	private int r_num;
	private String r_title;
	private String r_date;
	private String r_theme;
	private String r_content;
	private int mcode;

	public RecommedDTO(){}

	public int getR_num() {
		return r_num;
	}

	public void setR_num(int r_num) {
		this.r_num = r_num;
	}

	public String getR_title() {
		return r_title;
	}

	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	public String getR_theme() {
		return r_theme;
	}

	public void setR_theme(String r_theme) {
		this.r_theme = r_theme;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public int getMcode() {
		return mcode;
	}

	public void setMcode(int mcode) {
		this.mcode = mcode;
	}

	@Override
	public String toString() {
		return "RecommedDTO [r_num=" + r_num + ", r_title=" + r_title + ", r_date=" + r_date + ", r_theme=" + r_theme
				+ ", r_content=" + r_content + ", mcode=" + mcode + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}//class end
