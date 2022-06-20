package kr.co.finalproject.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import net.utility.DBclose;
import net.utility.DBopen;

public class ReviewDAO {
    
	private DBopen dbopen=null;
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private StringBuilder sql=null;
    
    public ReviewDAO() {
    	dbopen=new DBopen();
    }//end
    

    
    public ReviewDTO reviewAll(int mcode){
        ReviewDTO dto2=null;
        try {
            con=dbopen.getConnection();
            sql=new StringBuilder();
            sql.append(" SELECT * ");
            sql.append(" FROM review ");
            sql.append(" WHERE mcode=? ");
            sql.append(" ORDER BY rev_code ASC ");
           
            
            pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, mcode);
            
            rs=pstmt.executeQuery();
            if(rs.next()) {
                    dto2=new ReviewDTO();
                    dto2.setMcode(mcode);
                    dto2.setRev_code(rs.getInt("rev_code"));
                    dto2.setMem_id(rs.getString("mem_id"));
                    dto2.setRev_title(rs.getString("rev_title"));
                    dto2.setRev_reg(rs.getString("rev_reg"));
                    dto2.setRev_cont(rs.getString("rev_cont"));
                    dto2.setRev_spo(rs.getString("rev_spo"));
                    dto2.setRev_rate(rs.getInt("rev_rate"));
                    
                }while(rs.next());
            
        }catch(Exception e) {
            System.out.println("리뷰 목록 불러오기 실패 : "+e);
        }finally{
            DBclose.close(con, pstmt, rs);
        }//end    
        return dto2;
    }//list() end



    
    
    
    
    
    
}//class end