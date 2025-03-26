import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Flight {
    private final String flightNumber;
    private final String fromCity;
    private final String toCity;
    private final String gate;
    private final String flightSchedule;
    private final double distanceInMiles;
    private final double distanceInKm;
    private final String flightTime;
    private int availableSeats;
    private final List<Customer> registeredCustomers;

    public Flight(String flightSchedule, String flightNumber, int availableSeats, String fromCity, String toCity, double distanceInMiles, double distanceInKm, String gate) {
        this.flightSchedule = flightSchedule;
        this.flightNumber = flightNumber;
        this.availableSeats = availableSeats;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.distanceInMiles = distanceInMiles;
        this.distanceInKm = distanceInKm;
        this.flightTime = calculateFlightTime(distanceInMiles);
        this.gate = gate;
        this.registeredCustomers = new ArrayList<>();
    }

    private String calculateFlightTime(double distance) {
        double speed = 450;
        int hours = (int) (distance / speed);
        int minutes = (int) ((distance / speed - hours) * 60);
        minutes = (minutes / 5) * 5; // Round to nearest 5 minutes
        return String.format("%02d:%02d", hours, minutes);
    }

    public String getArrivalTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy, HH:mm a");
        LocalDateTime departure = LocalDateTime.parse(flightSchedule, formatter);
        String[] timeParts = flightTime.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        return departure.plusHours(hours).plusMinutes(minutes).format(DateTimeFormatter.ofPattern("EE, dd-MM-yyyy HH:mm a"));
    }

    public boolean registerCustomer(Customer customer) {
        if (!registeredCustomers.contains(customer)) {
            registeredCustomers.add(customer);
            return true;
        }
        return false;
    }

    public void addSeats(int numSeats) {
        this.availableSeats += numSeats;
    }

    public void removeSeats(int numSeats) {
        this.availableSeats -= numSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
