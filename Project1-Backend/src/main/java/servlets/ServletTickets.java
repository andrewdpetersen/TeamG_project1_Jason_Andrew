package servlets;

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

        /**
         * The following is just testing my javascript to make sure it is working
         * like I think it is...
         */
        System.out.println("DEBUG-TICKETS SERVER REACHED");
        InputStream requestBody = req.getInputStream();

        //The next line gives us the number of tickets purchased as a String
        String numberPurchased = req.getHeader("number");

        //The next two lines instantiate a scanner in the request body and get put all the
        //JSON there in a string
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        System.out.println("DEBUG FlightID- JSON Text: " + jsonText);

        //Write logic to add ticket(s) to DB here

        //write logic to delete a ticket here

        //write logic to delete all tickets for a given flight here
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //write logic to get all tickets for a given flight here
        //write logic to get all tickets for a given user here
    }

}
