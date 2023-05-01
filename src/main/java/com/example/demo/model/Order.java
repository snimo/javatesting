package com.example.demo.model;

import java.util.List;

//Order customer has made with date, total price, customer, address, and list of products
public class Order {
    private Long id;
    private String date;
    private Double totalPrice;
    private Customer customer;
    private List<Product> products;

    public Order() {
    }

    public Order(Long id, String date, Double totalPrice, Customer customer, List<Product> products) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.products = products;
    }

    public Order(String date, Double totalPrice, Customer customer, List<Product> products) {
        this.date = date;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.products = products;
    }

    public Order(String date, Double totalPrice, Customer customer) {
        this.date = date;
        this.totalPrice = totalPrice;
        this.customer = customer;
    }


    public Order(String date, Double totalPrice) {
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public Order(String date) {
        this.date = date;
    }

    public Order(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order(Customer customer) {
        this.customer = customer;
    }


    public Order(List<Product> products) {
        this.products = products;
    }

    public Order(Long id) {
        this.id = id;
    }

    public Order(Long id, String date) {
        this.id = id;
        this.date = date;
    }

    public Order(Long id, Double totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public Order(Long id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }


    public Order(Long id, List<Product> products) {
        this.id = id;
        this.products = products;
    }

    public Order(String date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }
}
