
import java.util.*;

class Customer implements ICustomer {
     final String userID;
     String email;
     String name;
     String phone;
     final String password;
     String address;
     int age;
     List<Flight> flightsRegisteredByUser;
     List<Integer> numOfTicketsBookedByUser;

    // Constructor
    public Customer(String name, String email, String password, String phone, String address, int age) {
        this.userID = UUID.randomUUID().toString(); // Unique ID generation using UUID
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.flightsRegisteredByUser = new ArrayList<>();
        this.numOfTicketsBookedByUser = new ArrayList<>();
    }

    @Override
    public void addNewCustomer() {
        new CustomerRegistration(User.getCustomersCollection()).addNewCustomer();
    }

    @Override
    public void editUserInfo(String ID) {
        // Handle editing logic
    }

    @Override
    public void deleteUser(String ID) {
        // Handle deletion logic
    }

    @Override
    public void displayCustomersData() {
        // Display customer data logic
    }

    // Getters and setters
    public String getUserID() { return userID; }
    public String getEmail() { return email; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public int getAge() { return age; }
    public List<Flight> getFlightsRegisteredByUser() { return flightsRegisteredByUser; }
    public List<Integer> getNumOfTicketsBookedByUser() { return numOfTicketsBookedByUser; }
}