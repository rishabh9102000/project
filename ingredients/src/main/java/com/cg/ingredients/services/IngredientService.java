package com.cg.ingredients.services;

import com.cg.ingredients.pojos.Ingredients;

public interface IngredientService {
	public Ingredients addIngredient(Ingredients ingredient);
	public Ingredients getIngredient(int id);
	public Ingredients updateIngredient(int id,int qunatity);
	public String deleteIngredient(int id);
	
}
