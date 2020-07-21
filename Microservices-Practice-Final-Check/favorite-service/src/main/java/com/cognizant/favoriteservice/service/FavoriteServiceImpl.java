package com.cognizant.favoriteservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.favoriteservice.dao.FavoriteDaoImpl;
import com.cognizant.favoriteservice.exception.MovieNotFoundException;
import com.cognizant.favoriteservice.model.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
	FavoriteDaoImpl favoriteDaoImpl;
	
	@Override
	public void addFavoriteMovie(int userId, int movieId) throws MovieNotFoundException {
		favoriteDaoImpl.addFavoriteMovie(userId, movieId);

	}

	@Override
	public ArrayList<Movie> getAllFavoriteMovies(int userId) {
		
		return favoriteDaoImpl.getAllFavoriteMovies(userId);
	}

	@Override
	public void deleteFavoriteMovie(int userId, int movieId) {
		
		favoriteDaoImpl.deleteFavoriteMovie(userId, movieId);

	}

}
