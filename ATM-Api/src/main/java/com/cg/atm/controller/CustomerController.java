package com.cg.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.atm.exceptions.IdNotFoundException;
import com.cg.atm.exceptions.InvalidPinException;
import com.cg.atm.models.Customer;
import com.cg.atm.services.CustomerServices;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
public class CustomerController {
	@Autowired CustomerServices services;
	
	@PostMapping(value = "/customers", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer){
		return new ResponseEntity<Customer>(services.createCustomer(customer),HttpStatus.CREATED);
	}
	@GetMapping(value = "/customers/{customerId}")
	public ResponseEntity<Customer> getDetails(@PathVariable int customerId) throws IdNotFoundException{
		return new ResponseEntity<Customer>(services.getDetails(customerId),HttpStatus.OK);
	}
	@PutMapping(value = "/customers/{customerId}/{oldPin}/{pin}")
	public ResponseEntity<Customer> updatePin(@PathVariable int customerId,@PathVariable int oldPin,@Valid @PathVariable  Integer pin) throws IdNotFoundException, InvalidPinException{
		return new ResponseEntity<Customer>(services.updatePin(customerId,oldPin, pin),HttpStatus.OK);
	}
}
