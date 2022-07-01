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
	
	
	
	public MemberDTO readone(String mem_id){
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

	
	public int count(String col, String word) {
    	int cnt=0;
    	try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" SELECT COUNT(*) as cnt ");
			sql.append(" FROM member_info ");
			
			if(word.length()>=1) {
				String search="";
				if(col.equals("mem_id")) {
					search+= " WHERE mem_id LIKE '%" + word + "%' ";
				}else if(col.equals("mem_phone")) {
					search+= " WHERE mem_phone LIKE '%" + word + "%' ";
				}else if(col.equals("mem_email")) {
					search+= " WHERE mem_email LIKE '%" + word + "%' ";
				}else if(col.equals("mem_lv")) {
					search+= " WHERE mem_lv LIKE '%" + word + "%' ";
				}//if end
				sql.append(search);
			}//if end
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}//if end
			
		} catch (Exception e) {
			System.out.println("카운팅 실패 : " + e );
		}finally {
			DBclose.close(con,pstmt,rs);
		}//end
    	return cnt;
    }//end
	
	public ArrayList<MemberDTO> list(String col,String word,int nowPage, int recordPerPage){
    	ArrayList<MemberDTO> list=null;
    	
    	int startRow = ((nowPage-1) * recordPerPage) + 1 ;
        int endRow   = nowPage * recordPerPage;
    	try {
    		con=dbopen.getConnection(); 
			sql=new StringBuilder();
			if(word.length()==0) { 
				sql.append(" SELECT mem_id, mem_pw, mem_phone, mem_email, mem_lv, mem_reg, mem_birth ");
		        sql.append(" FROM( SELECT mem_id, mem_pw, mem_phone, mem_email, mem_lv, mem_reg, mem_birth, @RNO := @RNO + 1 AS r ");
		        sql.append("       FROM ( ");
		        sql.append("              SELECT mem_id, mem_pw, mem_phone, mem_email, mem_lv, mem_reg, mem_birth ");
		        sql.append("              FROM member_info ORDER BY mem_lv, mem_id  ASC)A, (SELECT @RNO := 0) B ");
		        sql.append("           )C");
		        sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
			}else {
				sql.append(" SELECT mem_id, mem_pw, mem_phone, mem_email, mem_lv, mem_reg, mem_birth ");
		        sql.append(" FROM( SELECT mem_id, mem_pw, mem_phone, mem_email, mem_lv, mem_reg, mem_birth, @RNO := @RNO + 1 AS r ");
		        sql.append("       FROM ( ");
		        sql.append("              SELECT mem_id, mem_pw, mem_phone, mem_email, mem_lv, mem_reg, mem_birth ");
		        sql.append("              FROM member_info  ");
		        String search="";
				if(col.equals("mem_id")) {
					search+= " WHERE mem_id LIKE '%" + word + "%' ";
				}else if(col.equals("mem_phone")) {
					search+= " WHERE mem_phone LIKE '%" + word + "%' ";
				}else if(col.equals("mem_email")) {
					search+= " WHERE mem_email LIKE '%" + word + "%' ";
				}else if(col.equals("mem_lv")) {
					search+= " WHERE mem_lv LIKE '%" + word + "%' ";
				}//if end
				sql.append(search);
		        sql.append("              				   ORDER BY mem_lv, mem_id  ASC)A, (SELECT @RNO := 0) B ");
		        sql.append("           )C");
		        sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
			}//if end
		pstmt=con.prepareStatement(sql.toString());
	    rs=pstmt.executeQuery();
	    if(rs.next()) {
	    	list=new ArrayList<>();
	    	do {
	    		MemberDTO dto = new MemberDTO();
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
    		
    	}catch (Exception e) {
			System.out.println("목록 불러오기 실패 : " + e);
		}finally {
			DBclose.close(con,pstmt,rs);
		}
    	return list;
    }
	
	
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
		}finally {
			DBclose.close(con, pstmt, rs);
		}
		
		return result;
	}

	public int ckEmail(String mem_email) {
		int result = -1;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mem_email ");
			sql.append(" FROM member_info ");
			sql.append(" WHERE mem_email=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 0;
			}else {
				result = 1;
			}
			
		}catch (Exception e) {
			System.out.println("이메일 체크 실패: "+e);
		}
		
		return result;
	}

	public int findId(String mem_phone, String mem_email) {
		int result = 0;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT mem_id ");
			sql.append(" FROM member_info ");
			sql.append(" WHERE mem_email=? AND mem_phone=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, mem_phone);
			pstmt.setString(2, mem_email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 0;
			}else {
				result = 1;
			}
			
		}catch (Exception e) {
			System.out.println("이메일 체크 실패: "+e);
		}
		
		return result;
	}
	
	
}//class end