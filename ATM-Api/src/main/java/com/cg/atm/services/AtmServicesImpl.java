package com.cg.atm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.atm.exceptions.IdNotFoundException;
import com.cg.atm.exceptions.InvalidPinException;
import com.cg.atm.exceptions.MinBalanceException;
import com.cg.atm.models.Account;
import com.cg.atm.repo.AtmRepo;

@Component
public class AtmServicesImpl implements AtmServices {
	@Autowired AtmRepo repo;
	@Autowired CustomerServices service;
	
	@Override
	public Account createAccount(Account account) {
	
		return repo.save(account);
	}

	@Override
	public Account debitAccount(int accountId,int pin, int amount) throws IdNotFoundException, MinBalanceException, InvalidPinException {
		
		Account acc = repo.findById(accountId).orElseThrow(()->  new IdNotFoundException("Id not fount : "+ accountId));
		if(!service.authenticateUser(acc.getCustomerId(), pin)) {throw new InvalidPinException("Enter Correct Pin");}
		if(acc.getBalance()<amount) { throw new MinBalanceException("amount greater than balance");}
		acc.setBalance(acc.getBalance()-amount);
		return repo.save(acc);
	}

	@Override
	public Account creditAccount(int accountId,int pin, int amount) throws IdNotFoundException, InvalidPinException {
		Account acc = repo.findById(accountId).orElseThrow(()->  new IdNotFoundException("Id not fount : "+ accountId));
		if(!service.authenticateUser(acc.getCustomerId(), pin)) {throw new InvalidPinException("Enter Correct Pin");}
		acc.setBalance(acc.getBalance()+amount);
		return repo.save(acc);
	}

	@Override
	public int showBalance(int accountId) throws IdNotFoundException {
		Account acc = repo.findById(accountId).orElseThrow(()->  new IdNotFoundException("Id not fount : "+ accountId));
		return acc.getBalance();
		
		
	}

}
