package com.cg.user.services;

import java.util.List;

import com.cg.user.dto.CityDto;
import com.cg.user.exceptions.IdNotFoundException;
import com.cg.user.model.Booking;

public interface UserService {
	public Booking addBooking(int cityId,int theatreId,int movieId) throws IdNotFoundException;
	public Booking getBooking(int bookingId) throws IdNotFoundException;
	public List<Integer> getAllTheatres(int cityId) throws IdNotFoundException;
	public List<Integer> getAllMovies(int theatreId) throws IdNotFoundException;
	

}