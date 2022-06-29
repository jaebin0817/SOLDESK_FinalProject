package kr.co.finalproject.contlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.finalproject.notice.NoticeDTO;
import net.utility.DBclose;
import net.utility.DBopen;

public class ContlistDAO {

	private DBopen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public ContlistDAO() {
		dbopen=new DBopen();
	}
	
	
	public ArrayList<ContlistDTO> contlistAll() {
		ContlistDTO dto=null;
		
		ArrayList<ContlistDTO> list=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, cri_like, key_code, mcode ");
			sql.append(" FROM contlist ");
			sql.append(" ORDER BY mcode DESC ");
			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ContlistDTO>();				
				do {
					dto = new ContlistDTO();//커서가 가리키는 한 줄 저장
					dto.setMtitle(rs.getString("mtitle"));
					dto.setMthum(rs.getString("mthum"));
					dto.setMrate(rs.getDouble("mrate"));
					dto.setNetflix(rs.getString("netflix"));
					dto.setWatcha(rs.getString("watcha"));
					dto.setTving(rs.getString("tving"));
					dto.setDiseny(rs.getString("diseny"));
					dto.setMdate(rs.getString("mdate"));
					dto.setCri_like(rs.getInt("cri_like"));
					dto.setKey_code(rs.getString("key_code"));
					dto.setMcode(rs.getInt("mcode"));
					list.add(dto);
				}while(rs.next());
			}//if end
			
		}catch (Exception e) {
			System.out.println("컨텐츠리스트 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		
		return list;
		
	}
	
	
	public ContlistDTO contlist(int mcode) {
		ContlistDTO dto=null;
		
		try {
			con=dbopen.getConnection();//DB연결
			sql=new StringBuilder();
			sql.append(" SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, cri_like, key_code, mcode, maudio, director, actor ");
			sql.append(" FROM contlist ");
			sql.append(" WHERE mcode=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, mcode);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
					dto = new ContlistDTO();//커서가 가리키는 한 줄 저장
					dto.setMtitle(rs.getString("mtitle"));
					dto.setMthum(rs.getString("mthum"));
					dto.setMrate(rs.getDouble("mrate"));
					dto.setNetflix(rs.getString("netflix"));
					dto.setWatcha(rs.getString("watcha"));
					dto.setTving(rs.getString("tving"));
					dto.setDiseny(rs.getString("diseny"));
					dto.setMdate(rs.getString("mdate"));
					dto.setCri_like(rs.getInt("cri_like"));
					dto.setKey_code(rs.getString("key_code"));
					dto.setMcode(rs.getInt("mcode"));
					dto.setMaudio(rs.getString("maudio"));
					dto.setDirector(rs.getString("director"));
					dto.setActor(rs.getString("actor"));
			}//if end
			
		}catch (Exception e) {
			System.out.println("컨텐츠리스트 불러오기 실패: " + e);
		}finally{
			DBclose.close(con, pstmt, rs);
		}//try end
		return dto;
	}
	
	
	   public ContlistDTO contlistread(int mcode) {
	    	ContlistDTO dto=null;
	       try {
	           con=dbopen.getConnection();
	           
	           sql=new StringBuilder();
	           sql.append(" SELECT review.*, contlist.*");
	           sql.append(" FROM contlist ");
	           sql.append(" LEFT OUTER JOIN review ");
	           sql.append("  ON review.mcode = contlist.mcode ");
	           sql.append("  WHERE contlist.mcode=? ");
	           sql.append(" ORDER BY contlist.mcode; ");
	           
	           pstmt=con.prepareStatement(sql.toString());
	           pstmt.setInt(1, mcode);
	           
	           rs=pstmt.executeQuery();
	           if(rs.next()) {
	        	   dto=new ContlistDTO(); // dto 생성 후  값 넣어주기.
	        	   dto.setMcode(mcode); // mcode는 그대로 받아줌.
	        	   dto.setMtitle(rs.getString("mtitle"));
	        	   dto.setMthum(rs.getString("mthum"));
	        	   dto.setMrate(rs.getDouble("mrate"));
	        	   dto.setNetflix(rs.getString("netflix"));
	        	   dto.setWatcha(rs.getString("watcha"));
	        	   dto.setTving(rs.getString("tving"));
	        	   dto.setDiseny(rs.getString("diseny"));
	        	   dto.setMdate(rs.getString("mdate"));
				   dto.setCri_like(rs.getInt("cri_like"));
	        	   dto.setKey_code(rs.getString("key_code"));
	        	   dto.setDirector(rs.getString("director"));
	        	   dto.setActor(rs.getString("actor"));
	        	   
	           }//end
	           
	       }catch (Exception e) {
	           System.out.println("컨텐츠 상세보기실패:"+e);
	       }finally {
	           DBclose.close(con, pstmt, rs);
	       }//end
	       return dto;
	   }// read() end

	   
	    public ContlistDTO KeywordRead(String key_code) {
	        ContlistDTO dto=null;
	        try {
	            con=dbopen.getConnection();
	            
	            sql=new StringBuilder();
	            sql.append(" SELECT key_name ");
	            sql.append(" FROM search_key ");
	            sql.append(" WHERE key_code=? ");
	            
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setString(1, key_code);
	            
	            rs=pstmt.executeQuery();
	            if(rs.next()) {
	               dto=new ContlistDTO(); // dto 생성 후  값 넣어주기.
	               dto.setKey_code(rs.getString("key_code"));


	            }//end
	            
	        }catch (Exception e) {
	            System.out.println("컨텐츠 키워드 불러오기 실패:"+e);
	        }finally {
	            DBclose.close(con, pstmt, rs);
	        }//end
	        return dto;
	    }// read() end
		
	    
	    public ArrayList<ContlistDTO> searchPart(String key_code) {
			ContlistDTO dto=null;
			ArrayList<ContlistDTO> list=null;
			
			try {
				con=dbopen.getConnection();//DB연결
				sql=new StringBuilder();
				sql.append(" SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, cri_like, key_code, mcode ");
				sql.append(" FROM contlist ");
				sql.append(" WHERE key_code LIKE '%"+key_code+"%' ");
				sql.append(" ORDER BY mcode DESC ");
				pstmt = con.prepareStatement(sql.toString());
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					list=new ArrayList<ContlistDTO>();				
					do {
						dto = new ContlistDTO();//커서가 가리키는 한 줄 저장
						dto.setMtitle(rs.getString("mtitle"));
						dto.setMthum(rs.getString("mthum"));
						dto.setMrate(rs.getDouble("mrate"));
						dto.setNetflix(rs.getString("netflix"));
						dto.setWatcha(rs.getString("watcha"));
						dto.setTving(rs.getString("tving"));
						dto.setDiseny(rs.getString("diseny"));
						dto.setMdate(rs.getString("mdate"));
						dto.setCri_like(rs.getInt("cri_like"));
						dto.setKey_code(rs.getString("key_code"));
						dto.setMcode(rs.getInt("mcode"));
						list.add(dto);
					}while(rs.next());
				}//if end
				
			}catch (Exception e) {
				System.out.println("컨텐츠리스트 불러오기 실패: " + e);
			}finally{
				DBclose.close(con, pstmt, rs);
			}//try end
			
			return list;
			
		}
	   
	   
	   
		public int insert(ContlistDTO dto) {
			int cnt=0;
			
			try {
				con=dbopen.getConnection();//DB연결
				sql=new StringBuilder();
				sql.append(" INSERT INTO contlist (mtitle, mthum, netflix, watcha, tving, diseny, mdate, key_code, maudio, director, actor) ");
				sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, dto.getMtitle());
				pstmt.setString(2, dto.getMthum());
				pstmt.setString(3, dto.getNetflix());
				pstmt.setString(4, dto.getWatcha());
				pstmt.setString(5, dto.getTving());
				pstmt.setString(6, dto.getDiseny());
				pstmt.setString(7, dto.getMdate());
				pstmt.setString(8, dto.getKey_code());
				pstmt.setString(9, dto.getMaudio());
				pstmt.setString(10, dto.getDirector());
				pstmt.setString(11, dto.getActor());
				
				cnt=pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("컨텐츠 추가 실패: " + e);
			} finally {
				DBclose.close(con, pstmt);
			}//try end
			
			
			return cnt;
			
		}//insert() end
	   
		
		
		public String readDirector(String pname) {
			String pno = null;
			try {
				con = dbopen.getConnection();
				sql = new StringBuilder();
				sql.append(" SELECT pno ");
				sql.append(" FROM people ");
				sql.append(" WHERE pname=? AND pno LIKE 'D_%' ");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, pname);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					pno = rs.getString("pno");
				}

			} catch (Exception e) {
				System.out.println("감독 불러오기 실패 : " + e);
			} finally {
				DBclose.close(con, pstmt, rs);
			}
			return pno;

		}
	
		
		public String readActor(String pname) {
			String pno = null;
			try {
				con = dbopen.getConnection();
				sql = new StringBuilder();
				sql.append(" SELECT pno ");
				sql.append(" FROM people ");
				sql.append(" WHERE pname=? AND pno LIKE 'A_%' ");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, pname);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					pno = rs.getString("pno");
				}

			} catch (Exception e) {
				System.out.println("배우 불러오기 실패 : " + e);
			} finally {
				DBclose.close(con, pstmt, rs);
			}
			return pno;
		}
		
		
		public String readPno(String searchname) {
			String pno = null;
			try {
				con = dbopen.getConnection();
				sql = new StringBuilder();
				sql.append(" SELECT pno ");
				sql.append(" FROM people ");
				sql.append(" WHERE pname LIKE '%"+searchname+"%' ");
				
				pstmt = con.prepareStatement(sql.toString());

				rs = pstmt.executeQuery();
				if (rs.next()) {
					pno = rs.getString("pno");
				}

			} catch (Exception e) {
				System.out.println("인물 불러오기 실패 : " + e);
			} finally {
				DBclose.close(con, pstmt, rs);
			}
			return pno;
		}
		
		
		
		public String readPname(String pno) {
			String pname = null;
			try {
				con = dbopen.getConnection();
				sql = new StringBuilder();
				sql.append(" SELECT pname ");
				sql.append(" FROM people ");
				sql.append(" WHERE pno=? ");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, pno);

				rs = pstmt.executeQuery();
				if (rs.next()) {
					pname = rs.getString("pname");
				}

			} catch (Exception e) {
				System.out.println("이름 불러오기 실패 : " + e);
			} finally {
				DBclose.close(con, pstmt, rs);
			}
			return pname;
		}

		
		
		public int contUpdate(ContlistDTO dto) {
			int cnt=0;
			
			try {
				con=dbopen.getConnection();//DB연결
				sql=new StringBuilder();
				sql.append(" UPDATE contlist ");
				sql.append(" SET mtitle=?, mthum=?, netflix=?, watcha=?, tving=?, diseny=?, ");
				sql.append(" 	 mdate=?, key_code=?, maudio=?, director=?, actor=?  ");
				sql.append(" WHERE mcode=?  ");

				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, dto.getMtitle());
				pstmt.setString(2, dto.getMthum());
				pstmt.setString(3, dto.getNetflix());
				pstmt.setString(4, dto.getWatcha());
				pstmt.setString(5, dto.getTving());
				pstmt.setString(6, dto.getDiseny());
				pstmt.setString(7, dto.getMdate());
				pstmt.setString(8, dto.getKey_code());
				pstmt.setString(9, dto.getMaudio());
				pstmt.setString(10, dto.getDirector());
				pstmt.setString(11, dto.getActor());
				pstmt.setInt(12, dto.getMcode());

				
				cnt=pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("컨텐츠 수정 실패: " + e);
			} finally {
				DBclose.close(con, pstmt);
			}//try end
			
			
			return cnt;
			
		}//insert() end
		
		
		
		public ArrayList<ContlistDTO> mainsearch(String searchkey, String pno) {
			
			ArrayList<ContlistDTO> list=null;
			ContlistDTO dto=null;
			
			try {
				con=dbopen.getConnection();//DB연결
				sql=new StringBuilder();
				sql.append(" SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, key_code, cri_like, mcode, director, actor ");
				sql.append(" FROM contlist ");
				sql.append(" WHERE mtitle LIKE '%"+searchkey+"%' ");
				sql.append(" 	OR director LIKE '%"+pno+"%' ");
				sql.append(" 	OR actor LIKE '%"+pno+"%' ");
				sql.append(" ORDER BY mcode DESC ");
				
				pstmt = con.prepareStatement(sql.toString());

				rs = pstmt.executeQuery();
				if(rs.next()) {
					list=new ArrayList<ContlistDTO>();				
					do {
						dto = new ContlistDTO();//커서가 가리키는 한 줄 저장
						dto.setMtitle(rs.getString("mtitle"));
						dto.setMthum(rs.getString("mthum"));
						dto.setMrate(rs.getDouble("mrate"));
						dto.setNetflix(rs.getString("netflix"));
						dto.setWatcha(rs.getString("watcha"));
						dto.setTving(rs.getString("tving"));
						dto.setDiseny(rs.getString("diseny"));
						dto.setMdate(rs.getString("mdate"));
						dto.setCri_like(rs.getInt("cri_like"));
						dto.setKey_code(rs.getString("key_code"));
						dto.setMcode(rs.getInt("mcode"));
						dto.setActor(rs.getString("actor"));
						dto.setDirector(rs.getString("director"));
						
						list.add(dto);
					}while(rs.next());
				}//if end
				
			} catch (Exception e) {
				System.out.println("컨텐츠 검색 실패: " + e);
			} finally {
				DBclose.close(con, pstmt);
			}//try end
			
			
			return list;
			
		}//mainsearch() end
		
		public int count(String col, String word) {
	    	int cnt=0;
	    	try {
				con=dbopen.getConnection();
				
				sql=new StringBuilder();
				sql.append(" SELECT COUNT(*) as cnt ");
				sql.append(" FROM contlist ");
				
				if(word.length()>=1) {
					String search="";
					if(col.equals("mcode")) {
						search+= " WHERE mcode LIKE '%" + word + "%' ";
					}else if(col.equals("mtitle")) {
						search+= " WHERE mtitle LIKE '%" + word + "%' ";
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
		
		
		
		public ArrayList<ContlistDTO> list2(String col,String word, int nowPage, int recordPerPage){
	    	ArrayList<ContlistDTO> list=null;
	    	
	    	int startRow = ((nowPage-1) * recordPerPage) + 1 ;
	        int endRow   = nowPage * recordPerPage;
	    	try {
	    		con=dbopen.getConnection(); 
				sql=new StringBuilder();
				
				if(word.length()==0) { 
					sql.append(" SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, key_code, cri_like, mcode, director, actor ");
		            sql.append(" FROM( SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, key_code, cri_like, mcode, director, actor, @RNO := @RNO + 1 AS r ");
		            sql.append("       FROM ( ");
		            sql.append("              SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, key_code, cri_like, mcode, director, actor ");
		            sql.append("              FROM contlist ORDER BY mcode DESC)A, (SELECT @RNO := 0) B ");
		            sql.append("           )C");
		            sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
				}else {
					sql.append(" SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, key_code, cri_like, mcode, director, actor ");
		            sql.append(" FROM( SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, key_code, cri_like, mcode, director, actor, @RNO := @RNO + 1 AS r ");
		            sql.append("       FROM ( ");
		            sql.append("              SELECT mtitle, mthum, mrate, netflix, watcha, tving, diseny, mdate, key_code, cri_like, mcode, director, actor ");
		            sql.append("              FROM contlist  ");
		            String search="";
					if(col.equals("mcode")) {
						search+= " WHERE mcode LIKE '%" + word + "%' ";
					}else if(col.equals("mtitle")) {
						search+= " WHERE mtitle LIKE '%" + word + "%' ";
					}//if end
					sql.append(search);
		            sql.append("              				ORDER BY mcode DESC)A, (SELECT @RNO := 0) B ");
		            sql.append("           )C");
		            sql.append(" WHERE r>=" + startRow + " AND r<=" + endRow) ;
				}
			pstmt=con.prepareStatement(sql.toString());
		    rs=pstmt.executeQuery();
		    if(rs.next()) {
		    	list=new ArrayList<>();
		    	do {
		    		ContlistDTO dto = new ContlistDTO();//커서가 가리키는 한 줄 저장
					dto.setMtitle(rs.getString("mtitle"));
					dto.setMthum(rs.getString("mthum"));
					dto.setMrate(rs.getDouble("mrate"));
					dto.setNetflix(rs.getString("netflix"));
					dto.setWatcha(rs.getString("watcha"));
					dto.setTving(rs.getString("tving"));
					dto.setDiseny(rs.getString("diseny"));
					dto.setMdate(rs.getString("mdate"));
					dto.setCri_like(rs.getInt("cri_like"));
					dto.setKey_code(rs.getString("key_code"));
					dto.setMcode(rs.getInt("mcode"));
					dto.setActor(rs.getString("actor"));
					dto.setDirector(rs.getString("director"));
					
					list.add(dto);
		    	}while(rs.next());
		    }
	    		
	    	}catch (Exception e) {
				System.out.println("목록 불러오기 실패 : " + e);
			}finally {
				DBclose.close(con,pstmt,rs);
			}
	    	
	    	return list;
	    }//list3() end
		
		public int count1() {
	    	int cnt=0;
	    	try {
				con=dbopen.getConnection();
				
				sql=new StringBuilder();
				sql.append(" SELECT COUNT(*) as cnt ");
				sql.append(" FROM contlist ");
				
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
		

}//class end
