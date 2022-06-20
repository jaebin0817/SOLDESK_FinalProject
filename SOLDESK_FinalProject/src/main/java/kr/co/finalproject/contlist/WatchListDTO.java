package kr.co.finalproject.contlist;

public class WatchListDTO {
	
	private String mem_id;
	private int mcode;
	private String watch_time;
	private String watch_reg;

	public WatchListDTO () {}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getMcode() {
		return mcode;
	}

	public void setMcode(int mcode) {
		this.mcode = mcode;
	}

	public String getWatch_time() {
		return watch_time;
	}

	public void setWatch_time(String watch_time) {
		this.watch_time = watch_time;
	}

	public String getWatch_reg() {
		return watch_reg;
	}

	public void setWatch_reg(String watch_reg) {
		this.watch_reg = watch_reg;
	}

	@Override
	public String toString() {
		return "WatchListDTO [mem_id=" + mem_id + ", mcode=" + mcode + ", watch_time=" + watch_time + ", watch_reg="
				+ watch_reg + "]";
	}
	
	
	
	
	
	
	
}//class end
