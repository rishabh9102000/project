package com.cg.atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.atm.exceptions.IdNotFoundException;
import com.cg.atm.exceptions.MinBalanceException;
import com.cg.atm.models.Account;
import com.cg.atm.repo.AtmRepo;
import com.cg.atm.services.AtmServices;
import com.cg.atm.services.AtmServicesImpl;



@ExtendWith(MockitoExtension.class)
class AtmApiApplicationTests {

	@Mock private AtmRepo repo;
	@InjectMocks private AtmServices  services = new AtmServicesImpl() ;
	 @Test
	    void testShowBalances() throws IdNotFoundException {
	        int accountId = 2;
	        Account account = new Account(2,1000,1);
	       
	        
	        when(repo.findById(accountId)).thenReturn(Optional.of(account));
	        
	        assertEquals(1000,services.showBalance(accountId));
	    }
	 
//	 	@Test
//		void depositTest() throws IdNotFoundException {
//			int accountNo = 10001;
//			Account acc = new Account(10001,1000,2);
//
//	 
//			when(repo.findById(accountNo)).thenReturn(Optional.of(acc));
//			Account i =services.creditAccount(accountNo, 2000);
//			assertEquals(3000,i.getBalance());
//
//	 
//
//		}
	 	@Test
		void depositTestException() throws IdNotFoundException, MinBalanceException {
			int accountNo = 10001;
			Account acc = new Account(100,1000,2);

			when(repo.findById(accountNo)).thenReturn(Optional.empty());

			assertThrows(IdNotFoundException.class, () -> services.creditAccount(1001, 2000));
			

		}

}
