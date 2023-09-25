package com.cg.atm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.cg.atm.models.Customer;



@RestController
public interface customerRepo extends JpaRepository<Customer,Integer> {

}
