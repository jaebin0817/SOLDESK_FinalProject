package kr.co.finalproject.party;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.utility.DBclose;
import net.utility.DBopen;

public class PartyMemDAO {
	private DBopen dbopen=null;
    private Connection con=null;
    private PreparedStatement pstmt=null;
    private ResultSet rs=null;
    private StringBuilder sql=null;
    
    public PartyMemDAO() {
    	dbopen=new DBopen();
    }
    
    public int cardIns(PartyMemDTO dto) {
    	int cnt = 0;
    	try {
            con = dbopen.getConnection();
            sql = new StringBuilder();
            sql.append(" INSERT INTO payment_card(mem_id, card_exp, card_no, card_pw, card_com) ");
            sql.append(" VALUES( 'kimkim12', ?, ?, ?, ?) "); 
            
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setString(1, dto.getCard_exp()); 
            pstmt.setString(2, dto.getCard_no());
            pstmt.setInt(3, dto.getCard_pw());
            pstmt.setString(4, dto.getCard_com());
            cnt = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("카드등록 실패 : " + e);
        } finally {
            DBclose.close(con, pstmt);
        }//end
        return cnt;
    	
    }//cardIns() end
	

}//class end
