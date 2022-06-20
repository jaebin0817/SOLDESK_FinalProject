package kr.co.finalproject.contentcri;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.utility.DBclose;
import net.utility.DBopen;

public class ContentcriDAO {
	
	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
    private StringBuilder sql=null;
    
    public ContentcriDAO() {
	
		dbopen = new DBopen();
	}
    
    public int insert(ContentcriDTO dto) {
    	int cnt = 0;
    	try {
    		con = dbopen.getConnection();
    		sql = new StringBuilder();
    		sql.append(" INSERT INTO content_critic(mcode, cri_like, cri_watch, cri_point, mem_id) ");
    		sql.append(" VALUES(?, ?) ");
    		
    		pstmt= con.prepareStatement(sql.toString());
    		pstmt.setInt(1, dto.getMcode());
    		pstmt.setString(2, dto.getMem_id());
    		
    		cnt = pstmt.executeUpdate();
    	}catch(Exception e) {
			System.out.println("컨텐츠 평가 등록 실패: "+ e);
		}
		return cnt;
    		
    }//insert() end
    
    
}
