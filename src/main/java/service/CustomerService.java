package service;

import model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerService {

    private List<Customer> customers = new ArrayList<>();

    private void fillCustomersList() {
        Customer customer1 = new Customer(1, "Jon Doe", "Nowhere", "Zero Ave. 1/1", "00-000");
        Customer customer2 = new Customer(2, "Jane Doe", "Somewhere", "One Ave. 1/2", "00-001");
        Customer customer3 = new Customer(3, "Tommy Vercetti", "Vice City", "Vercetti Estate 1, Starfish Island", "66-966");
        Customer customer4 = new Customer(4,"Cersei Lannister", "Kings Landing", "Red Keep 1", "00-001");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
    }


    @RequestMapping(value = "/customers/", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customers;
    }

    @RequestMapping(value = "/customers/import", method = RequestMethod.GET)
    public void importCustomers() {
        if (customers.isEmpty()) fillCustomersList();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer handleGet(@PathVariable int id) {
        return getCustomerById(id);
    }

   // @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
   // public void handleDelete(@PathVariable int id) {
   //     deleteCustomer(id);
   // }

    private void deleteCustomer(int id) {
        for (Customer c : customers) {
            if (c.getId() == id) customers.remove(c);
        }
    }

    private Customer getCustomerById(int id) {
        Customer c = null;
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return c;
    }

}
