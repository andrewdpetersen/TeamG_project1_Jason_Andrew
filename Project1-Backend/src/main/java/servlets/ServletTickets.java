package servlets;

import models.Tickets_People_Flights;
import services.FlightService;
import services.PeopleService;
import services.TicketService;
import utils.JSONSplitter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ServletTickets extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean dbg=true;
/**
 * Servlet template
 */
        if(dbg){System.out.println("DEBUG- SERVER REACHED");}//set dbg false after debug finished

        //These lines read the request body and put it into a string called jsonText
        InputStream requestBody = req.getInputStream();
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        //This will be a set of key-value pairs, like "numberOfTickets": 3, "userFlightID":4, "userCancelTickeID": 4

        if(dbg){System.out.println("DEBUG FlightID- JSON Text: " + jsonText);}//take this out after debugging

        //get the action from the request header
        String action = req.getHeader("Servlet-action");
        if(dbg){System.out.println("DEBUG- action: "+action);}

        switch(action){
            case "UserPurchaseTickets":

                String[] uptickets = JSONSplitter.jsonSplitter(jsonText);

                Tickets_People_Flights addtpf = new Tickets_People_Flights(); // JSON{flight_id}, ticket_id,user_id
                addtpf.setFlight(FlightService.getFlightById(Integer.parseInt(uptickets[3]))); // sets flight
                addtpf.setPerson(PeopleService.getPersonById(3)); //not getting from JSON..

                // TODO: add a user_id to JSON OR use local user_id

                TicketService.buyNewTicket(addtpf);

//        "numberOfTickets": nots.value,
//        "userFlightID": ufid.value,
                break;
            case "UserCancelTicket":

                String[] ucticket = JSONSplitter.jsonSplitter(jsonText);

                Tickets_People_Flights cticket = TicketService.getTicketByID(Integer.parseInt(ucticket[2])); // TODO: write getTicketByID
                TicketService.cancelTicket(cticket);
//                Tickets_People_Flights addtpf = new Tickets_People_Flights(); // JSON{flight_id}, ticket_id,user_id
//                addtpf.setFlight();

                // TODO: write response logic.. such as "Ticket's purchased: 5, for Chicago to LA"
                break;
            case "UserCheckin":

                String[] ucheckin = JSONSplitter.jsonSplitter(jsonText);

                Tickets_People_Flights ccheck = TicketService.getTicketByID(Integer.parseInt(ucheckin[2]));
                TicketService.checkinTicket(ccheck);
//                Tickets_People_Flights addtpf = new Tickets_People_Flights(); // JSON{flight_id}, ticket_id,user_id
//                addtpf.setFlight();

                // TODO: write response logic.. such as "Ticket's purchased: 5, for Chicago to LA"
                break;
//        "checkinTicketID": ctid.value,
        }

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    }

}
