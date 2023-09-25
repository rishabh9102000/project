package com.cg.atm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.atm.models.Account;

@Repository
public interface AtmRepo extends JpaRepository<Account,Integer> {

}
