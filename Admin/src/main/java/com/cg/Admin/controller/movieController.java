package com.cg.Admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.Admin.exception.IdNotFoundException;
import com.cg.Admin.models.Movies;

import com.cg.Admin.services.AdminServices;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/admin")
public class movieController {
@Autowired AdminServices services;
	
	@PostMapping(value = "/movie", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movies> addCity(@Valid @RequestBody Movies movie) throws IdNotFoundException{
		return new ResponseEntity<Movies>(services.addMovies(movie),HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/movie/{movieId}")
	public ResponseEntity<String> removeCity(@PathVariable int movieId) throws IdNotFoundException{
		return new ResponseEntity<String>(services.removeMovies(movieId),HttpStatus.OK);
	}
	@GetMapping(value ="/movie/{movieId}")
	public ResponseEntity<Movies> getTheatre(@PathVariable int movieId) throws IdNotFoundException{
		return new ResponseEntity<Movies>(services.getMovie(movieId),HttpStatus.OK);
	}
}