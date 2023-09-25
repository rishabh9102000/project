package com.cg.orders.services;

import com.cg.orders.Dto.ProductDto;
import com.cg.orders.Dto.categoryDto;
import com.cg.orders.exceptions.IdNotFoundException;
import com.cg.orders.exceptions.IngredientFinishedException;
import com.cg.orders.pojos.Orders;

public interface OrderServices {
	public Orders addOrder(Orders order) throws IngredientFinishedException, IdNotFoundException;
	public Orders getOrder(int id) throws IdNotFoundException;
//	 public ProductDto getProducts(int productId);
//	 public categoryDto checkCategory(int categoryId) throws IdNotFoundException;
//	

}
