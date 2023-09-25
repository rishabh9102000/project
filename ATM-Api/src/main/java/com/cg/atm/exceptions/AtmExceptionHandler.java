package com.cg.atm.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@ControllerAdvice
public class AtmExceptionHandler {
	 @ExceptionHandler(IdNotFoundException.class)
	    public ResponseEntity<String> handleidNotFoundException(IdNotFoundException except){
	        return new ResponseEntity<String>(except.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 @ExceptionHandler(InvalidPinException.class)
	    public ResponseEntity<String> handleInvalidPinException(InvalidPinException except){
	        return new ResponseEntity<String>(except.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	 @ExceptionHandler(MinBalanceException.class)
	    public ResponseEntity<String> handleMinBalanceException(MinBalanceException except){
	        return new ResponseEntity<String>(except.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
	    	 Map<String, String> resp = new HashMap<> () ;
	    	 ex.getBindingResult().getAllErrors().forEach((error) ->{
	    		 System.out.println(error.toString());
		    	 String fieldName = ((FieldError) error).getField();
		    	 String message = error.getDefaultMessage () ;
		    	 resp.put (fieldName, message);
	    	 });
	    	 
	    	 return new ResponseEntity<Map<String, String>>(resp,HttpStatus.BAD_REQUEST);}
}
