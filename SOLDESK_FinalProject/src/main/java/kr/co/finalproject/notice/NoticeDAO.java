package kr.co.finalproject.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBclose;
import net.utility.DBopen;

public class NoticeDAO {
	
	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
    private StringBuilder sql=null;
    
    public NoticeDAO() {
    	dbopen = new DBopen();
    }
    
    public int create(NoticeDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" INSERT INTO notice(n_title, n_date, n_content, n_readcnt) ");
			sql.append(" values( ?, now(), ?, ?) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getN_title());	
			pstmt.setString(2, dto.getN_content());	
			pstmt.setInt(3, dto.getN_readcnt());	
			
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("추가 실패 : " + e);
		}finally {
			DBclose.close(con, pstmt);
		}//end
		return cnt;
	}//create end
    
    public ArrayList<NoticeDTO> list(){
		ArrayList<NoticeDTO> list=null;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select n_num, n_title, n_date, n_content, n_readcnt ");
			sql.append(" from notice ");
			sql.append(" order by n_num asc ");
			
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<NoticeDTO>();
				do {
					NoticeDTO dto=new NoticeDTO();//한줄담기
					dto.setN_num(rs.getInt("n_num"));
					dto.setN_title(rs.getString("n_title"));;
					dto.setN_date(rs.getString("n_date"));;
					dto.setN_content(rs.getString("n_content"));;
					dto.setN_readcnt(rs.getInt("n_readcnt"));;
					list.add(dto); //list에 모으기
				}while(rs.next());
			}else {
				list=null;
			}//if end
			
		} catch (Exception e) {
			System.out.println("목록 실패 : " + e);
		}finally {
			DBclose.close(con,pstmt,rs);
		}//end		
		return list;
	}//list() end


}//class end
