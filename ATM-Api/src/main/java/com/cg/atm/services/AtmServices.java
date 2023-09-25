package com.cg.atm.services;

import com.cg.atm.exceptions.IdNotFoundException;
import com.cg.atm.exceptions.InvalidPinException;
import com.cg.atm.exceptions.MinBalanceException;
import com.cg.atm.models.Account;

public interface AtmServices {
	public Account createAccount(Account account);
	public Account debitAccount(int accountId,int pin,int amount) throws IdNotFoundException, MinBalanceException, InvalidPinException;
	public Account creditAccount(int accountId,int pin,int amount) throws IdNotFoundException, InvalidPinException;
	public int showBalance(int accountId) throws IdNotFoundException;
	
}
