package kr.co.finalproject.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBclose;
import net.utility.DBopen;

public class SearchKeyDAO {

	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public SearchKeyDAO() {
		dbopen=new DBopen();
	}
	
	
	public ArrayList<SearchKeyDTO> readall() {
		
		SearchKeyDTO dto=null;
		ArrayList<SearchKeyDTO> list=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT key_name, key_code ");
			sql.append(" FROM search_key ");
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list = new ArrayList<SearchKeyDTO>();
				do {
					dto = new SearchKeyDTO();//커서가 가리키는 한 줄 저장
					dto.setKey_code(rs.getString("key_code"));
					dto.setKey_name(rs.getString("key_name"));
					list.add(dto);
				}while(rs.next());
			}//if end
		}catch (Exception e) {
			System.out.println("키워드 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}//class end
