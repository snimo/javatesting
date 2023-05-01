package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    // Create a method to save a customer
    Customer saveCustomer(Customer customer);

    // Create a method to get all customers
    List<Customer> getCustomers();

    // Create a method to get a customer
    Optional<Customer> getCustomer(Long id);

    // Create a method to update a customer
    Customer updateCustomer(Customer customer);

    // Create a method to delete a customer
    boolean deleteCustomer(Long id);

    List<Customer> getCustomerWithLongNames();
}
