package com.cg.products.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ProductExceptionHandler {
	 @ExceptionHandler(IdNotFoundException.class)
	    public ResponseEntity<String> handleidNotFoundException(IdNotFoundException except){
	        return new ResponseEntity<String>(except.getMessage(), HttpStatus.NOT_FOUND);
	    }

}