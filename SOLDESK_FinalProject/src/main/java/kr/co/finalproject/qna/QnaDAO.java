package kr.co.finalproject.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.utility.DBclose;
import net.utility.DBopen;

public class QnaDAO {
	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
    private StringBuilder sql=null;
    
    public QnaDAO() {
    	dbopen = new DBopen();
    }
    
	public ArrayList<QnaDTO> list(){
		ArrayList<QnaDTO> list=null;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select qna_num, qna_title, qna_date, qna_content, mem_id, qna_pw, qna_readcnt, qna_grpno, qna_indent, qna_ansnum, ip ");
			sql.append(" from tb_qna ");
			sql.append(" order by qna_num asc ");
			
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<QnaDTO>();
				do {
					QnaDTO dto=new QnaDTO();//한줄담기
					dto.setQna_num(rs.getInt("qna_num"));
					dto.setQna_title(rs.getString("qna_title"));
					dto.setQna_date(rs.getString("qna_date"));
					dto.setQna_content(rs.getString("qna_content"));
					dto.setMem_id(rs.getString("mem_id"));
					dto.setQna_pw(rs.getString("qna_pw"));
					dto.setQna_readcnt(rs.getInt("qna_readcnt"));
					dto.setQna_grpno(rs.getInt("qna_grpno"));
					dto.setQna_indent(rs.getInt("qna_indent"));
					dto.setQna_ansnum(rs.getInt("qna_ansnum"));
					dto.setIp(rs.getString("ip"));
					
					
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
	
	public QnaDTO read(int qna_num) {
		
		QnaDTO dto=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" select qna_num, qna_title, qna_date, qna_content, mem_id, qna_pw, qna_readcnt, qna_grpno, qna_indent, qna_ansnum, ip ");
			sql.append(" from tb_qna ");
			sql.append(" WHERE qna_num=? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, qna_num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto=new QnaDTO();//한줄담기
				dto.setQna_num(rs.getInt("qna_num"));
				dto.setQna_title(rs.getString("qna_title"));
				dto.setQna_date(rs.getString("qna_date"));
				dto.setQna_content(rs.getString("qna_content"));
				dto.setMem_id(rs.getString("mem_id"));
				dto.setQna_pw(rs.getString("qna_pw"));
				dto.setQna_readcnt(rs.getInt("qna_readcnt"));
				dto.setQna_grpno(rs.getInt("qna_grpno"));
				dto.setQna_indent(rs.getInt("qna_indent"));
				dto.setQna_ansnum(rs.getInt("qna_ansnum"));
				dto.setIp(rs.getString("ip"));
				
			}//if end
		}catch (Exception e) {
			System.out.println("공지 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return dto;
	}//end
	
	public int create(QnaDTO dto) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" INSERT INTO tb_qna(qna_title, qna_date, qna_content, mem_id, qna_pw, qna_grpno, ip) ");
			sql.append(" values( ?, now(), ?, ?, ?, (select ifnull(max(qna_num),0)+1 from tb_qna as TB) ,?) ");

			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getQna_title());	
			pstmt.setString(2, dto.getQna_content());	
			pstmt.setString(3, dto.getMem_id());
			pstmt.setString(4, dto.getQna_pw());
			pstmt.setString(5, dto.getIp());
			
			
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("추가 실패 : " + e);
		}finally {
			DBclose.close(con, pstmt);
		}//end
		return cnt;
	}//create end
	
	

}//class end
