import java.util.Scanner;

public class UserApp {
    private static UserManager userManager = new UserManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> userManager.loginAsAdmin(scanner);
                case 2 -> userManager.registerAsAdmin(scanner);
                case 3 -> userManager.loginAsPassenger(scanner);
                case 4 -> userManager.registerAsPassenger(scanner);
                case 5 -> displayUserManual();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Login as Admin");
        System.out.println("2. Register as Admin");
        System.out.println("3. Login as Passenger");
        System.out.println("4. Register as Passenger");
        System.out.println("5. View User Manual");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void displayUserManual() {
        System.out.println("\n--- User Manual ---");
        System.out.println("1. Admins manage customers and view passenger details.");
        System.out.println("2. Passengers can book, view, and cancel flights.");
        System.out.println("3. Admin registration is required before login.");
    }
}
