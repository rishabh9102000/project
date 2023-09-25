package com.cg.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookingId;
	@NotBlank(message="cannot be empty")
	private String cityName;
	@NotBlank(message="cannot be empty")
	private String movieName;
	@NotBlank(message="cannot be empty")
	private String theatreName;
	
}
