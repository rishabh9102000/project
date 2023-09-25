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
import com.cg.Admin.models.City;

import com.cg.Admin.services.AdminServices;

import jakarta.validation.Valid;


@RestController
//@RequestMapping("/admin")
public class citycontroller {
	@Autowired AdminServices services;
	
	@PostMapping(value = "/city", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<City> addCity(@Valid @RequestBody City city) throws IdNotFoundException{
		return new ResponseEntity<City>(services.addCity(city),HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/city")
	public ResponseEntity<String> removeCity(@PathVariable int cityId) throws IdNotFoundException{
		return new ResponseEntity<String>(services.removeCity(cityId),HttpStatus.OK);
	}
	@GetMapping(value ="/city/{cityId}")
	public ResponseEntity<City> getTheatre(@PathVariable int cityId) throws IdNotFoundException{
		return new ResponseEntity<City>(services.getCity(cityId),HttpStatus.OK);
	}
}