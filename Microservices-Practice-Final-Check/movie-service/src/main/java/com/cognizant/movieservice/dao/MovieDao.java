package com.cognizant.movieservice.dao;

import java.util.List;

import com.cognizant.movieservice.model.Movie;

public interface MovieDao {

	public List<Movie> getMovieListAdmin();

	public List<Movie> getMovieListCustomer();

	public void modifyMovie(int movieId,Movie movie);

	public Movie getMovie(int movieId);
	
	public void addMovie(Movie movie);
	
	public void removeMovie(int movieId);
}
