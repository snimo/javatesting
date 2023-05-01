package com.example.demo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Create a spring boot unit test for Product Class
public class ProductTest {


    @Test
    public void testProduct() {
        Product product = new Product();
        product.setId(100l);
        product.setCode("P1");
        product.setName("Product 1");
        product.setPrice(100.0);

        Assertions.assertEquals(100l, product.getId());
        Assertions.assertEquals("P1", product.getCode());
        Assertions.assertEquals("Product 1", product.getName());
        Assertions.assertEquals(100.0, product.getPrice());
    }

}
