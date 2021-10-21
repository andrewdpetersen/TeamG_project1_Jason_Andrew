package services;

import models.Flights;
import models.People;
import models.Tickets_People_Flights;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManagement {
    private Session session;

    public Session getSession() {
        if(session==null){
            Configuration config = new Configuration();
            config.addAnnotatedClass(Flights.class);
            config.addAnnotatedClass(People.class);
            config.addAnnotatedClass(Tickets_People_Flights.class);

            SessionFactory factory = config.buildSessionFactory();

            FlightService.setSessionFactory(factory);
            PeopleService.setSessionFactory(factory);
            TicketService.setSessionFactory(factory);

            FlightService.setSession(factory.openSession());
            PeopleService.setSession(factory.openSession());
            TicketService.setSession(factory.openSession());
        }
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
