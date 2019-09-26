package service;

import model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity handleDelete(@PathVariable int id) {
        if (deleteCustomer(id)) {
            return new ResponseEntity<>("Customer with ID " + id + " was removed.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to remove customer with ID " + id, HttpStatus.BAD_REQUEST);
        }
    }

    private boolean deleteCustomer(int id) {
        int prevSize = customersMap.size();
        customersMap.remove(id);
        int currentSize = customersMap.size();
        return currentSize < prevSize;
    }

    /**This method can be used instead of handlePostHTTP to accept JSON data as input */
    //@PostMapping(value = "/customers")
    //public ResponseEntity<Customer> handlePostJSON(@RequestBody Customer customer) {
    //    addCustomer(customer);
    //    return new ResponseEntity<>(customer, HttpStatus.OK);
    //}

    /**This method uses standard HTTP POST method parameters */
    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> handlePostHTTP(@RequestParam("name") String name, @RequestParam("city") String city,
                                                   @RequestParam("street") String street, @RequestParam("zipcode") String zipcode) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCity(city);
        customer.setStreet(street);
        customer.setZipCode(zipcode);
        addCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    private void addCustomer(Customer c) {
        customersMap.put(id+1, c);
    }

    private Customer getCustomerById(int id) {
        return customersMap.get(id);
    }

}