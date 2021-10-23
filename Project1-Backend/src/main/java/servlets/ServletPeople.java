package servlets;

import models.Flights;
import models.People;
import models.Tickets_People_Flights;
import services.FlightService;
import services.PeopleService;
import services.TicketService;
import utils.FileLogger;
import utils.JSONSplitter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ServletPeople extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean dbg=true;
        System.out.println("DEBUG- PeopleServlet REACHED");//take this out after debug finished
        FileLogger.getFileLogger().writeLog("DEBUG- PeopleServlet REACHED",0);

        //These lines read the request body and put it into a string called jsonText
        InputStream requestBody = req.getInputStream(); // from java.util
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        //This will be a set of key-value pairs, like "numberOfTickets": 3, "userFlightID":4, "userCancelTickeID": 4

        FileLogger.getFileLogger().writeLog("DEBUG PeopleServletJSON- JSON Text: " + jsonText,0);

        //get the action from the request header
        String action = req.getHeader("Servlet-action");
        if(dbg){System.out.println("DEBUG- action: "+action);}
        FileLogger.getFileLogger().writeLog("DEBUG- action: "+action,0);

        switch(action){
            case "DeleteCustomerFlight":

                String[] dcflight =JSONSplitter.jsonSplitter(jsonText);
                People dcustomer = PeopleService.getPersonById(Integer.parseInt(dcflight[1]));
                Flights dflight = FlightService.getFlightById(Integer.parseInt(dcflight[3]));

                TicketService.cancelTicketByCustomerFlight(dcustomer,dflight);

                String msgTicketCancelled= "Flight ticket canceled for customer " + dcustomer + " on flight " + dflight + ".";
                if(dbg){System.out.println(msgTicketCancelled);}  // debug send to console
                resp.getWriter().println(msgTicketCancelled); // send to webpage
                resp.setStatus(200);
                break;
            case "Login":
                String[] loginfo =JSONSplitter.jsonSplitter(jsonText);
                System.out.println("DEBUG A");
                People lcustomer = PeopleService.getPersonByUsername(loginfo[1]);
                System.out.println("DEBUG B");
                lcustomer.getAccess_level(); // TODO: send this back in JSON

                // TODO: write response logic.. such as "Welcome Mr. Park".. send to portal based on accessLevel
                resp.getWriter().write(lcustomer.getAccess_level());
                System.out.println("DEBUG D");
                resp.setStatus(200);
                System.out.println("DEBUG E");

                break;
        }

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    }

}