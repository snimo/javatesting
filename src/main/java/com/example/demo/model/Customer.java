package com.example.demo.model;


import javax.persistence.*;
import java.util.Objects;


// Create class Customer with Entity Annotation to create a table in the database with id and name columns


@Entity
@Table(name = "customer")
public class Customer {

    // Create a sequence to use for the primary key
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    // Use the sequence to generate the primary key
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )

   
    // Create id and name columns
    @Column(
            name = "id",
            updatable = false
    )
    // Create id and name columns
    private Long id;

    @Column(nullable = false)
    private String name;

    // Generate Getters and Setters in Spring Boot
    public Long getId() {
        return id;
    }

    // Generate Getters and Setters in Spring Boot
    public void setId(Long id) {
        this.id = id;
    }

    // Generate Getters and Setters in Spring Boot
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // Generate Getters and Setters in Spring Boot
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


