package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

//Generate Test for CustomerService
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(org.springframework.test.context.junit.jupiter.SpringExtension.class)
@DisplayName("Test CustomerService")
@SpringBootTest
// Implement unit test for CustomerService and mock CustomerRepository
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

    // Generate unit test for CustomerService with @Autowired CustomerService customerService.
    // I want to a unit test for the method saveCustomer.
    // Create a customer object and set the id and name.
    // Mock the CustomerRepository with doReturn and when.
    // I want to validate the customer object is saved and the id and name are correct.
    @Test
    @Order(1)
    public void saveCustomer() {
    Customer customer = new Customer();

        customer.setId(100l);
        customer.setName("Sebastian");

        doReturn(customer).when(customerRepository).save(customer);

        Customer savedCustomer = customerService.saveCustomer(customer);

        Assertions.assertNotNull(savedCustomer);
        Assertions.assertEquals(100l, savedCustomer.getId());
        Assertions.assertEquals("Sebastian", savedCustomer.getName());

    }


    // Generate unit test for CustomerService with @Autowired CustomerService customerService.
    // I want to a unit test for the method getCustomers.
    // Create a customer object and set the id and name.
    // I want to validate the customer object is saved and the id and name are correct.
    @Test
    @Order(2)
    public void getCustomers() {
        Customer customer = new Customer();
        customer.setId(100l);
        customer.setName("Sebastian");

        Customer customer2 = new Customer();
        customer2.setId(200l);
        customer2.setName("Pepe");

        doReturn(Arrays.asList(customer , customer2)).when(customerRepository).findAll();

        List<Customer> customers = customerService.getCustomers();

        Assertions.assertNotNull(customers);
        Assertions.assertEquals(2, customers.size());
        Assertions.assertEquals(customer, customers.get(0));
    }

    // Generate unit test for CustomerService with @Autowired CustomerService customerService.
    // I want to a unit test for the method getCustomer.
    // Create a customer object and set the id and name.
    // I want to validate the customer object is saved and the id and name are correct.
    @Test
    @Order(3)
    public void getCustomer() {

        Customer customer = new Customer();
        customer.setId(100l);
        customer.setName("Sebastian");

        doReturn(java.util.Optional.of(customer)).when(customerRepository).findById(100l);

        Optional<Customer> customer2 = customerService.getCustomer(100l);

        Assertions.assertTrue(customer2.isPresent());
        Assertions.assertSame(customer, customer2.get());

    }

    // I want to a unit test for the method updateCustomer.
    // Create a customer object and set the id and name.
    // I want to validate the customer object is saved and the id and name are correct.
    @Test
    @Order(4)
    public void updateCustomer() {

        Customer customer = new Customer();
        customer.setId(100l);
        customer.setName("Pepe");

        doReturn(customer).when(customerRepository).save(customer);

        Customer customer2 = customerService.updateCustomer(customer);

        Assertions.assertNotNull(customer2);
        Assertions.assertEquals(100l, customer2.getId());
        Assertions.assertEquals("Pepe", customer2.getName());

    }

    // Delete unit test for CustomerService with @Autowired CustomerService customerService.
    // I want to a unit test for the method deleteCustomer.
    // Create a customer object and set the id and name.
    // I want to validate the customer object is saved and the id and name are correct.
    // Mock customerRepository.delete(customer) with doNothing.
    // Mock findById
    // I want to validate the customer object is deleted.
    @Test
    @Order(5)
    public void deleteCustomer() {

        Customer customer = new Customer();
        customer.setId(100l);
        customer.setName("Pepe");

        doNothing().when(customerRepository).delete(customer);
        doReturn(java.util.Optional.of(customer)).when(customerRepository).findById(100l);

        boolean deleted = customerService.deleteCustomer(100l);

        Assertions.assertTrue(deleted);

    }




}