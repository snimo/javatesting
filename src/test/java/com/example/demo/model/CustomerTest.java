package com.example.demo.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CustomerTest {

    @BeforeAll
    static void initialize() {
        System.out.println("Initializing...");
    }

    @Test
    @DisplayName("Test Customer")
    public void testCustomer() {
        Customer customer = new Customer();
        customer.setId(100l);
        customer.setName("Sebastian");

        System.out.println(customer.getId());
        System.out.println(customer.getName());

        assertEquals(100l, customer.getId());
        assertEquals("Sebastian", customer.getName());
    }
}