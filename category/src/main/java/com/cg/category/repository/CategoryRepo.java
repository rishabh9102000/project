package com.cg.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.category.pojos.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{
	

}