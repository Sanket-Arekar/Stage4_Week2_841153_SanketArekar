package com.cognizant.favoriteservice.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ExchangeServiceProxy.MovieExchangeServiceProxy;
import com.cognizant.favoriteservice.exception.MovieNotFoundException;
import com.cognizant.favoriteservice.model.Favorite;
import com.cognizant.favoriteservice.model.Movie;
import com.cognizant.favoriteservice.repository.FavoriteRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class FavoriteDaoImpl implements FavoriteDao {

	@Autowired
	MovieExchangeServiceProxy proxyService;

	@Autowired
	FavoriteRepository favoriteRepository;

	@Override
	public void addFavoriteMovie(int userId, int movieId) throws MovieNotFoundException {
		log.debug("START");

		Movie movie = proxyService.findMovieById(movieId);
		if (movie == null) {
			throw new MovieNotFoundException();
		}

		Favorite favorite = new Favorite();
		favorite.setMovie_id(movieId);
		favorite.setUser_id(userId);
		favoriteRepository.save(favorite);
		log.debug("END");

	}

	@Override
	public ArrayList<Movie> getAllFavoriteMovies(int userId) {
		log.debug("START");

		//if (favoriteRepository.findUserIdCount(userId) == 0) {
		//	return null;
		//}

		ArrayList<Favorite> favoriteList = favoriteRepository.findByUserId(userId);
		ArrayList<Movie> movieList = new ArrayList<>();
		log.debug(Integer.toString(movieList.size()));
		log.debug(movieList.toString());
		if (favoriteList != null) {
			for (Favorite favorite : favoriteList) {
				Movie movie = proxyService.findMovieById(favorite.getMovie_id());
				movieList.add(movie);
			}
		}
		log.debug("task executed.");
		return movieList;
	}

	@Override
	public void deleteFavoriteMovie(int userId, int movieId) {
		log.debug("START");
		Movie movie = proxyService.findMovieById(movieId);
		ArrayList<Favorite> favoriteList = favoriteRepository.findByUserId(userId);
		Favorite delFavorite = null;
		for (Favorite favorite : favoriteList) {
			if (favorite.getMovie_id() == movieId) {
				delFavorite = favorite;
			}

			if (delFavorite != null) {
				log.debug("deleting: " + movie.toString());
				favoriteRepository.delete(delFavorite);
			}
		}
	}

}
