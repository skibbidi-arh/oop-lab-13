import java.util.Scanner;

public class UserManager {
    private RolesAndPermissions authService = new RolesAndPermissions();
    private FlightReservation flightReservation = new FlightReservation(User.getFlights());
    private CustomerManager customerManager = new CustomerManager();
    private CustomerRegistration customerRegistration = new CustomerRegistration(User.getCustomersCollection());

    public void loginAsAdmin(Scanner scanner) {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (authService.isPrivilegedUser(username, password)) {
            System.out.println("Admin login successful!");
            adminMenu(scanner);
        } else {
            System.out.println("Invalid credentials! Please try again.");
        }
    }

    public void registerAsAdmin(Scanner scanner) {
        System.out.print("Enter new Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new Password: ");
        String password = scanner.nextLine();

        if (authService.registerAdmin(username, password)) {
            System.out.println("Admin registered successfully!");
        } else {
            System.out.println("Admin username already exists!");
        }
    }

    public void loginAsPassenger(Scanner scanner) {
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        String userID = authService.isPassengerRegistered(email, password);
        if (userID != null) {
            System.out.println("Passenger login successful!");
            passengerMenu(scanner, userID);
        } else {
            System.out.println("Invalid credentials! Please try again.");
        }
    }

    public void registerAsPassenger(Scanner scanner) {
        customerRegistration.addNewCustomer();
    }

    private void adminMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. Search Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. View All Customers");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> customerManager.crg.addNewCustomer();
                case 2 -> customerManager.crg.searchCustomer();
                case 3 -> customerManager.crg.updateCustomer();
                case 4 -> customerManager.crg.deleteCustomer();
                case 5 -> customerManager.crg.displayAllCustomers();
                case 6 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private void passengerMenu(Scanner scanner, String userID) {
        int choice;
        do {
            System.out.println("\n--- Passenger Menu ---");
            System.out.println("1. Book a Flight");
            System.out.println("2. View My Flights");
            System.out.println("3. Cancel Flight");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> flightReservation.bookFlight(scanner, userID);
                case 2 -> flightReservation.displayFlightsByUser(userID);
                case 3 -> flightReservation.cancelFlight(userID);
                case 4 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}
