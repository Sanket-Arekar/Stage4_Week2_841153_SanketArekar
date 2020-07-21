package com.cognizant.movieservice.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.movieservice.model.Movie;
import com.cognizant.movieservice.service.MovieServiceImpl;



@RestController
@RequestMapping(value="/movie",produces = MediaType.APPLICATION_JSON)

public class MovieController {

	@Autowired
	MovieServiceImpl movieServiceImpl;

	//Method is used to fetch Movie List for Admin 
	@GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON)
	public List<Movie> getMovieListAdmin() {
		return movieServiceImpl.getMovieListAdmin();
	}

	//Method is used to fetch Movie List for Customer
	@GetMapping(value = "/customer", produces = MediaType.APPLICATION_JSON)
	public List<Movie> getMovieListCustomer() {

		return movieServiceImpl.getMovieListCustomer();
	}

	//Method is used to modify Movie by Movie Id and accessible for Admin
	@PutMapping(value = "/admin/{movieId}")
	public void modifyMovie(@PathVariable @Valid int movieId, @RequestBody Movie movie) {
		movieServiceImpl.modifyMovie(movieId, movie);
	}

	//Method is used to fetch Movie by Movie Id for Customer
	@GetMapping(value = "/customer/{movieId}", produces = MediaType.APPLICATION_JSON)
	public Movie getMenuItemCustomer(@PathVariable int movieId) {

		return movieServiceImpl.getMovie(movieId);
	}

	//Method is used to fetch Movie by Movie Id for Admin
	@GetMapping(value = "/admin/{movieId}", produces = MediaType.APPLICATION_JSON)
	public Movie getMenuItemAdmin(@PathVariable int movieId) {

		return movieServiceImpl.getMovie(movieId);
	}

	//Method is used to add Movie in Database and accessible for Admin
	@PostMapping(value = "/admin")
	public void addMovie(@RequestBody Movie movie) {
		movieServiceImpl.addMovie(movie);
	}

	//Method is used to remove Movie from Database and accessible for Admin
	@DeleteMapping(value = "/admin/{movieId}")
	public void removeMovie(@PathVariable @Valid int movieId) {
		movieServiceImpl.removeMovie(movieId);
	}
}
