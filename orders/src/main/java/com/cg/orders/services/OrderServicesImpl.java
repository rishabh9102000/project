package com.cg.orders.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cg.orders.Dto.IngredientsDto;
import com.cg.orders.Dto.ProductDto;
import com.cg.orders.Dto.categoryDto;
import com.cg.orders.exceptions.IdNotFoundException;
import com.cg.orders.exceptions.IngredientFinishedException;
import com.cg.orders.pojos.Orders;
import com.cg.orders.repository.OrderRepository;

@Component
public class OrderServicesImpl implements OrderServices {
	@Autowired RestTemplate restTemplate;
	@Autowired OrderRepository repo;
	
	@Override
	public Orders addOrder(Orders order) throws IngredientFinishedException,IdNotFoundException {
		// TODO Auto-generated method stub
//		if(!checkAvailibility(order.getProductId())) {throw new IngredientFinishedException("Ingredient out of stock");}
		ProductDto prod = getProducts(order.getProductId());
		if(checkCategory(order.getCategoryId()) ==null) { throw new IdNotFoundException("Category Id not Found");}
		if(checkProducts(order.getProductId())==null) { throw new IdNotFoundException("Product Id not Found");}
		setIngredients(prod.getIngredients());
		return repo.save(order);
	}

	@Override
	public Orders getOrder(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new IdNotFoundException("Order Id not found"));
	}
	
	 public ProductDto checkProducts(int productId) throws IdNotFoundException {
		try {
		ResponseEntity<ProductDto> response= restTemplate.getForEntity("http://localhost:9991/inventory/getProduct/"+productId, ProductDto.class);
		return response.getBody();
		}
		catch(HttpClientErrorException e) {
			throw new  IdNotFoundException("Product Id not Found");
		}
		
	 }
//	 public boolean checkAvailibility(int productId) throws IdNotFoundException  {
////		List<String> ingredients = restTemplate.getForEntity("http://localhost:9991/inventory/product/"+productId, ProductDto.class).getBody().getIngredients();
//		 List<Integer> ingredients = getProducts(productId).getIngredients();
//		 for(Integer ele : ingredients) {
//			 IngredientsDto quant = restTemplate.getForEntity("http://localhost:9992/inventory/getIngredient/"+ ele, IngredientsDto.class).getBody();
//			 int quantity = quant.getQuantity();
//			 if (quantity == 0) {
//				 return false;
//			 }
//		 }
//		 return true;
//		
//	 }
	
	 public categoryDto checkCategory(int categoryId) throws IdNotFoundException{
		try { 
		ResponseEntity<categoryDto> response = restTemplate.getForEntity("http://localhost:9993/inventory/getCategory/"+categoryId, categoryDto.class);
		 return response.getBody();
		}
		catch(HttpClientErrorException e) {
			throw new  IdNotFoundException("Category Id not Found");
		}
	}
	 public ProductDto getProducts(int productId) {
		 return restTemplate.getForEntity("http://localhost:9991/inventory/getProduct/"+productId, ProductDto.class).getBody();
	 }
	public void setIngredients(List<Integer> ingredients) {
		for(Integer ele : ingredients) {
			IngredientsDto quant = restTemplate.getForEntity("http://localhost:9999/inventory/getIngredient/"+ ele, IngredientsDto.class).getBody();
			int quantity = quant.getQuantity();
			int newq = quantity-1;
//			quant.setQuantity(newq);
//			 HttpHeaders headers = new HttpHeaders();
//			 headers.setContentType(MediaType.APPLICATION_JSON);
//		        // Set any required headers (e.g., authentication tokens)
//
//			 HttpEntity<IngredientsDto> requestEntity = new HttpEntity<>(headers);
			 restTemplate.put("http://localhost:9999/inventory/updateIngredient/" + ele +"/updatequantity/"+ newq,IngredientsDto.class);
		    //    ResponseEntity<IngredientsDto> response = restTemplate.exchange("http://localhost:9999/inventory/updateIngredient/" + ele +"/updatequantity/"+ 4, HttpMethod.PUT, requestEntity, IngredientsDto.class);
		}
		
	}
	

}
