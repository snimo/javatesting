package com.example.demo.service;

import com.example.demo.model.Customer;
import org.junit.jupiter.api.*;

//Generate Test for CustomerService
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {

    Customer customer = new Customer();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void saveCustomer() {

        customer.setId(100l);
        customer.setName("Sebastian");

        System.out.println(customer.getId());
        System.out.println(customer.getName());

        Assertions.assertEquals(100l, customer.getId());
        Assertions.assertEquals("Sebastian", customer.getName());

    }

    @Test
    @Order(2)
    void getCustomers() {
    }

    @Test
    @Order(3)
    void deleteCustomer() {
    }

    @Test
    @Order(4)
    void getCustomerWithLongNames() {
    }
}