package kr.co.finalproject.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBclose;
import net.utility.DBopen;

public class MemberDAO {

	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
    private StringBuilder sql=null;

	public MemberDAO() {
		dbopen = new DBopen();
	}

	public int insert(MemberDTO dto) {
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
	
	public MemberDTO read(String mem_id){
		MemberDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mem_id, mem_pw, mem_phone, mem_email, mem_lv, mem_reg, mem_birth " );
			sql.append(" FROM member_info ");
			sql.append(" WHERE mem_id=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMem_id(rs.getString("mem_id"));
				dto.setMem_pw(rs.getString("mem_pw"));
				dto.setMem_phone(rs.getString("mem_phone"));
				dto.setMem_email(rs.getString("mem_email"));
				dto.setMem_lv(rs.getString("mem_lv"));
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
	
	
	public int update(MemberDTO dto) {
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
	
	
	
	public ArrayList<MemberDTO> memberlist(){
		ArrayList<MemberDTO> list=null;
		MemberDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mem_id, mem_pw, mem_phone, mem_email, mem_lv, mem_reg, mem_birth " );
			sql.append(" FROM member_info ");
			sql.append(" ORDER BY mem_lv, mem_id  ");

			
			pstmt=con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<MemberDTO>();
				do {
					dto = new MemberDTO();
					dto.setMem_id(rs.getString("mem_id"));
					dto.setMem_pw(rs.getString("mem_pw"));
					dto.setMem_phone(rs.getString("mem_phone"));
					dto.setMem_email(rs.getString("mem_email"));
					dto.setMem_lv(rs.getString("mem_lv"));
					dto.setMem_reg(rs.getString("mem_reg"));
					dto.setMem_birth(rs.getString("mem_birth"));
					list.add(dto);
				}while(rs.next());
			}
			
		}catch(Exception e) {
			System.out.println("회원 목록 조회 실패: "+ e);
		}finally {
			DBclose.close(con, pstmt, rs);
		}
		return list;
	}

	
	
	
	
}//class end