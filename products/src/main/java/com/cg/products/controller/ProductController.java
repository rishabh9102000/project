package com.cg.products.controller;

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

import com.cg.products.exceptions.IdNotFoundException;
import com.cg.products.pojo.Products;
import com.cg.products.services.ProductServices;

@RestController
public class ProductController {
	@Autowired ProductServices services;
	
	@PostMapping(value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> addProduct(@RequestBody Products products){
		return new ResponseEntity<Products>(services.addProduct(products),HttpStatus.OK);
	}
	@GetMapping(value="/getProduct/{id}")
	public ResponseEntity<Products> getIngredient(@PathVariable int id) throws IdNotFoundException {
		return new ResponseEntity<Products>(services.getProduct(id), HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteProduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		services.deleteProduct(id);
		return new ResponseEntity<String>("deleted Successfully",HttpStatus.NO_CONTENT);
	}
	@PutMapping(value="/updateProduct/{id}/{name}")
	public ResponseEntity<Products> updateProducts(@PathVariable int id,@PathVariable String name){
		return new ResponseEntity<Products>(services.updateProduct(id, name),HttpStatus.OK);
	}

}
