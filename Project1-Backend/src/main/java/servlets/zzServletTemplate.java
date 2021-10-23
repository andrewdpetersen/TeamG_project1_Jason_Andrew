package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class zzServletTemplate extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        /**
         * Servlet template
         */
        System.out.println("DEBUG- SERVER REACHED");//take this out after debug finished

        //These lines read the request body and put it into a string called jsonText
        InputStream requestBody = req.getInputStream();
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        //This will be a set of key-value pairs, like "numberOfTickets": 3, "userFlightID":4, "userCancelTickeID": 4

        System.out.println("DEBUG FlightID- JSON Text: " + jsonText);//take this out after debugging

        //get the action from the request header
        String action = req.getHeader("Servlet-action");
        System.out.println("DEBUG- action: "+action);

        switch(action){
            case "UserPurchaseTickets":
                //TODO: Write logic to add ticket(s) to DB here-
                // unique to action and the servlet, for example:
                // UserPurchaseTickets on tickets will need us to unmarshall a flight ID and a number of
                // tickets, and save that number of tickets in the DB using hibernate.
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