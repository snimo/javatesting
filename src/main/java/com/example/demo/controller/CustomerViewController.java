package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Objects;

// Create a RestController in Spring Boot to create a RESTful web service
@Controller
@RequestMapping("/view")
public class CustomerViewController {

   @GetMapping("/hello")
   public String printHello() {
      return "redirect:http://localhost:8085/api/customer/getAll";
   }


}

