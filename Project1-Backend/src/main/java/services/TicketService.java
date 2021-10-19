package services;

import models.Tickets_People_Flights;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TicketService {
    // we want 2 private fields Session factory, session
    private static SessionFactory sfact;  // so we can get the session
    private static Session sess; // We will use this to update the database


    //User - buy a TICKET or multiple tickets
    public static void buyNewTicket (Tickets_People_Flights tpf){
        // if(locked=false) then proceed... going to implement before hibernate... a validator somewhere
        sess.save(tpf);}  // Use the session to save the Object tpf into database

    //User - buy MULTIPLE tickets
    public static void buyMultiTicket(List<Tickets_People_Flights> tpf) {
        //hardest due to calling multiple hibernate methods??
        //iterate over the List of tickets and save each one to the database
    }

    //User - CANCEL a ticket // Admin will also use
    public static void cancelTicket (Tickets_People_Flights tpf){sess.delete(tpf);} // Use the session to delete the Object tpf from database



    // User - LOOKUP a ticket
    //public static Tickets_People_Flights lookUpTicket (int ticket_id){
        //get tickets_people_flights
        //sess.get(Tickets_People_Flights,ticket_id);
        //return Tickets_People_Flights;
    //}

    // Pilot - LOCK ability TODO lookup how lock works
    public static void lockoutCancel (int flight_id){
        //sess.lock(flight_id); // lock the ability to cancel flight for Users and Admin or BuyNewTickets
    }
}
