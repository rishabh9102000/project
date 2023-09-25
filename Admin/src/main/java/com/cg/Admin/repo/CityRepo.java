package com.cg.Admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Admin.models.City;

@Repository
public interface CityRepo extends JpaRepository<City,Integer> {

}
