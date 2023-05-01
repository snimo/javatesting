package com.example.demo.service.implementation;

// Create a Service in Spring Boot to perform business logic
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    // Import Repository to perform CRUD operations
    @Autowired
    private CustomerRepository customerRepository;

    // Create a method to save a customer
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Create a method to get all customers
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    // Create a method to get a customer
    @Override
    public Optional<Customer> getCustomer(Long id) {
        return customerRepository.findById(id);
    }

    // Create a method to update a customer
    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // Create a method to delete a customer
    @Override
    public boolean deleteCustomer(Long id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isEmpty()) {
            return false;
        }
        customerRepository.delete(customerOptional.get());
        return true;
    }

    @Override
    public List<Customer> getCustomerWithLongNames() {
        return customerRepository.findAll().stream().
                filter(customer -> customer.getName().length() > 5).collect(Collectors.toList());
    }

}
