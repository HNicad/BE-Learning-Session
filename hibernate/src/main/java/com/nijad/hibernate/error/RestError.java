package com.nijad.hibernate.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class RestError {
    @ExceptionHandler(EmployeeNotFound.class)
    protected ResponseEntity<Object> handleEmployeeNotFound(EmployeeNotFound employeeNotFound){
        ErrorMessage errorMessage = new ErrorMessage(employeeNotFound.getMessage(),HttpStatus.NOT_FOUND.value());
        errorMessage.setDate(new Date());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

}
