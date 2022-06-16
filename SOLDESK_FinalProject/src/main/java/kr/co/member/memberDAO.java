package kr.co.member;

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
	
	public int insert(memberDTO dto) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" INSERT INTO member_info(mem_id, mem_pw, mem_phone, mem_email, mem_lv, mem_reg, mem_birth) ");
			sql.append(" values(?, ?, ?, ?, ?, ?, ?) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getMemID());
			pstmt.setString(2, dto.getMemPW());
			pstmt.setString(3, dto.getMemPhone());
			pstmt.setString(4, dto.getMemEmail());
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원 가입 실패: "+ e);
		}
		return cnt;
	}
	
	public memberDTO read(String mem_id){
		memberDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT * " );
			sql.append(" FROM member_info ");
			sql.append(" WHERE mem_lv like 'B' ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new memberDTO();
				dto.setMemID(rs.getString("mem_id"));
				dto.setMemPW(rs.getString("mem_pw"));
				dto.setMemPhone(rs.getString("mem_phone"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemLv(rs.getString("mem_lv"));
				dto.setMemReg(rs.getString("mem_reg"));
				dto.setMemBirth(rs.getString("mem_birth"));
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
			pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getMemID());
            
            cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원정보 수정 실패: "+ e);
		}finally {
			DBclose.close(con, pstmt);
		}
		return cnt;
	}
	
	
	public int delete(String mem_id) {
		int cnt=0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" DELETE FROM member_info ");
			sql.append(" WHERE mem_id = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, mem_id);
            
            cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("회원 탈퇴 실패: " + e);
		}finally {
			DBclose.close(con, pstmt);
		}
		
		return cnt;
	}
}
