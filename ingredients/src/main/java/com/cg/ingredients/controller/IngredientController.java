package com.cg.ingredients.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ingredients.pojos.Ingredients;
import com.cg.ingredients.services.IngredientService;

@RestController
public class IngredientController  {
	@Autowired IngredientService ingService;
	
	@PostMapping(value = "/addIngredient", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Ingredients> addCategory(@RequestBody Ingredients ingredients){
		return new ResponseEntity<Ingredients>(ingService.addIngredient(ingredients),HttpStatus.OK);
	}
	@GetMapping(value="/getIngredient/{id}")
	public ResponseEntity<Ingredients> getIngredient(@PathVariable int id) {
		return new ResponseEntity<Ingredients>(ingService.getIngredient(id), HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteIngredient/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id){
		ingService.deleteIngredient(id);
		return new ResponseEntity<String>("deleted Successfully",HttpStatus.NO_CONTENT);
	}
	@PutMapping(value="/updateIngredient/{id}/updatequantity/{quantity}")
	public ResponseEntity<Ingredients> updateCategory(@PathVariable int id,@PathVariable int quantity){
		return new ResponseEntity<Ingredients>(ingService.updateIngredient(id, quantity),HttpStatus.OK);
	}
}
