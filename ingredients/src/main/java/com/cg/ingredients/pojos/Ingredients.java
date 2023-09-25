package com.cg.ingredients.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Ingredients {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ingredientId;
	private String ingredientName;
	private int quantity; 
}
