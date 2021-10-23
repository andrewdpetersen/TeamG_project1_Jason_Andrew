package servlets;

import models.Tickets_People_Flights;
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
                //TODO: Write logic to add ticket(s) to DB here-
                // unique to action and the servlet, for example:
                // UserPurchaseTickets on tickets will need us to unmarshall a flight ID and a number of
                // tickets, and save that number of tickets in the DB using hibernate.
                // TODO: unmarshall
                // JSONSplitter.jsonSplitter(jsonText);
                // TODO: setup objects, add data from unmarshalled JSON
                Tickets_People_Flights addtpf = new Tickets_People_Flights(); // JSON{flight_id}, ticket_id,user_id
                addtpf.setFlight();
                
                // TODO: have hibernate get flight obj by flight_id
                // TODO: have hibernate get user obj by user_id
                // TODO: set both as fields of addtpf

                // TODO: call hibernate methods on objects
                // TODO: call buyNewTicket on addtpf

//        "numberOfTickets": nots.value,
//        "userFlightID": ufid.value,
                break;
            case "UserCancelTicket":
                //TODO: write logic to delete a ticket here
//        "userCancelTickeID": ucts.value
                break;
            case "UserCheckin":
                //TODO: write logic to checkIn here
//        "checkinTicketID": ctid.value,
        }

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    }

}
