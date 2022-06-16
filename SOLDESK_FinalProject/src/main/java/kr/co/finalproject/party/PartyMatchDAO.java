package kr.co.finalproject.party;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.utility.DBclose;
import net.utility.DBopen;

public class PartyMatchDAO {
	private DBopen dbopen=null;
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private StringBuilder sql=null;
    
    public PartyMatchDAO() {
    	dbopen=new DBopen();
    }
    
    public int memberwait(PartyMatchDTO dto) {
    	int cnt = 0;
    	try {
            con = dbopen.getConnection();
            sql = new StringBuilder();
            sql.append(" INSERT INTO party_waiting(mem_id, ott_name, waiting_date) ");
            sql.append(" VALUES( ?, ?, now()) "); 

            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getMem_id()); 
            pstmt.setString(2, dto.getOtt_name()); 
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("카드등록 실패 : " + e);
        } finally {
            DBclose.close(con, pstmt);
        }//end
        return cnt;
    }//class end

}//class end
