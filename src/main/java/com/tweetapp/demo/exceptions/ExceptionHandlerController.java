package com.tweetapp.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@ControllerAdvice
public class ExceptionHandlerController  {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFound(ResourceNotFoundException ex,HttpServletRequest request) {
        Error error = new Error(HttpStatus.NOT_FOUND.value(),ex.getMessage(),request.getPathInfo(),new Date().getTime());
        return new ResponseEntity<>(error, null, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ParametersMismatchException.class)
    public ResponseEntity<Object> parameterMismatch(ParametersMismatchException ex,HttpServletRequest request) {
        Error error = new Error(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),request.getServletPath(),new Date().getTime());
        return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyFoundException.class)
    public ResponseEntity<Object> UserAlreadyFound(UserAlreadyFoundException ex,HttpServletRequest request) {
        Error error = new Error(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),request.getServletPath(),new Date().getTime());
        return new ResponseEntity<>(error, null, HttpStatus.BAD_REQUEST);
    }

}
