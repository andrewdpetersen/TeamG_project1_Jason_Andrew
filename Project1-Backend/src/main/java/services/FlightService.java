package services;

import models.Flights;
import models.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class FlightService {
    private static Session session = HibernateManagement.getSession();
    private static SessionFactory sessionFactory = HibernateManagement.getSessionFactory();

    /**
     * It is unclear if this initialization method is necessary now that we are
     * using hibernate rather than a direct repo.
     */
    public static void init(){}

    /**
     * This method save a Flights instance to our database.
     * @param flight - the Flights instance we want to save in our database
     */
    //This doesn't need a unit test
    public static void saveNewFlight(Flights flight){
        session.save(flight);
    }

    /**
     * This method fetches a flight from our database with the given flight id.
     * @param flight_id - the id of the flight that we want to find
     * @return Flights
     */
    //This doesn't need a unit test
    public static Flights getFlightById(int flight_id){
        return session.get(Flights.class, flight_id);
    }

    /**
     * This method returns a list of all the flights in our database.
     * @return List<Flights>
     */
    public static List<Flights> getAllFlights(){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Flights> query = builder.createQuery(Flights.class);
        Root<Flights> root = query.from(Flights.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }

    /**
     * This method returns a list of all the flights with a given departure city.
     * @param departureCity - String, the city all flights in the list are departing from
     * @return List<Flights>
     */
    public static List<Flights> getFlightsByDepartureCity(String departureCity){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Flights> query = builder.createQuery(Flights.class);
        Root<Flights> root = query.from(Flights.class);
        query.select(root).where(builder.equal(root.get("departure_city"),departureCity));
        Query newQuery = session.createQuery(query);
        return newQuery.getResultList();
    }

    /**
     * This method returns a list of all the flights with a given arrival city.
     * @param arrivalCity - String, the city all flights in the list are arriving at
     * @return List<Flights>
     */
    public static List<Flights> getFlightsByArrivalCity(String arrivalCity){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Flights> query = builder.createQuery(Flights.class);
        Root<Flights> root = query.from(Flights.class);
        query.select(root).where(builder.equal(root.get("arrival_city"),arrivalCity));
        Query newQuery = session.createQuery(query);
        return newQuery.getResultList();
    }

    /**
     * This method is incomplete... we need to adjust it to limit our search by cities.
     * @param departureCity - String, the city all flights in the list are departing from
     * @param arrivalCity - String, the city all flights in the list are arriving at
     * @return
     */
    public static List<Flights> getFlightsByArrivalDestination(String departureCity, String arrivalCity){
        List<Flights> flightsList = new LinkedList<>();
        return flightsList;
    }

    /**
     * This method deletes a Flights instance.
     * @param flight - the Flights instance that is being deleted
     */
    //This doesn't need a unit test.
    public static void deleteFlight(Flights flight){
        session.delete(flight);
    }


    //Maybe more get methods based on needs...
    public static void PilotTakeoffLock(Flights flight){
    //TODO: find the flight in the database using hibernate
    //TODO: change flag on flight to LOCKED... persiste' change
    }

    public static Session getSession(){
        return session;
    }
    public static void setSession(Session session) {
        FlightService.session = session;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        FlightService.sessionFactory = sessionFactory;
    }







}
