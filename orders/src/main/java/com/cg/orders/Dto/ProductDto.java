package com.cg.orders.Dto;

import java.util.List;


import lombok.Data;

@Data
public class ProductDto {
	
	private Integer productId;
	private String productName;
	private List<Integer> ingredients;
}
