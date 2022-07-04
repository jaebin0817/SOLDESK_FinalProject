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
	
	public void incrementCnt(int qna_num) {
		
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" update tb_qna ");
			sql.append(" set qna_readcnt=qna_readcnt+1  ");
			sql.append(" where qna_num=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, qna_num);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("목록 실패 : " + e);
		}finally {
			DBclose.close(con,pstmt,rs);
			
		}//end
	}//incrementCnt end
	
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
	
	public int delete(int qna_num, String qna_pw){
		int cnt=0; //성공 또는 실패 여부 반환
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" DELETE FROM tb_qna ");
			sql.append(" WHERE qna_num=? && qna_pw=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, qna_num);
			pstmt.setString(2, qna_pw);
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("행삭제 실패 : " + e);
		}finally {
			DBclose.close(con,pstmt);
		}//end
		return cnt;
	}//delete end
	
	public int deletemaster(int qna_num){
		int cnt=0; //성공 또는 실패 여부 반환
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" DELETE FROM tb_qna ");
			sql.append(" WHERE qna_num=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, qna_num);
			cnt=pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("행삭제 실패 : " + e);
		}finally {
			DBclose.close(con,pstmt);
		}//end
		return cnt;
	}//delete end
	
	public int updateproc(QnaDTO dto,String qna_pw) {
		int cnt=0; //성공 또는 실패 여부 반환
		try {

			con=dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" UPDATE tb_qna ");
			sql.append(" SET qna_title=?, qna_content=? ");
			sql.append(" WHERE qna_num=? && qna_pw=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getQna_title());
			pstmt.setString(2, dto.getQna_content());
			pstmt.setInt(3, dto.getQna_num());
			pstmt.setString(4, qna_pw);
		
			cnt=pstmt.executeUpdate(); 
			
		} catch (Exception e) {
			System.out.println("행수정 실패 : " + e);
		}finally {
			DBclose.close(con,pstmt);
		}//end
		return cnt;
	}//updateproc() end
	
	public int updatemasterproc(QnaDTO dto) {
		int cnt=0; //성공 또는 실패 여부 반환
		try {

			con=dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" UPDATE tb_qna ");
			sql.append(" SET qna_title=?, qna_content=? ");
			sql.append(" WHERE qna_num=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getQna_title());
			pstmt.setString(2, dto.getQna_content());
			pstmt.setInt(3, dto.getQna_num());
		
			cnt=pstmt.executeUpdate(); 
			
		} catch (Exception e) {
			System.out.println("행수정 실패 : " + e);
		}finally {
			DBclose.close(con,pstmt);
		}//end
		return cnt;
	}//updateproc() end
	
	public ArrayList<QnaDTO> list(){
		ArrayList<QnaDTO> list=null;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select qna_num, qna_title, qna_date, qna_content, mem_id, qna_readcnt ");
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
					dto.setQna_readcnt(rs.getInt("qna_readcnt"));
					
					
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
	
	public ArrayList<QnaDTO> list2(String col,String word){
		ArrayList<QnaDTO> list=null;
		try {
			con=dbopen.getConnection();
			
			sql=new StringBuilder();
			sql.append(" select qna_num, qna_title, qna_date, qna_content, mem_id, qna_readcnt ");
			sql.append(" from tb_qna ");
			
			
			//검색어가 존재한다면
			if(word.length()>=1) {
				String search="";
				if(col.equals("qna_title_qna_content")) {
					search+= " WHERE qna_title LIKE '%"+ word + "%' ";
					search+= " OR qna_content LIKE '%"+ word + "%' ";
				}else if(col.equals("qna_title")) {
					search+= " WHERE qna_title LIKE '%"+ word + "%' ";
				}else if(col.equals("qna_content")) {
					search+= " WHERE qna_content LIKE '%"+ word + "%' ";
				}else if(col.equals("mem_id")) {
					search+= " WHERE mem_id LIKE '%"+ word + "%' ";
				}//if end
				sql.append(search);
				System.out.println(search + "검색 성공");
			}//if end
			
			
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
					dto.setQna_readcnt(rs.getInt("qna_readcnt"));
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
	}//end
	
	public ArrayList<QnaDTO> list3(String col,String word, int nowPage, int recordPerPage){
        ArrayList<QnaDTO> list=null; 
        
        // 페이지당 출력할 레코드 갯수 (10개를 기준)
        // 1 page : WHERE r>=1 AND r<=10
        // 2 page : WHERE r>=11 AND r<=20
        // 3 page : WHERE r>=21 AND r<=30
        int startRow = ((nowPage-1) * recordPerPage) + 1 ;
        int endRow   = nowPage * recordPerPage;
        try {
			con=dbopen.getConnection(); 
			sql=new StringBuilder();
			
			//word = word.trim();
			
			if(word.length()==0) {//검색을 하지 않는 경우
	            sql.append(" SELECT qna_num, qna_title, qna_date, qna_content, mem_id, qna_readcnt ");
	            sql.append(" FROM( SELECT qna_num, qna_title, qna_date, qna_content, mem_id, qna_readcnt, @RNO := @RNO + 1 AS r ");
	            sql.append("       FROM ( ");
	            sql.append("              SELECT qna_num, qna_title, qna_date, qna_content, mem_id, qna_readcnt ");
	            sql.append("              FROM tb_qna ORDER BY qna_grpno DESC, qna_ansnum ASC)A, (SELECT @RNO := 0) B");
	            sql.append("           )C");
	            sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
			}else {
				
				
				sql.append(" SELECT qna_num, qna_title, qna_date, qna_content, mem_id, qna_readcnt ");
	            sql.append(" FROM( SELECT qna_num, qna_title, qna_date, qna_content, mem_id, qna_readcnt, @RNO := @RNO + 1 AS r ");
	            sql.append("       FROM ( ");
	            sql.append("              SELECT qna_num, qna_title, qna_date, qna_content, mem_id, qna_readcnt ");
	            sql.append("              FROM tb_qna ");
	            
	            String search="";
				if(col.equals("qna_title_qna_content")) {
					search+= " WHERE qna_title LIKE '%"+ word + "%' ";
					search+= " OR qna_content LIKE '%"+ word + "%' ";
				}else if(col.equals("qna_title")) {
					search+= " WHERE qna_title LIKE '%"+ word + "%' ";
				}else if(col.equals("qna_content")) {
					search+= " WHERE qna_content LIKE '%"+ word + "%' ";
				}else if(col.equals("mem_id")) {
					search+= " WHERE mem_id LIKE '%"+ word + "%' ";
				}//if end
				sql.append(search);
	            sql.append("              			  ORDER BY qna_grpno DESC, qna_ansnum ASC)A, (SELECT @RNO := 0) B");
	            sql.append("           )C");
	            sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
			}
	      
          pstmt=con.prepareStatement(sql.toString());
          rs=pstmt.executeQuery();
          if(rs.next()){
            list=new ArrayList<>();
            do{
            	QnaDTO dto=new QnaDTO();//한줄담기
            	dto.setQna_num(rs.getInt("qna_num"));
				dto.setQna_title(rs.getString("qna_title"));
				dto.setQna_date(rs.getString("qna_date"));
				dto.setQna_content(rs.getString("qna_content"));
				dto.setMem_id(rs.getString("mem_id"));
				dto.setQna_readcnt(rs.getInt("qna_readcnt"));
				list.add(dto); //list에 모으기
            }while(rs.next());
          }//if end
          
        }catch(Exception e) {
          System.out.println("목록 페이징 실패: "+e);
        }finally {
          DBclose.close(con, pstmt, rs);
        }   
        return list;              
              
    }//list3() end
	
	public int count(String col,String word) {
		int cnt=0;
		try {
			con=dbopen.getConnection();
				
			sql=new StringBuilder();
			sql.append(" SELECT COUNT(*) as cnt ");
			sql.append(" FROM tb_qna  ");
			
			if(word.length()>=1) {
				String search="";
				if(col.equals("qna_title_qna_content")) {
					search+= " WHERE qna_title LIKE '%"+ word + "%' ";
					search+= " OR qna_content LIKE '%"+ word + "%' ";
				}else if(col.equals("qna_title")) {
					search+= " WHERE qna_title LIKE '%"+ word + "%' ";
				}else if(col.equals("qna_content")) {
					search+= " WHERE qna_content LIKE '%"+ word + "%' ";
				}else if(col.equals("mem_id")) {
					search+= " WHERE mem_id LIKE '%"+ word + "%' ";
				}//if end
				sql.append(search);
			}//if end
			
			
				
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			if(rs.next()) {
					cnt=rs.getInt("cnt");
			}//if end
				
	
		} catch (Exception e) {
			System.out.println("목록 실패 : " + e);
		}finally {
			DBclose.close(con,pstmt,rs);
		}//end
		return cnt;
	}//count2 end
	
	
	

}//class end

