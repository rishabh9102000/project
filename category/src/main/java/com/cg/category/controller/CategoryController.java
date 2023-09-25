package com.cg.category.controller;

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

import com.cg.category.exceptions.IdNotFoundException;
import com.cg.category.pojos.Category;
import com.cg.category.services.CategoryServices;






@RestController
public class CategoryController {
	@Autowired CategoryServices categoryServices;
	
	
	@PostMapping(value = "/addCategory", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		return new ResponseEntity<Category>(categoryServices.addCategory(category),HttpStatus.CREATED);
	}
	@GetMapping(value="/getCategory/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable int id) throws IdNotFoundException  {
		return new ResponseEntity<Category>(categoryServices.getCategory(id), HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteCategory/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id){
		categoryServices.deleteCategory(id);
		return new ResponseEntity<String>("deleted Successfully",HttpStatus.NO_CONTENT);
	}
	@PutMapping(value="/updateCategory/{id}/{name}")
	public ResponseEntity<Category> updateCategory(@PathVariable int id,@PathVariable String name){
		return new ResponseEntity<Category>(categoryServices.updateCategory(id, name),HttpStatus.ACCEPTED);
	}
}
