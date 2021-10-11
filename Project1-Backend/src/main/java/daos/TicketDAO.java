package daos;

import utils.ConnectionManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDAO{


    private Connection conn = ConnectionManager.getConnection();

    public TicketDAO() throws SQLException, IOException, ClassNotFoundException {
    }


    //Create

    //read

    //update

    //delete
    //Right now, we are using the ticket_id to find the flight_id in the
    //same row of the DB table, and returning the flight_id,

    // WE ARE NOT DELETING ANYTHING RIGHT NOW

    public int delete(int ticket_id) throws Exception{

        int flight_id=0;
        String sql = "SELECT * FROM tickets_people_flights WHERE ticket_id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1,ticket_id); // puts ticket_id into first ? in "sql" string
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            flight_id = rs.getInt(3);
        }
        return flight_id;
    }


}
