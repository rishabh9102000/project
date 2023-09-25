package com.cg.ingredients.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ingredients.pojos.Ingredients;

@Repository
public interface IngredientRepo extends JpaRepository<Ingredients,Integer> {

}
