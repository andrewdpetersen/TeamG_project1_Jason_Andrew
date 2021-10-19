package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import daos.TicketDAO;

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
        InputStream requestBody = req.getInputStream();
        Scanner sc = new Scanner(requestBody, StandardCharsets.UTF_8.name());
        String jsonText = sc.useDelimiter("\\A").next();
        System.out.println("DEBUG - JSON Text: " + jsonText);
        ObjectMapper mapper = new ObjectMapper();
        Integer payload = mapper.readValue(jsonText, Integer.class);

        //write logic to create a ticket here


        //write logic to delete a ticket here

        //write logic to delete all tickets for a given flight here
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        //write logic to get all tickets for a given flight here
    }

}
