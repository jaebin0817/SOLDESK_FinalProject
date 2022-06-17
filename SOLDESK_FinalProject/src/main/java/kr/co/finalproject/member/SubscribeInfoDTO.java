package kr.co.finalproject.member;

public class SubscribeInfoDTO {

    private int subscribe_no;
    private String mem_id;
    private int party_id;
    private String subscribe_end;
	
    public SubscribeInfoDTO () {}

	public int getSubscribe_no() {
		return subscribe_no;
	}

	public void setSubscribe_no(int subscribe_no) {
		this.subscribe_no = subscribe_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getParty_id() {
		return party_id;
	}

	public void setParty_id(int party_id) {
		this.party_id = party_id;
	}

	public String getSubscribe_end() {
		return subscribe_end;
	}

	public void setSubscribe_end(String subscribe_end) {
		this.subscribe_end = subscribe_end;
	}

	@Override
	public String toString() {
		return "SubscribeInfoDTO [subscribe_no=" + subscribe_no + ", mem_id=" + mem_id + ", party_id=" + party_id
				+ ", subscribe_end=" + subscribe_end + "]";
	};
    
    
	
	
	
	
	
}//class end
