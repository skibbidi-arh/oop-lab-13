import java.util.List;

class FlightReservation {
    private final List<Flight> flights;

    public FlightReservation(List<Flight> flights) {
        this.flights = flights;
    }

    public void bookFlight(String flightNumber, int numTickets, Customer customer) {
        Flight flight = findFlight(flightNumber);
        if (flight != null && flight.getAvailableSeats() >= numTickets) {
            flight.removeSeats(numTickets);
            flight.registerCustomer(customer);
            System.out.printf("Booked %d tickets for Flight %s\n", numTickets, flightNumber);
        } else {
            System.out.println("Flight not found or insufficient seats.");
        }
    }

    public void cancelFlight(String flightNumber, int numTickets, Customer customer) {
        Flight flight = findFlight(flightNumber);
        if (flight != null) {
            flight.addSeats(numTickets);
            System.out.printf("Canceled %d tickets for Flight %s\n", numTickets, flightNumber);
        } else {
            System.out.println("Flight not found.");
        }
    }

    private Flight findFlight(String flightNumber) {
        return flights.stream().filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber)).findFirst().orElse(null);
    }
}
