package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Flights;
import models.People;
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

        String userIdAsString = req.getHeader("user_ID");
        System.out.println(userIdAsString);

        switch(action){
            case "UserPurchaseTickets":

                String[] uptickets = JSONSplitter.jsonSplitter(jsonText);
                System.out.println("DEBUG: " +uptickets.length);

                int numberOfTickets = Integer.parseInt(uptickets[2].substring(1,uptickets[2].length()-1));

                while(numberOfTickets>0) {
                    Tickets_People_Flights addtpf = new Tickets_People_Flights();
                    Flights addtpfFlight = FlightService.getFlightById(Integer.parseInt(uptickets[4].substring(1,uptickets[4].length()-1))); // sets flight
                    People addtpfPerson = PeopleService.getPersonById(Integer.parseInt(userIdAsString)); // sets user
                    addtpf.setChecked_in(false);
                    addtpf.setFlight(addtpfFlight);
                    addtpf.setPerson(addtpfPerson);

                    TicketService.buyNewTicket(addtpf);
                    numberOfTickets--;
                }

                resp.setContentType("text/plain");
                resp.setStatus(200);
                break;

            case "UserCancelTicket":

                String[] ucticket = JSONSplitter.jsonSplitter(jsonText);

                System.out.println(ucticket);
                Integer cticketID = Integer.parseInt(ucticket[2].substring(1,ucticket[2].length()-1));
                Tickets_People_Flights cticket = TicketService.getTicketByID(cticketID);
                TicketService.cancelTicket(cticket);

                String msgCancelledTicket = "Ticket number " + ucticket[2].substring(1,ucticket[2].length()-1) + " cancelled. Thank you for using AirPortal.";
                if(dbg){System.out.println(msgCancelledTicket);}
                resp.setContentType("text/plain");
                resp.setStatus(200);

            break;
            case "UserCheckin":
                String[] ucheckin = JSONSplitter.jsonSplitter(jsonText);

                Tickets_People_Flights ccheck = TicketService.getTicketByID(Integer.parseInt(ucheckin[2].substring(1,ucheckin[2].length()-1)));
                TicketService.checkinTicket(ccheck);

                String msgUserCheckedIn = "Ticket number " + ucheckin[2].substring(1,ucheckin[2].length()-1) + " has been checked in. Please proceed to the waiting area near gate G.";
                if(dbg){System.out.println(msgUserCheckedIn);}
                resp.setContentType("text/plain");
                resp.setStatus(200);
                break;
        }

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    }

}
