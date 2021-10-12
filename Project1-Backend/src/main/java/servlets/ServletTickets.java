package servlets;

import daos.TicketDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletTickets extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //write logic to create a ticket here

        //write logic to delete a ticket here

        String string_ticket_id = req.getParameter("ticket_id");
        int ticket_id = Integer.parseInt(string_ticket_id);
        try {
            TicketDAO dao = new TicketDAO();
            int flight_id = dao.delete(ticket_id);
            resp.getWriter().println("Ticket #: " + ticket_id + " has almost been cancelled");
            resp.getWriter().print("You no longer have a ticket for flight number: " + flight_id);
            resp.setStatus(200);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //write logic to delete all tickets for a given flight here
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //write logic to get all tickets for a given flight here
    }

}
