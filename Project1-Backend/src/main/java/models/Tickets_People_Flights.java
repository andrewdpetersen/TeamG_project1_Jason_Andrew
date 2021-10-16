package models;

import javax.persistence.*;

/**
 * This class is a model for resources in our tickets_people_flights table.
 * It has 3 private fields, a constructor, and Getters and Setters. It is an example of
 * encapsulation, and it helps us abstract by obscuring the functionality inside the class.
 */
@Entity
@Table(name = "tickets")
public class Tickets_People_Flights {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticket_id;

    @Column
    @ManyToOne
    @JoinColumn(name = "people_id")
    private People person;

    @Column
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flights flight;

    public Tickets_People_Flights() {
    }

    public int getTicket_id() {
        return ticket_id;
    }
    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }
    public People getPerson() {return person;}
    public void setPerson(People person) {this.person = person;}
    public Flights getFlight() {return flight;}
    public void setFlight(Flights flight) {this.flight = flight;}
}
