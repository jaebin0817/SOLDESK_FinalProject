package kr.co.finalproject.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBclose;
import net.utility.DBopen;

public class SubscribeInfoDAO {

	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public SubscribeInfoDAO() {
		dbopen=new DBopen();
	}
	
	
	public ArrayList<SubscribeInfoDTO>  subread(String mem_id) {
		
		ArrayList<SubscribeInfoDTO> sublist=null;
		SubscribeInfoDTO dto=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT subscribe_no, mem_id, party_id, subscribe_end ");
			sql.append(" FROM subscribe_info ");
			sql.append(" WHERE mem_id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sublist= new ArrayList<SubscribeInfoDTO>();
				do {
					dto = new SubscribeInfoDTO();
					dto.setSubscribe_no(rs.getInt("subscribe_no"));	
					dto.setMem_id(rs.getString("mem_id"));
					dto.setParty_id(rs.getInt("party_id"));
					dto.setSubscribe_end(rs.getString("subscribe_end"));
					sublist.add(dto);
				}while(rs.next());
			}//if end
			
		}catch (Exception e) {
			System.out.println("구독정보 상세보기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return sublist;
		
	}

	
	
	
	
	
	
	
}//class end
