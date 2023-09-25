package com.cg.atm.services;

import com.cg.atm.exceptions.IdNotFoundException;
import com.cg.atm.exceptions.InvalidPinException;
import com.cg.atm.models.Customer;

public interface CustomerServices {
	public Customer createCustomer(Customer customer);
	public Customer updatePin(int customerId,int oldPin,int newPin) throws IdNotFoundException, InvalidPinException;
	public Customer getDetails(int customerId) throws IdNotFoundException;
	public boolean authenticateUser(int customerId, int enteredPin);
	

}
