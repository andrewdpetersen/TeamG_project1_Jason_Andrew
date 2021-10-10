package daos;

import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TicketDAO{


    private Connection conn;



    //Create

    //read

    //update

    //delete
    public void delete(int ticket_id) throws Exception{

        String sql = "DELETE FROM tickets_people_flights WHERE ticket_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1,ticket_id); // puts ticket_id into first ? in "sql" string
        pstmt.executeUpdate();
    }


}
