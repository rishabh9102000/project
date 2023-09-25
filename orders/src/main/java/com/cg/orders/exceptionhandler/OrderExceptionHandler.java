package com.cg.orders.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.orders.exceptions.IdNotFoundException;
import com.cg.orders.exceptions.IngredientFinishedException;



@ControllerAdvice
public class OrderExceptionHandler {

	 @ExceptionHandler(IngredientFinishedException.class)
	    public ResponseEntity<String> handleIngredientFinishedException(IngredientFinishedException except){
	        return new ResponseEntity<String>(except.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 @ExceptionHandler(IdNotFoundException.class)
	    public ResponseEntity<String> handleIdNotFoundException(IdNotFoundException except){
	        return new ResponseEntity<String>(except.getMessage(), HttpStatus.NOT_FOUND);
	    }
}
