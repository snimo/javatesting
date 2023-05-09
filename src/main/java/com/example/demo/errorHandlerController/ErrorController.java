package com.example.demo.errorHandlerController;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(ArithmeticException.class)
    public String handlerAritmeticError(ArithmeticException arithmeticException) {
        return "Error de aritmetica";
    }

}
