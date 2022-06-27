package kr.co.finalproject.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.utility.DBclose;
import net.utility.DBopen;

public class memberDAO {

	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
    private StringBuilder sql=null;

	public memberDAO() {
		dbopen = new DBopen();
	}
	
	public memberDTO findId(String mem_email, String mem_phone) {
		memberDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mem_id ");
			sql.append(" FROM member_info ");
			sql.append(" WHERE mem_email =? AND mem_phone=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_email);
			pstmt.setString(2, mem_phone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setMem_email(rs.getString("mem_email"));
				dto.setMem_phone(rs.getString("mem_phone"));
			}
			
		} catch(Exception e) {
			System.out.println("ID조회 실패: " + e);
		} finally {
			DBclose.close(con, pstmt, rs);
		}
		
		return dto;
	}
	
	public memberDTO findPw(String mem_id, String mem_email, String mem_phone) {
		memberDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mem_pw ");
			sql.append(" FROM member_info ");
			sql.append(" WHERE mem_id=? AND mem_email =? AND mem_phone=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_email);
			pstmt.setString(3, mem_phone);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setMem_id(rs.getString("mem_id"));
				dto.setMem_email(rs.getString("mem_email"));
				dto.setMem_phone(rs.getString("mem_phone"));
			}
			
		} catch(Exception e) {
			System.out.println("PW조회 실패: " + e);
		} finally {
			DBclose.close(con, pstmt, rs);
		}
		
		return dto;
	}

	public int insert(memberDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" INSERT INTO member_info(mem_id, mem_pw, mem_phone, mem_email, mem_reg, mem_birth) ");
			sql.append(" VALUES(?, ?, ?, ?, now(), ?) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getMem_pw());
			pstmt.setString(3, dto.getMem_phone());
			pstmt.setString(4, dto.getMem_email());
			pstmt.setString(5, dto.getMem_birth());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원 가입 실패: "+ e);
		}finally {
			DBclose.close(con, pstmt);
		}
		return cnt;
	}
	
	public memberDTO read(String mem_id){
		memberDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mem_id, mem_pw, mem_phone, mem_email, mem_reg, mem_birth " );
			sql.append(" FROM member_info ");
			sql.append(" where mem_id=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new memberDTO();
				dto.setMem_id(rs.getString("mem_id"));
				dto.setMem_pw(rs.getString("mem_pw"));
				dto.setMem_phone(rs.getString("mem_phone"));
				dto.setMem_email(rs.getString("mem_email"));
				dto.setMem_reg(rs.getString("mem_reg"));
				dto.setMem_birth(rs.getString("mem_birth"));
			}
			
		}catch(Exception e) {
			System.out.println("회원 조회 실패: "+ e);
		}finally {
			DBclose.close(con, pstmt, rs);
		}
		return dto;
	}
	
	
	public int update(memberDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE member_info" );
			sql.append(" SET mem_pw=?, mem_phone=?, mem_email=? ");
			sql.append(" WHERE mem_pw = ? AND mem_id=? ");	
			pstmt = con.prepareStatement(sql.toString());
			
			if(dto.getNew_pw() != null) {
            	pstmt.setString(1, dto.getNew_pw());
            } else {
            	pstmt.setString(1, dto.getMem_pw());
            }
            pstmt.setString(2, dto.getMem_phone());
            pstmt.setString(3, dto.getMem_email());
            pstmt.setString(4, dto.getMem_pw());
            pstmt.setString(5, dto.getMem_id());
            
            cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원정보 수정 실패: "+ e);
		}finally {
			DBclose.close(con, pstmt);
		}
		return cnt;
	}
	
	
	public int delete(String mem_id, String mem_pw) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE member_info ");
			sql.append(" SET mem_lv = 'F' ");
			sql.append(" WHERE mem_id = ? AND mem_pw=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, mem_id);
            pstmt.setString(2, mem_pw);
            
            cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원 탈퇴 실패: " + e);
		}finally {
			DBclose.close(con, pstmt);
		}
		
		return cnt;
	}
	
	
	public String loginRead(String mem_id, String mem_pw) {
		String mem_lv=null;
		try {
			con=dbopen.getConnection();//DB연결

			sql=new StringBuilder();
			sql.append(" SELECT mem_lv ");
			sql.append(" FROM member_info ");
			sql.append(" WHERE mem_id=? AND mem_pw=? ");
			sql.append(" AND mem_lv IN ('A', 'B') ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mem_lv=rs.getString("mem_lv");
			}//if end
			
		} catch (Exception e) {
			System.out.println("로그인 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);;
		}//try end
		return mem_lv;
	}//loginProc() end
	
	
	public int ckId(String mem_id) {
		int result = -1;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mem_id ");
			sql.append(" FROM member_info ");
			sql.append(" WHERE mem_id=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 0;
			}else {
				result = 1;
			}
			
		}catch (Exception e) {
			System.out.println("아이디 체크 실패: "+e);
		}
		
		return result;
	}
	
	
	
}