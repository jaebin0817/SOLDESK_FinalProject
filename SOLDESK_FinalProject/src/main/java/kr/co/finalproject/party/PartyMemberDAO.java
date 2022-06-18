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
         sql.append(" SELECT mem_id, party_id, party_pcost, party_pdate, party_ordnumber ");
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
   }//end			
   
   public int ordersheet(PartyInfoDTO dto2, PartyMemberDTO dto3) {
   	int result=0; //성공 또는 실패 여부 반환
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" INSERT INTO party_member(mem_id, party_id, party_pcost, party_pdate ,party_ordnumber) ");
	        sql.append(" VALUES(?, ?, ?, now(), ? ) ");
	        
	        pstmt=con.prepareStatement(sql.toString());
	        pstmt.setString(1, dto3.getMem_id()); 
	        pstmt.setInt(2, dto2.getParty_id()); 
	        pstmt.setInt(3, dto3.getParty_pcost());
	        pstmt.setString(4, dto3.getParty_ordnumber());
		
			result=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("행수정 실패 : " + e);
		}finally {
			DBclose.close(con,pstmt);
		}//end
		return result;
   }//end

   
   
   
   
   
   
}