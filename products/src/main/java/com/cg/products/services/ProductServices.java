package com.cg.products.services;

import com.cg.products.exceptions.IdNotFoundException;
import com.cg.products.pojo.Products;

public interface ProductServices {
	public Products addProduct(Products product);
	public Products getProduct(int id) throws IdNotFoundException;
	public String deleteProduct(int id);
	public Products updateProduct(int id,String name);
	
	
}
