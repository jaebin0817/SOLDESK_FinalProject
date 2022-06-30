package kr.co.finalproject.webmaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBclose;
import net.utility.DBopen;

public class RecommendDAO {
	
	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public RecommendDAO() {
		dbopen=new DBopen();
	}
	
	
	public ArrayList<ThemesDTO> readThemes() {

		ArrayList<ThemesDTO> list=null;
		
		ThemesDTO dto=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT t_num, t_title, t_photo ");
			sql.append(" FROM themes ");
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
					list=new ArrayList<ThemesDTO>();
				do {
					
					dto = new ThemesDTO();//커서가 가리키는 한 줄 저장					
					dto.setT_num(rs.getInt("t_num"));
					dto.setT_title(rs.getString("t_title"));
					dto.setT_photo(rs.getString("t_photo"));
					list.add(dto);
				}while(rs.next());
				
			}//if end
		}catch (Exception e) {
			System.out.println("테마 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return list;
	}

	
	
	public ArrayList<RecommendDTO> readRecThemes(int t_num) {

		ArrayList<RecommendDTO> list=null;
		
		RecommendDTO dto=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT t_num, r_num, r_title, r_date, r_content, r_photo, mcodes ");
			sql.append(" FROM rec_theme ");
			sql.append(" WHERE t_num=? ");			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, t_num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
					list=new ArrayList<RecommendDTO>();
				do {
					
					dto = new RecommendDTO();//커서가 가리키는 한 줄 저장					
					dto.setT_num(rs.getInt("t_num"));
					dto.setR_num(rs.getInt("r_num"));
					dto.setR_title(rs.getString("r_title"));
					dto.setR_date(rs.getString("r_date"));
					dto.setR_content(rs.getString("r_content"));
					dto.setR_photo(rs.getString("r_photo"));
					dto.setMcodes(rs.getString("mcodes"));
					
					list.add(dto);
				}while(rs.next());
				
			}//if end
		}catch (Exception e) {
			System.out.println("테마별 추천글 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return list;
	}

	
	
	public int insert(ThemesDTO dto) {
		int cnt=0;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" INSERT INTO themes (t_title, t_photo) ");
			sql.append(" VALUES (?, ?) ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getT_title());
			pstmt.setString(2, dto.getT_photo());
			
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("테마 추가 실패: " + e);
		} finally {
			DBclose.close(con, pstmt);
		}//try end
		
		return cnt;
		
	}//insert() end

	
	
	
}//class end
