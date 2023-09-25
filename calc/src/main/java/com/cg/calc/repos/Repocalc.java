package com.cg.calc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.calc.pojos.User;

@Repository
public interface Repocalc extends JpaRepository<User,Integer> {

}
