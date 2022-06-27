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
    		sql.append(" VALUES(?, ?, ?, ?, ?) ");
    		
    		pstmt= con.prepareStatement(sql.toString());
    		pstmt.setInt(1, dto.getMcode());
    		pstmt.setInt(2, dto.getCri_like());
    		pstmt.setInt(3, dto.getCri_watch());
    		pstmt.setInt(4, dto.getCri_point());
    		pstmt.setString(5, dto.getMem_id());
    		
    		cnt = pstmt.executeUpdate();
    	}catch(Exception e) {
			System.out.println("컨텐츠 평가 등록 실패: "+ e);
		}finally {
			DBclose.close(con, pstmt);
		}
		return cnt;
    		
    }//insert() end    
    
    public int like_update(ContentcriDTO dto) {
    	int cnt = 0;
    	try {
    		con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE content_critic ");
			sql.append(" SET cri_like =? ");
			sql.append(" WHERE mcode=? and mem_id=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getCri_like());
			pstmt.setInt(2, dto.getMcode());
			pstmt.setString(3, dto.getMem_id());
			
			cnt = pstmt.executeUpdate();
			
    	}catch (Exception e) {
			System.out.println("좋아요 수정 실패: "+ e);
		}finally {
			DBclose.close(con, pstmt);
		}
    	
    	return cnt;
    }//like_update() end
    
    public int watch_update(ContentcriDTO dto) {
		int cnt = 0;
    	try {
    		con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE content_critic ");
			sql.append(" SET cri_watch =? ");
			sql.append(" WHERE mcode=? and mem_id=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getCri_watch());
			pstmt.setInt(2, dto.getMcode());
			pstmt.setString(3, dto.getMem_id());
			
			cnt = pstmt.executeUpdate();
			
    	}catch (Exception e) {
			System.out.println("봤어요 수정 실패: "+ e);
		}finally {
			DBclose.close(con, pstmt);
		}
    	
    	
    	return cnt;
	}//watch_update() end
	
	public int point_update(ContentcriDTO dto) {
		int cnt = 0;
    	try {
    		con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE content_critic ");
			sql.append(" SET cri_point =? ");
			sql.append(" WHERE mcode=? and mem_id=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getCri_point());
			pstmt.setInt(2, dto.getMcode());
			pstmt.setString(3, dto.getMem_id());
			
			cnt = pstmt.executeUpdate();
			
    	}catch (Exception e) {
			System.out.println("찜하기 수정 실패: "+ e);
		}finally {
			DBclose.close(con, pstmt);
		}
    	
    	
    	return cnt;
	}//point_update() end

	public ContentcriDTO read(int mcode, String mem_id) {
		ContentcriDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mcode, mem_id, cri_like, cri_watch, cri_point ");
			sql.append(" FROM content_critic ");
			sql.append(" WHERE mcode=? AND mem_id=?");
			
			pstmt= con.prepareStatement(sql.toString());
			pstmt.setInt(1, mcode);
			pstmt.setString(2, mem_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new ContentcriDTO();
				dto.setCri_like(rs.getInt("cri_like"));
				dto.setCri_watch(rs.getInt("cri_watch"));
				dto.setCri_point(rs.getInt("cri_point"));
			}
		}catch(Exception e) {
			System.out.println("조회 실패: "+ e);
		}
		
		return dto;
	}//read() end

}
