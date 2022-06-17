package kr.co.finalproject.contlistgroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    }//end
    
   
    
    public ArrayList<ContlistDTO> contlistall(){
        ArrayList<ContlistDTO> list=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" SELECT * ");
            sql.append(" FROM contlist ");
            sql.append(" ORDER BY mcode DESC ");
            pstmt=con.prepareStatement(sql.toString());
            rs=pstmt.executeQuery();
            if(rs.next()) {
                list=new ArrayList<ContlistDTO>();
                do{
                    ContlistDTO dto=new ContlistDTO();
                    dto.setMtitle(rs.getString("mtitle"));
                    dto.setMthum(rs.getString("mthum"));
                    dto.setMrate(rs.getInt("mrate"));
                    dto.setNetflix(rs.getString("netflix"));
                    dto.setWatcha(rs.getString("watcha"));
                    dto.setTving(rs.getString("tving"));
                    dto.setDiseny(rs.getString("diseny"));
                    dto.setMdate(rs.getString("mdate"));
                    dto.setCri_like(rs.getString("cri_like"));
                    dto.setKey_code(rs.getString("key_code"));
                    list.add(dto);
                    
                }while(rs.next());
            }//if end
            
        }catch(Exception e) {
            System.out.println("컨텐츠 리스트 불러오기 실패 : "+e);
        }finally{
            DBclose.close(con, pstmt, rs);
        }//end    
        return list;
    }//list() end
    

    
    
    
    
}//class end
