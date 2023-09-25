package com.cg.ingredients.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.ingredients.pojos.Ingredients;
import com.cg.ingredients.repo.IngredientRepo;

@Component
public class IngredientsServiceImpl implements IngredientService {
	@Autowired IngredientRepo repo;
	@Override
	public Ingredients addIngredient(Ingredients ingredient) {
		// TODO Auto-generated method stub
		return repo.save(ingredient);
	}

	@Override
	public Ingredients getIngredient(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public Ingredients updateIngredient(int id, int qunatity) {
		// TODO Auto-generated method stub
		Ingredients ingredient = repo.findById(id).get();
		ingredient.setQuantity(qunatity);
		return repo.save(ingredient);
		
	}

	@Override
	public String deleteIngredient(int id) {
		repo.deleteById(id);
		return "deleted";
	}

}
