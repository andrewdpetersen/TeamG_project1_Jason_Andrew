package services;

import models.Flights;
import models.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class FlightService {
    private static Session session;
    private static SessionFactory sessionFactory;

    /**
     * It is unclear if this initialization method is necessary now that we are
     * using hibernate rather than a direct repo.
     */
    public static void init(){}

    /**
     * This method save a Flights instance to our database.
     * @param flight
     */
    public static void saveNewFlight(Flights flight){
        session.save(flight);
    }

    /**
     * This method fetches a flight from our database with the given flight id.
     * @param flight_id
     * @return
     */
    public static Flights getFlightById(int flight_id){
        return session.get(Flights.class, flight_id);
    }

    /**
     * This method returns a list of all the flights in our database.
     * @return
     */
    public static List<Flights> getAllFlights(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Flights> query = builder.createQuery(Flights.class);
        Root<Flights> root = query.from(Flights.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    /**
     * This method is incomplete... we need to adjust it to limit our search by city.
     * @param departureCity
     * @return
     */
    public static List<Flights> getFlightsByDepartureCity(String departureCity){
        List<Flights> flightsList = new LinkedList<>();
        return flightsList;
    }

    /**
     * This method is incomplete... we need to adjust it to limit our search by city.
     * @param arrivalCity
     * @return
     */
    public static List<Flights> getFlightsByArrivalCity(String arrivalCity){
        List<Flights> flightsList = new LinkedList<>();
        return flightsList;
    }

    /**
     * This method is incomplete... we need to adjust it to limit our search by cities.
     * @param departureCity
     * @param arrivalCity
     * @return
     */
    public static List<Flights> getFlightsByArrivalDestination(String departureCity, String arrivalCity){
        List<Flights> flightsList = new LinkedList<>();
        return flightsList;
    }

    /**
     * This method deletes a Flights instance.
     * @param flight
     */
    public static void deleteFlight(Flights flight){
        session.delete(flight);
    }

    //Maybe more get methods based on needs
}
