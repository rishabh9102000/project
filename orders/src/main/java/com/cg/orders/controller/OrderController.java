package com.cg.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.orders.Dto.ProductDto;
import com.cg.orders.Dto.categoryDto;
import com.cg.orders.exceptions.IdNotFoundException;
import com.cg.orders.exceptions.IngredientFinishedException;
import com.cg.orders.pojos.Orders;
import com.cg.orders.services.OrderServices;

@RestController
public class OrderController {
	@Autowired OrderServices services;
	
	@PostMapping(value = "/Order", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Orders> addOrder(@RequestBody Orders order) throws IngredientFinishedException, IdNotFoundException{
		return new ResponseEntity<Orders>(services.addOrder(order),HttpStatus.CREATED);
	}
	@GetMapping(value="/Order/{id}")
	public ResponseEntity<Orders> getOrder(@PathVariable int id) throws IdNotFoundException {
		return new ResponseEntity<Orders>(services.getOrder(id), HttpStatus.OK);
	}
//	@GetMapping(value="/getProducts/{productId}")
//	public ResponseEntity<ProductDto> getProducts(@PathVariable int productId){
//		return new ResponseEntity<ProductDto>(services.getProducts(productId),HttpStatus.OK);
//	}
//	@GetMapping(value="/checkCategory/{categoryId}")
//	public ResponseEntity<categoryDto> checkCategory(@PathVariable int categoryId) throws IdNotFoundException{
//		return new ResponseEntity<categoryDto>(services.checkCategory(categoryId),HttpStatus.OK);
//	}
}