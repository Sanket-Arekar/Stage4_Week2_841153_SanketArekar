package com.cognizant.favoriteservice.service;

import java.util.ArrayList;

import com.cognizant.favoriteservice.exception.MovieNotFoundException;
import com.cognizant.favoriteservice.model.Movie;

public interface FavoriteService {

	// to add Movie in given user Favorite
	void addFavoriteMovie(int userId, int movieId) throws MovieNotFoundException;

	// fetch all Movies from given user Favorite
	ArrayList<Movie> getAllFavoriteMovies(int userId);

	// delete Movie from given user and Favorite
	void deleteFavoriteMovie(int userId, int movieId);
}
