package servlets;

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

                //jsonText comes from adminPortalAddFlights.js
                String[] asflight = JSONSplitter.jsonSplitter(jsonText);

                Flights newflight = new Flights();
                newflight.setDeparture_city(asflight[1]);//asflight[1] = departure_city.value
                newflight.setArrival_city(asflight[3]);//asflight[3] = arrival_city.value
                newflight.setDate(asflight[5]);//asflight[5] = flight_date.value
                newflight.setTime(asflight[7]);//asflight[7] = flight_time.value
                FlightService.saveNewFlight(newflight);

                resp.getWriter().println("The flight from: "+asflight[1]+" to: "+asflight[3]+" has been scheduled");
                resp.setStatus(200);
                break;
            case "AdminCancelFlight":

                String[] acflight = JSONSplitter.jsonSplitter(jsonText);


                Flights acf = FlightService.getFlightById(Integer.parseInt(acflight[1]));
                FlightService.deleteFlight(acf);

                resp.getWriter().println("Flight id: "+acflight[1]+" has been cancelled");
                resp.setStatus(200);
                break;

            case "PilotTakeoffLock":

                String[] ptlock = JSONSplitter.jsonSplitter(jsonText);

                Flights ptl = FlightService.getFlightById(Integer.parseInt(ptlock[1]));
                FlightService.PilotTakeoffLock(ptl);

                resp.getWriter().println("Flight id: "+ptlock[1]+" is locked and ready for takeoff");
                resp.setStatus(200);
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
                FlightService.getFlightById(Integer.parseInt(req.getHeader("flightID")));
                PeopleService.getPassengersByFlight(Integer.parseInt(req.getHeader("flightID"))); // might need to change this method... using flights Object
                // TODO respond to client w/ list using JavaScript
                break;
            case "UserViewFlights":
                // need departure_city and arrival_city
                FlightService.getFlightsByArrivalDestination(req.getHeader("selectDepartureCity"), req.getHeader("selectArrivalCity"));
                //TODO: repond to client w/ flight list

                break;
        }
    }

}