package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Objects;

// Create a RestController in Spring Boot to create a RESTful web service
@RestController
@RequestMapping("/api")
public class CustomerController {

    // Import Service to perform business logic

    @Autowired
    private CustomerService customerService;


    // Create a method to save a customer using POST method and RequestBody
    // annotation to map the request body to a domain object
    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {

        try {
            Customer savedCustomer = customerService.saveCustomer(customer);
            return Objects.isNull(savedCustomer) ? ResponseEntity.internalServerError().build() : ResponseEntity.created(new URI("/customer/"+customer.getId())).body(savedCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    //Modify the saveCustomer method to return a ResponseEntity
    @PutMapping("/customer/update")
    public ResponseEntity<Customer> modifyCustomer(@RequestBody Customer customer) {
        try {
            Customer modifiedCustomer = customerService.updateCustomer(customer);
            if (Objects.isNull(modifiedCustomer)) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(modifiedCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/customer/delete/{id}")
    public ResponseEntity<?> saveCustomer(@PathVariable Long id) {
        try {
            return customerService.deleteCustomer(id) ? ResponseEntity.ok(true) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // Get a customer by id using GET method and PathVariable annotation to map
    // the request parameter to a method parameter
    @GetMapping("/customer/get/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Long id) {
        return customerService.getCustomer(id).
                map(customer -> {
                    try {
                        return ResponseEntity.ok().body(customer);
                    } catch (Exception e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                    }
                }).orElse(ResponseEntity.notFound().build());
    }

    // Get All Products
    @GetMapping("/customer/getAll")
    public ResponseEntity<List<Customer>> getCustomers() {
        try {
            return ResponseEntity.ok(customerService.getCustomers());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }







}

