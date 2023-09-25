package com.cg.Admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Admin.models.Theatre;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,Integer>{

}
