package kr.co.finalproject.party;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBclose;
import net.utility.DBopen;

public class PartyMemberDAO {

	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public PartyMemberDAO() {
		dbopen=new DBopen();
	}
	
	
	
	public ArrayList<PartyMemberDTO> readParty(int party_id) {
		
		ArrayList<PartyMemberDTO> list=null;
		
		PartyMemberDTO dto=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT mem_id, party_id, party_pcost, party_pdate, waiting_no, party_ordnumber ");
			sql.append(" FROM party_member ");
			sql.append(" WHERE party_id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, party_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<PartyMemberDTO>();
				do {
					dto=new PartyMemberDTO();
					dto.setMem_id(rs.getString("mem_id"));
					dto.setParty_id(rs.getInt("party_id"));
					dto.setParty_pcost(rs.getInt("party_pcost"));
					dto.setParty_pdate(rs.getString("party_pdate"));
					dto.setWaiting_no(rs.getInt("waiting_no"));
					dto.setParty_ordnumber(rs.getString("party_ordnumber"));
					list.add(dto);
				}while(rs.next());
			}//if end
		}catch (Exception e) {
			System.out.println("파티원 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return list;
	}
	
	
	
	
}