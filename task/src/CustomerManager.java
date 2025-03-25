import java.util.*;

public class CustomerManager {
    private List<Customer> customers = new ArrayList<>();

    public void addNewCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean isCustomerAlreadyAdded(Customer customer) {
        return customers.stream().anyMatch(c -> c.getUserID().equals(customer.getUserID()));
    }
}
