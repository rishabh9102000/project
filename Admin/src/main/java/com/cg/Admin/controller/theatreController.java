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

import com.cg.Admin.models.Theatre;
import com.cg.Admin.services.AdminServices;

import jakarta.validation.Valid;

@RestController
//@RequestMapping("/admin")
public class theatreController {
	
@Autowired AdminServices services;
	
	@PostMapping(value = "/theatre", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Theatre> addTheatre(@Valid @RequestBody Theatre theatre) throws IdNotFoundException{
		return new ResponseEntity<Theatre>(services.addTheatre(theatre),HttpStatus.CREATED);
	}
	@DeleteMapping(value = "/theatre/{theatreId}")
	public ResponseEntity<String> removeTheatre(@PathVariable int theatreId) throws IdNotFoundException{
		return new ResponseEntity<String>(services.removeTheatre(theatreId),HttpStatus.OK);
	}
	@GetMapping(value ="/theatre/{theatreId}")
	public ResponseEntity<Theatre> getTheatre(@PathVariable int theatreId) throws IdNotFoundException{
		return new ResponseEntity<Theatre>(services.getTheatre(theatreId),HttpStatus.OK);
	}
}
