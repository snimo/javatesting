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

// Ver que se usa en controller - y no un rest-controller
@Controller
@RequestMapping("/view")
public class CustomerViewController {

   // Redirigir a otra pagina
   @GetMapping("/hello")
   public String printHello() {
      return "redirect:http://localhost:8085/api/customer/getAll";
   }

   // Devolver el cuerpo del HTML pata que sea renderizado en la pagina
   @RequestMapping(value = "/prueba1", method = RequestMethod.GET)
   public @ResponseBody String responseBody() {
      return "<h1>prueba1</h1>";
   }

   @GetMapping("/error500")
   public void error500() {
      double a = 1 / 0;
      System.out.println(a);
   }


}

