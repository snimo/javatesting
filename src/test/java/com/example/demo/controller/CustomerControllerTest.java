package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(org.springframework.test.context.junit.jupiter.SpringExtension.class)
@DisplayName("Test CustomerController")
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    // Generate unit test for CustomerController with @MockBean CustomerService and @Autowired MockMvc mvc.
    // I want to a unit test for the method saveCustomer.
    // Convert customer object to json string using new ObjectMapper().
    // I want to validate response status is 200 and all the attributes of the customer object
    @Test
    public void saveCustomer() throws Exception {
            Customer customer = new Customer();
            customer.setId(100l);
            customer.setName("Sebastian");

            doReturn(customer).when(customerService).saveCustomer(any());

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(customer);

            mvc.perform(MockMvcRequestBuilders.post("/api/customer")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonString))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id").value(100))
                    .andExpect(jsonPath("$.name").value("Sebastian"));
    }

    //Modify the saveCustomer method to return a ResponseEntity
    @Test
    public void modifyCustomer() throws Exception {

        Customer customer = new Customer();
        customer.setId(100l);
        customer.setName("Sebastian");

        doReturn(customer).when(customerService).updateCustomer(customer);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(customer);

        mvc.perform(MockMvcRequestBuilders.put("/api/customer/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(100))
                .andExpect(jsonPath("$.name").value("Sebastian"));

    }

    //Delete the customer object using DELETE method by Id and validate the response status is 200
    @Test
    public void deleteCustomerOk() throws Exception {

        doReturn(true).when(customerService).deleteCustomer(any());

        mvc.perform(MockMvcRequestBuilders.delete("/api/customer/delete/3"))
                .andExpect(status().isOk()).andExpect(content().string("true"));


    }




    @Test
    public void deleteCustomerNotFound() throws Exception {



        doReturn(false).when(customerService).deleteCustomer(any());

        mvc.perform(MockMvcRequestBuilders.delete("/api/customer/delete/3"))
                .andExpect(status().isNotFound());




    }

    // Get the customer object using GET method by Id and validate the response status is 200
    @Test
    @DisplayName("GET Customer with id 100 - /api/customer/get/100")
    public void getCustomer() throws Exception {

        Customer customer = new Customer();
        customer.setId(100l);
        customer.setName("Sebastian");

        doReturn(Optional.of(customer)).when(customerService).getCustomer(customer.getId());

        mvc.perform(MockMvcRequestBuilders.get("/api/customer/get/100"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(100))
                .andExpect(jsonPath("$.name").value("Sebastian"));

    }

    // Implement unit test mocking method List<Customer> getCustomers();
    @Test
    public void getCustomers() throws Exception {

        Customer customer1 = new Customer();
        customer1.setId(100l);
        customer1.setName("Sebastian");

        Customer customer2 = new Customer();
        customer2.setId(200l);
        customer2.setName("Pepe");

        List<Customer> customerList = Arrays.asList(customer1, customer2);

        doReturn(customerList).when(customerService).getCustomers();

        // check if the response contains two elements
        mvc.perform(MockMvcRequestBuilders.get("/api/customer/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$[0].id").value(100))
                .andExpect(jsonPath("$[0].name").value("Sebastian"))
                .andExpect(jsonPath("$[1].id").value(200))
                .andExpect(jsonPath("$[1].name").value("Pepe"));
    }













}