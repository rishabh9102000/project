package com.cg.atm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Valid
public  class Account {
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	

	@Id
	private int accountId;
	@NotNull(message="Balance is mandatory")
	private Integer balance;
	private int customerId;
	
	
}
