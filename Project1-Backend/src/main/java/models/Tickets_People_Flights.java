package models;

/**
 * This class is a model for resources in our tickets_people_flights table.
 * It has 3 private fields, a constructor, and Getters and Setters. It is an example of
 * encapsulation, and it helps us abstract by obscuring the functionality inside the class.
 */
public class Tickets_People_Flights {
    private int ticket_id;
    private int people_id;
    private int flight_id;

    public Tickets_People_Flights() {
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getPeople_id() {
        return people_id;
    }

    public void setPeople_id(int people_id) {
        this.people_id = people_id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }
}
