package kr.co.finalproject.contlist;

import org.springframework.web.multipart.MultipartFile;

public class ContlistDTO {
	   
	   private String mtitle;
	   private String mthum;
	   private int mrate;
	   private String netflix;
	   private String watcha;
	   private String tving;
	   private String diseny;
	   private String mdate;
	   private String cri_like   ;
	   private String key_code;
	   private int mcode;
	   
	   private MultipartFile mthumMF;

	   
	   public ContlistDTO() {}


	   public String getMtitle() {
	      return mtitle;
	   }


	   public void setMtitle(String mtitle) {
	      this.mtitle = mtitle;
	   }


	   public String getMthum() {
	      return mthum;
	   }


	   public void setMthum(String mthum) {
	      this.mthum = mthum;
	   }


	   public int getMrate() {
	      return mrate;
	   }


	   public void setMrate(int mrate) {
	      this.mrate = mrate;
	   }


	   public String getNetflix() {
	      return netflix;
	   }


	   public void setNetflix(String netflix) {
	      this.netflix = netflix;
	   }


	   public String getWatcha() {
	      return watcha;
	   }


	   public void setWatcha(String watcha) {
	      this.watcha = watcha;
	   }


	   public String getTving() {
	      return tving;
	   }


	   public void setTving(String tving) {
	      this.tving = tving;
	   }


	   public String getDiseny() {
	      return diseny;
	   }


	   public void setDiseny(String diseny) {
	      this.diseny = diseny;
	   }


	   public String getMdate() {
	      return mdate;
	   }


	   public void setMdate(String mdate) {
	      this.mdate = mdate;
	   }


	   public String getCri_like() {
	      return cri_like;
	   }


	   public void setCri_like(String cri_like) {
	      this.cri_like = cri_like;
	   }


	   public String getKey_code() {
	      return key_code;
	   }


	   public void setKey_code(String key_code) {
	      this.key_code = key_code;
	   }


	   public int getMcode() {
	      return mcode;
	   }


	   public void setMcode(int mcode) {
	      this.mcode = mcode;
	   }


	public MultipartFile getMthumMF() {
		return mthumMF;
	}


	public void setMthumMF(MultipartFile mthumMF) {
		this.mthumMF = mthumMF;
	}


	@Override
	public String toString() {
		return "ContlistDTO [mtitle=" + mtitle + ", mthum=" + mthum + ", mrate=" + mrate + ", netflix=" + netflix
				+ ", watcha=" + watcha + ", tving=" + tving + ", diseny=" + diseny + ", mdate=" + mdate + ", cri_like="
				+ cri_like + ", key_code=" + key_code + ", mcode=" + mcode + ", mthumMF=" + mthumMF + "]";
	}

	   
	   
}//class end