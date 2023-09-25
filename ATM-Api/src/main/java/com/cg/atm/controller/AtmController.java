package com.cg.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.atm.exceptions.IdNotFoundException;
import com.cg.atm.exceptions.InvalidPinException;
import com.cg.atm.exceptions.MinBalanceException;
import com.cg.atm.models.Account;
import com.cg.atm.services.AtmServices;

import jakarta.validation.Valid;


@RestController
public class AtmController {
	@Autowired private AtmServices services;
	
	@PostMapping(value = "/accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account){
		return new ResponseEntity<Account>(services.createAccount(account),HttpStatus.CREATED);
	}
	@PutMapping(value = "/accounts/debit/{accountId}/{pin}/{amount}")
	public ResponseEntity<Account> debitAccount(@PathVariable  int accountId,@PathVariable int pin,@PathVariable int amount) throws IdNotFoundException, MinBalanceException, InvalidPinException{
		return new ResponseEntity<Account>(services.debitAccount(accountId,pin,amount),HttpStatus.OK);
	}
	@PutMapping(value = "/accounts/credit/{accountId}/{pin}/{amount}")
	public ResponseEntity<Account> creditAccount(@PathVariable  int accountId,@PathVariable int pin,@PathVariable int amount) throws IdNotFoundException, InvalidPinException{
		return new ResponseEntity<Account>(services.creditAccount(accountId,pin,amount),HttpStatus.OK);
	}
	@GetMapping(value ="/accounts/{accountId}")
	public ResponseEntity<Integer> showBalance(@PathVariable  int accountId) throws IdNotFoundException{
		return new ResponseEntity<Integer>(services.showBalance(accountId),HttpStatus.OK);
	}
	
	
}
