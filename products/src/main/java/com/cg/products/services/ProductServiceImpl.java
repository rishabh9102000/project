package com.cg.products.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.products.exceptions.IdNotFoundException;
import com.cg.products.pojo.Products;
import com.cg.products.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductServices {
	@Autowired ProductRepository repo;

	
	public Products addProduct(Products product) {
		// TODO Auto-generated method stub
		return repo.save(product);
	}

	
	public Products getProduct(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new IdNotFoundException("Category Id not found"));
	}

	
	public String deleteProduct(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "deleted";
	}

	
	public Products updateProduct(int id, String name) {
		// TODO Auto-generated method stub
		Products product = repo.findById(id).get();
		product.setProductName(name);
		return repo.save(product);
	}
	
	
	

}
