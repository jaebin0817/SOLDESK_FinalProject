package kr.co.finalproject.party;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			sql.append(" INSERT INTO party_info(mem_id, ott_name, ott_price, ott_id, ott_pw, ott_cdate, bank_name, bank_account, payback_amount) ");
			sql.append(" VALUES(?, ?, ?, ?, ?, now(), ?, ?, ? ) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getOtt_name());
			pstmt.setInt(3, dto.getOtt_price());;
			pstmt.setString(4, dto.getOtt_id());
			pstmt.setString(5, dto.getOtt_pw());
			pstmt.setString(6, dto.getBank_name());
			pstmt.setString(7, dto.getBank_account());
			pstmt.setInt(8, dto.getPayback_amount());

			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("파티 생성 실패: " + e);
		} finally {
			DBclose.close(con, pstmt);
		}//try end
		
		
		return cnt;
		
	}//insert() end
	
	
	public PartyInfoDTO readBank(String s_mem_id) {
		
		PartyInfoDTO dto=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT mem_id, bank_name, bank_account ");
			sql.append(" FROM party_info ");
			sql.append(" WHERE mem_id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, s_mem_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new PartyInfoDTO();//커서가 가리키는 한 줄 저장
				dto.setMem_id(rs.getString("mem_id"));
				dto.setBank_name(rs.getString("bank_name"));
				dto.setBank_account(rs.getString("bank_account"));
				
			}//if end
		}catch (Exception e) {
			System.out.println("계좌 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return dto;
	}
	
	
	public ArrayList<PartyInfoDTO> partylist() {
		PartyInfoDTO dto=null;
		
		ArrayList<PartyInfoDTO> list=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT party_id, mem_id, ott_name, ott_cdate, matching_no ");
			sql.append(" FROM party_info ");
			sql.append(" ORDER BY party_id ");
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<PartyInfoDTO>();				
				do {
					dto = new PartyInfoDTO();//커서가 가리키는 한 줄 저장
					dto.setParty_id(rs.getInt("party_id"));
					dto.setMem_id(rs.getString("mem_id"));
					dto.setOtt_name(rs.getString("ott_name"));
					dto.setOtt_cdate(rs.getString("ott_cdate"));
					dto.setMatching_no(rs.getInt("matching_no"));
					list.add(dto);
				}while(rs.next());
			}//if end
			
		}catch (Exception e) {
			System.out.println("파티 리스트 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return list;
		
	}
	
	
	
	
	public PartyInfoDTO partyread(int party_id) {
		PartyInfoDTO dto=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT party_id, mem_id, ott_name, ott_price, ott_id, ott_pw, ott_cdate, bank_name, bank_account, payback_amount, payback_result, matching_no ");
			sql.append(" FROM party_info ");
			sql.append(" WHERE party_id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, party_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
					dto = new PartyInfoDTO();
					dto.setParty_id(rs.getInt("party_id"));
					dto.setMem_id(rs.getString("mem_id"));
					dto.setOtt_name(rs.getString("ott_name"));
					dto.setOtt_price(rs.getInt("ott_price"));
					dto.setOtt_id(rs.getString("ott_id"));
					dto.setOtt_pw(rs.getString("ott_pw"));
					dto.setOtt_cdate(rs.getString("ott_cdate"));
					dto.setBank_name(rs.getString("bank_name"));
					dto.setBank_account(rs.getString("bank_account"));
					dto.setPayback_amount(rs.getInt("payback_amount"));
					dto.setPayback_result(rs.getString("payback_result"));
					dto.setMatching_no(rs.getInt("matching_no"));
			}//if end
			
		}catch (Exception e) {
			System.out.println("파티 상세보기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return dto;
		
	}

	
	public PartyInfoDTO read(String ott_name) {
	      PartyInfoDTO dto=null;
	      try {
	         con=dbopen.getConnection();
	         
	         sql=new StringBuilder();
	         sql.append(" SELECT party_id, mem_id, ott_name, ott_cdate, matching_no ");
	         sql.append(" FROM party_info ");
	         sql.append(" WHERE ott_name=? && ott_cdate=(SELECT MIN(ott_cdate) FROM party_info) && matching_no<=4 ");
	         
	         pstmt=con.prepareStatement(sql.toString());
	         pstmt.setString(1, ott_name);
	         
	         rs=pstmt.executeQuery();
	         if(rs.next()) {
	            dto=new PartyInfoDTO();
	            dto.setParty_id(rs.getInt("party_id"));
	            dto.setMem_id(rs.getString("mem_id"));
	            dto.setOtt_name(ott_name);
	            dto.setOtt_cdate(rs.getString("ott_cdate"));
	            dto.setMatching_no(rs.getInt("matching_no"));
	         }//if end
	         
	      } catch (Exception e) {
	         System.out.println("읽기 실패 : " + e);
	      }finally {
	         DBclose.close(con,pstmt,rs);
	      }//end
	      return dto;
	   }//end
	
	
	
	
	
}//class end
