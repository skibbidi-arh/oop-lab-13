import java.util.*;

public class CustomerManager {
 List<Customer> customers = new ArrayList<>();
  CustomerRegistration crg = new CustomerRegistration(customers);
CustomerManager(){

}

public void addNewCustomer(Customer customer) {
    customers.add(customer);
}

public boolean isCustomerAlreadyAdded(Customer customer) {
    return customers.stream().anyMatch(c -> c.getUserID().equals(customer.getUserID()));
}
}

