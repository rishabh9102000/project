package com.cg.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.user.dto.CityDto;
import com.cg.user.exceptions.IdNotFoundException;
import com.cg.user.model.Booking;
import com.cg.user.services.UserService;

@RestController
public class UserController {
	@Autowired UserService service;
	
	@GetMapping(value ="/user/city/{cityId}")
	public ResponseEntity<List<Integer>> getAllTheatres(@PathVariable int cityId) throws IdNotFoundException {
		return new ResponseEntity<List<Integer>>(service.getAllTheatres(cityId),HttpStatus.OK);
	}
	@GetMapping(value ="/user/theatre/{theatreId}")
	public ResponseEntity<List<Integer>> getAllMovies(@PathVariable int theatreId) throws IdNotFoundException {
		return new ResponseEntity<List<Integer>>(service.getAllMovies(theatreId),HttpStatus.OK);
	}
	@PostMapping(value ="/user/{cId}/{tId}/{mId}")
	public ResponseEntity<Booking> createBooking(@PathVariable int cId,@PathVariable int tId,@PathVariable int mId) throws IdNotFoundException{
		return new ResponseEntity<Booking>(service.addBooking( cId, tId, mId),HttpStatus.CREATED);
	}
	@GetMapping(value ="/user/booking/{bId}")
	public ResponseEntity<Booking> getAllBookings(@PathVariable int bId) throws IdNotFoundException {
		return new ResponseEntity<Booking>(service.getBooking(bId),HttpStatus.OK);
	}
}
