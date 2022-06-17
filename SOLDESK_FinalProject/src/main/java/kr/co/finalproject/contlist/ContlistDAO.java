package kr.co.finalproject.contlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBclose;
import net.utility.DBopen;

public class ContlistDAO {

	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public ContlistDAO() {
		dbopen=new DBopen();
	}
	
	
	public ArrayList<ContlistDTO> contlistAll() {
		ContlistDTO dto=null;
		
		ArrayList<ContlistDTO> list=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, cri_like, key_code, mcode ");
			sql.append(" FROM contlist ");
			sql.append(" ORDER BY mcode DESC ");
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ContlistDTO>();				
				do {
					dto = new ContlistDTO();//커서가 가리키는 한 줄 저장
					dto.setMtitle(rs.getString("mtitle"));
					dto.setMthum(rs.getString("mthum"));
					dto.setMrate(rs.getInt("mrate"));
					dto.setNetflix(rs.getString("netflix"));
					dto.setWatcha(rs.getString("watcha"));
					dto.setTving(rs.getString("tving"));
					dto.setDiseny(rs.getString("diseny"));
					dto.setMdate(rs.getString("mdate"));
					dto.setCri_like(rs.getString("cri_like"));
					dto.setKey_code(rs.getString("key_code"));
					dto.setMcode(rs.getInt("mcode"));
					list.add(dto);
				}while(rs.next());
			}//if end
			
		}catch (Exception e) {
			System.out.println("컨텐츠리스트 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return list;
		
	}
	
	
	
	public ArrayList<ContlistDTO> rankRead() {
		ContlistDTO dto=null;
		
		ArrayList<ContlistDTO> rank=null;

		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append("  ");
			sql.append("  ");
			sql.append("  ");
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				rank=new ArrayList<ContlistDTO>();				
				do {
					dto = new ContlistDTO();//커서가 가리키는 한 줄 저장
					dto.setMtitle(rs.getString("mtitle"));

					
					
					rank.add(dto);
				}while(rs.next());
			}//if end
			
		}catch (Exception e) {
			System.out.println("랭킹 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end

		
		
		
		
		
		
	
		return rank;
		
	}
	
	
	
	
}//class end