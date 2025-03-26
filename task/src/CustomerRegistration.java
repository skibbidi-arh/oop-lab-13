import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class CustomerRegistration {
    private final List<Customer> customerCollection;

    public CustomerRegistration(List<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public boolean isUniqueData(String emailID) {
        return customerCollection.stream().anyMatch(c -> c.email.equals(emailID));
    }

    public void addNewCustomer() {
        Scanner read = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = read.nextLine();

        String email;
        do {
            System.out.print("Enter your email address: ");
            email = read.nextLine();
            if (isUniqueData(email)) {
                System.out.println("ERROR!!! Email already exists...");
            }
        } while (isUniqueData(email));

        System.out.print("Enter your password: ");
        String password = read.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = read.nextLine();
        System.out.print("Enter your address: ");
        String address = read.nextLine();
        System.out.print("Enter your age: ");
        int age = read.nextInt();
        read.nextLine(); // Consume newline

        customerCollection.add(new Customer(name, email, password, phone, address, age));
        System.out.println("Customer registered successfully!");
    }

    public void searchCustomer() {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter the email of the customer to search: ");
        String email = read.nextLine();

        for (Customer c : customerCollection) {
            if (c.email.equalsIgnoreCase(email)) {
                System.out.println("Customer found: " + c.name + " (Email: " + c.email + ")");
                return;
            }
        }
        System.out.println("No customer found with email: " + email);
    }

    public void updateCustomer() {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter the email of the customer to update: ");
        String email = read.nextLine();

        for (Customer c : customerCollection) {
            if (c.email.equalsIgnoreCase(email)) {
                System.out.println("Updating details for: " + c.name);

                System.out.print("Enter new phone number: ");
                c.phone = read.nextLine();

                System.out.print("Enter new address: ");
                c.address = read.nextLine();

                System.out.print("Enter new age: ");
                c.age = read.nextInt();
                read.nextLine(); // Consume newline

                System.out.println("Customer details updated successfully!");
                return;
            }
        }
        System.out.println("No customer found with email: " + email);
    }

    public void deleteCustomer() {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter the email of the customer to delete: ");
        String email = read.nextLine();

        for (Customer c : customerCollection) {
            if (c.email.equalsIgnoreCase(email)) {
                customerCollection.remove(c);
                System.out.println("Customer deleted successfully!");
                return;
            }
        }
        System.out.println("No customer found with email: " + email);
    }

    public void displayAllCustomers() {
        if (customerCollection.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }
        System.out.println("\n--- Registered Customers ---");
        for (Customer c : customerCollection) {
            System.out.println("Name: " + c.name + " | Email: " + c.email);
        }
    }
}
