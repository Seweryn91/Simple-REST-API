package service;

import model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerService {

    private static Map<Integer, Customer> customersMap = new HashMap<>();
    private static Integer id = 0;

    private void fillCustomersList() {
        List<Customer> customers = new ArrayList<>();
        Customer customer1 = new Customer("Jon Doe", "Nowhere", "Zero Ave. 1/1", "00-000");
        Customer customer2 = new Customer("Jane Doe", "Somewhere", "One Ave. 1/2", "00-001");
        Customer customer3 = new Customer("Tommy Vercetti", "Vice City", "Vercetti Estate 1, Starfish Island", "66-966");
        Customer customer4 = new Customer("Cersei Lannister", "Kings Landing", "Red Keep 1", "00-001");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);

        for (Customer c : customers) {
            customersMap.put(id, c);
            id++;
        }
    }


    @GetMapping(value = "/customers")
    public Map<Integer, Customer> getCustomers() {
        if (customersMap.isEmpty()) fillCustomersList();
        return customersMap;
    }

    @GetMapping(value = "/customers/{id}")
    public Customer handleGet(@PathVariable int id) {
        return getCustomerById(id);
    }

    @DeleteMapping(value = "/customers/{id}")
    public void handleDelete(@PathVariable int id) {
        deleteCustomer(id);
    }

    private void deleteCustomer(int id) {
        customersMap.remove(id);
    }

    //TODO: Implement posting new customer
    @PostMapping(value = "/customers")
    public void createCustomer(@RequestParam("name") String name,
                               @RequestParam("city") String city,
                               @RequestParam("street") String street,
                               @RequestParam("zipCode") String zipCode) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCity(city);
        customer.setStreet(street);
        customer.setZipCode(zipCode);
        addCustomer(customer);
    }

    private void addCustomer(Customer c) {
        customersMap.put(id+1, c);
    }

    private Customer getCustomerById(int id) {
        return customersMap.get(id);
    }

}