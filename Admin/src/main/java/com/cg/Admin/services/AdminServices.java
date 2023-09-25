package com.cg.Admin.services;

import com.cg.Admin.exception.IdNotFoundException;
import com.cg.Admin.models.City;
import com.cg.Admin.models.Movies;
import com.cg.Admin.models.Theatre;

public interface AdminServices {
	public City addCity(City city) throws IdNotFoundException;
	public String removeCity(int cityId) throws IdNotFoundException;
	public Theatre addTheatre(Theatre theatre) throws IdNotFoundException ;
	public Movies addMovies(Movies movie) throws IdNotFoundException;
	public String removeTheatre(int theatreId) throws IdNotFoundException;
	public String removeMovies(int movieId) throws IdNotFoundException;
	public City getCity(int cityId) throws IdNotFoundException;
	public Theatre getTheatre(int theatreId) throws IdNotFoundException;
	public Movies getMovie(int movieId) throws IdNotFoundException;
	

}
