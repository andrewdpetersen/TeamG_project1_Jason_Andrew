package servlets;

import models.Flights;
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

public class ServletFlights extends HttpServlet {
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
            case "AdminScheduleFlight":

                String[] asflight = JSONSplitter.jsonSplitter(jsonText);

                Flights newflight = new Flights();
                newflight.setDeparture_city(asflight[1]);
                newflight.setArrival_city(asflight[3]);
                newflight.setDate(asflight[5]);
                newflight.setTime(asflight[7]);
                FlightService.saveNewFlight(newflight);

                // TODO: write response logic.. such as "Ticket's purchased: 5, for Chicago to LA"
                break;
            case "AdminCancelFlight":

                String[] acflight = JSONSplitter.jsonSplitter(jsonText);


                Flights acf = FlightService.getFlightById(Integer.parseInt(acflight[1]));
                FlightService.deleteFlight(acf);

                // TODO: write response logic.. such as "Ticket's purchased: 5, for Chicago to LA"
                break;

            case "PilotTakeoffLock":

                String[] ptlock = JSONSplitter.jsonSplitter(jsonText);

                Flights ptl = FlightService.getFlightById(Integer.parseInt(ptlock[1]));
                FlightService.PilotTakeoffLock(ptl); // TODO create method in Services/FlightService

                // TODO: write response logic.. such as "Ticket's purchased: 5, for Chicago to LA"
                break;
        }

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // TODO 2 ACTIONS... AdminFlightManifest, UserViewFlights... no body
        String sa = req.getHeader("Servlet-action");
        switch(sa){
            case "AdminFlightManifest":
                // need flight_id
                FlightService.getFlightById(flight_id); //TODO: send flight_id through header... in AdminPortal/AdminPortalFlightManifest
                
                break;
            case "UserViewFlights":
                // need departure_city and arrival_city

                break;
        }
    }

}