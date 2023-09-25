package com.cg.atm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.atm.exceptions.IdNotFoundException;
import com.cg.atm.exceptions.InvalidPinException;
import com.cg.atm.models.Customer;
import com.cg.atm.repo.customerRepo;

@Component
public class CustomerServiceImpl implements CustomerServices {
	@Autowired customerRepo repo;
	@Override
	public Customer createCustomer(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public Customer updatePin(int customerId,int oldPin, int newPin) throws IdNotFoundException, InvalidPinException {
		if(!authenticateUser(customerId,oldPin)) {throw new InvalidPinException("Enter Correct Pin");}
		Customer customer  = repo.findById(customerId).orElseThrow(()-> new IdNotFoundException("Id not found" + customerId));
		customer.setPin(newPin);
		return repo.save(customer);
	}

	@Override
	public Customer getDetails(int customerId) throws IdNotFoundException {
		return repo.findById(customerId).orElseThrow(()-> new IdNotFoundException("Id not found" + customerId));
	}
	@Override
	public boolean authenticateUser(int customerId, int enteredPin) {
        Integer storedPin= repo.findById(customerId).get().getPin();
        return storedPin != null && storedPin.equals(enteredPin);
    }
	
}
