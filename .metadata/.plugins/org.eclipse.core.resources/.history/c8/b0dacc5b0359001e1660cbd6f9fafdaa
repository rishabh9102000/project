package com.cg.Admin.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movies {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int movieId;
	@NotBlank(message="cannot be empty")
	private String movieName;
	private List<Integer> theatreId;
	
}
