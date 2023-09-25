package com.cg.Admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.Admin.models.Movies;

@Repository
public interface MoviesRepo extends JpaRepository<Movies,Integer>{

}
