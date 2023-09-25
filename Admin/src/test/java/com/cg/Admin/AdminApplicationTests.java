package com.cg.Admin;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import com.cg.Admin.exception.IdNotFoundException;
import com.cg.Admin.models.City;
import com.cg.Admin.models.Movies;
import com.cg.Admin.models.Theatre;
import com.cg.Admin.repo.CityRepo;
import com.cg.Admin.repo.MoviesRepo;
import com.cg.Admin.repo.TheatreRepo;
import com.cg.Admin.services.AdminServices;
import com.cg.Admin.services.AdminServicesImpl;


@ExtendWith(MockitoExtension.class)
class AdminApplicationTests {
	
	@Mock CityRepo crepo;
	@Mock MoviesRepo mrepo;
	@Mock TheatreRepo trepo;
	@InjectMocks AdminServices services = new AdminServicesImpl();
	@Test
	void testGetCity() throws IdNotFoundException {
		int cityId = 1;
		List<Integer> l = new ArrayList<Integer>();
		
		City city = new City(1,"pune",l);
		
		 when(crepo.findById(cityId)).thenReturn(Optional.of(city));
		 assertEquals("pune",services.getCity(cityId).getCityName());
	}
	@Test
	void testGetMovies() throws IdNotFoundException {
		int movieId = 1;
		List<Integer> l = new ArrayList<Integer>();
		
		Movies movie = new Movies(1,"jawan",l);
	
		 when(mrepo.findById(movieId)).thenReturn(Optional.of(movie));
		 assertEquals("jawan",services.getMovie(movieId).getMovieName());
	}
//	
//	@Test
//	void testGetMoviees() throws IdNotFoundException {
//		int movieId = 1;
//		List<Integer> l = new ArrayList<Integer>();
//		
//		Movies movie = new Movies(1,"jawan",l);
//		
//		 when(mrepo.findById(movieId)).thenReturn(Optional.of(movie));
//		 assertThrows("jawan",services.getMovie(movieId).getMovieName());
//	}
	@Test
	void testGetTheatre() throws IdNotFoundException {
		int tId = 1;
		List<Integer> l = new ArrayList<Integer>();
		Theatre theatre = new Theatre(1,"pvr",l,l);
		 when(trepo.findById(tId)).thenReturn(Optional.of(theatre));
		 assertEquals("pvr",services.getTheatre(tId).getTheatreName());
	}
	@Test
	void getMoviesTestException() throws IdNotFoundException {
		int movieId = 1;
		List<Integer> l = new ArrayList<Integer>();
		Movies movie = new Movies(1,"jawan",l);
		when(mrepo.findById(movieId)).thenReturn(Optional.empty());
		assertThrows(IdNotFoundException.class, () -> services.getMovie(movieId));
	}
//	@Test
//	void addmovieTest() throws IdNotFoundException{
//		List<Integer> l = new ArrayList<Integer>();
//		l.add(1);
//		Movies movie = new Movies(1,"jawan",l);
//		//Theatre th = new Theatre(1,"pvr",l,l);
//		//when(trepo.save(th)).thenReturn(th);
//		when(mrepo.save(movie)).thenReturn(movie);
////		when(mrepo.findById(movie.getMovieId())).thenReturn(Optional.of(movie));
//	//	when(services.getTheatre(1)).thenReturn(th);
////		when(trepo.findById(th.getTheatreId())).thenReturn(Optional.of(th));
//		Movies result = services.addMovies(movie);
//
//		assertEquals(movie,result);
//	//	assertThrows(IdNotFoundException.class, () -> services.getTheatre(1));
//		
//	}
	
	@Test
	void addcity() throws IdNotFoundException {
List<Integer> l = new ArrayList<Integer>();
		
		City city = new City(1,"pune",l);
		when(crepo.save(city)).thenReturn(city);
		assertEquals(city,services.addCity(city));
	}
	@Test
	void addTheaterTest() throws IdNotFoundException {
List<Integer> l = new ArrayList<Integer>();
		
		Theatre theatre = new Theatre(1,"pvr",l,l);
		
		 when(trepo.save(theatre)).thenReturn(theatre);
		 assertEquals(theatre,services.addTheatre(theatre));
	}
	@Test
	void testGetTheatreException() throws IdNotFoundException { 
		int tId = 1;
		List<Integer> l = new ArrayList<Integer>();
		
		Theatre theatre = new Theatre(1,"pvr",l,l);
		
		 when(trepo.findById(tId)).thenReturn(Optional.empty());
		 assertThrows(IdNotFoundException.class, () -> services.getTheatre(tId));
		 
	}
	@Test
	void testGetCityException() throws IdNotFoundException{
		int mId=1;
		 when(crepo.findById(mId)).thenReturn(Optional.empty());
		 assertThrows(IdNotFoundException.class, () -> services.getCity(mId));
	}
	@Test
	void testRemoveTheatre() throws IdNotFoundException {
		int tId = 1;
		List<Integer> l = new ArrayList<Integer>();
		
		Theatre theatre = new Theatre(1,"pvr",l,l);
		
		 when(trepo.findById(tId)).thenReturn(Optional.of(theatre));
		 assertEquals("succesfully deleted",services.removeTheatre(tId));
	}
	@Test
	void testRemoveMovie() throws IdNotFoundException {
		int movieId = 1;
		List<Integer> l = new ArrayList<Integer>();
		
		Movies movie = new Movies(1,"jawan",l);
		
		 when(mrepo.findById(movieId)).thenReturn(Optional.of(movie));
		
		 assertEquals("succesfully deleted",services.removeMovies(movieId));
	}
	@Test
	void testRemoveCity() throws IdNotFoundException {
		
		int cityId = 1;
		List<Integer> l = new ArrayList<Integer>();
		
		City city = new City(1,"pune",l);
		
		 when(crepo.findById(cityId)).thenReturn(Optional.of(city));
		
		 assertEquals("succesfully deleted",services.removeCity(cityId));
	}


}
