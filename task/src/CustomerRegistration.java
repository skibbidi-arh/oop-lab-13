import java.util.List;
import java.util.Scanner;

class CustomerRegistration {
    private final List<Customer> customerCollection;

    public CustomerRegistration(List<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    public boolean isUniqueData(String emailID) {
        return customerCollection.stream().anyMatch(c -> c.getEmail().equals(emailID));
    }

    public void addNewCustomer() {
        Scanner read = new Scanner(System.in);
        String name = getInput("Enter your name : ");
        String email = getInput("Enter your email address : ");
        while (isUniqueData(email)) {
            System.out.println("ERROR!!! Email already exists...");
            email = getInput("Enter your email address : ");
        }
        String password = getInput("Enter your Password : ");
        String phone = getInput("Enter your Phone number : ");
        String address = getInput("Enter your address : ");
        int age = getIntInput("Enter your age : ");
        customerCollection.add(new Customer(name, email, password, phone, address, age));
    }

    private String getInput(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextLine();
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextInt();
    }
}
