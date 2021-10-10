package servlets;

import daos.TicketDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletManager extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String string_ticket_id = req.getParameter("ticket_id");
        int ticket_id = Integer.parseInt(string_ticket_id);
        try{
            TicketDAO dao = new TicketDAO();
            int flight_id = dao.delete(ticket_id);
            resp.getWriter().println("Ticket #: "+ticket_id + " has almost been cancelled");
            resp.getWriter().print("You no longer have a ticket for flight number: "+flight_id);
            resp.setStatus(200);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){

    }

}
