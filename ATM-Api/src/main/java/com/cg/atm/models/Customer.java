package com.cg.atm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	@NotBlank(message = "enter some name")
	private String customerName;
	@Min(value=1000,message="must be 4 digit")
	@Max(value=9999,message="must be 4 digit")
	private Integer pin;
}
