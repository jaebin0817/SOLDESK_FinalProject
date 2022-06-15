package kr.co.finalproject.party;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.utility.DBclose;
import net.utility.DBopen;

public class PartyInfoDAO {

	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public PartyInfoDAO() {
		dbopen=new DBopen();
	}
	
	
	public int insert(PartyInfoDTO dto) {
		int cnt=0;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" INSERT INTO party_info(mem_id, ott_name, ott_price, ott_id, ott_pw, ott_cdate, bank_name, bank_account) ");
			sql.append(" VALUES(?, ?, ?, ?, ?, now(), ?, ? ) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getOtt_name());
			pstmt.setInt(3, dto.getOtt_price());;
			pstmt.setString(4, dto.getOtt_id());
			pstmt.setString(5, dto.getOtt_pw());
			pstmt.setString(6, dto.getBank_name());
			pstmt.setString(7, dto.getBank_account());

			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("파티 생성 실패: " + e);
		} finally {
			DBclose.close(con, pstmt);
		}//try end
		
		
		return cnt;
		
	}//insert() end
	
	
	
	
	
	
}//class end
