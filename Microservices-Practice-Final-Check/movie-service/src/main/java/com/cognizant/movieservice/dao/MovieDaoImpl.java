package com.cognizant.movieservice.dao;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.movieservice.exception.MovieNotFoundException;
import com.cognizant.movieservice.model.Movie;
import com.cognizant.movieservice.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class MovieDaoImpl implements MovieDao {

	// Reference is used to retrieve MenuItem Data from Database
	@Autowired
	MovieRepository movieRepository;

	@Override
	public List<Movie> getMovieListAdmin() {
		log.info("public List<Movie> getMovieListAdmin() START");

		// Gives list of all Movies
		List<Movie> movieListAdmin = movieRepository.findAll();

		log.debug("MovieListAdmin: {}", movieListAdmin);
		log.info("public List<Movie> getMovieListAdmin()  END");
		return movieListAdmin;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		log.info("public List<Movie> getMovieListCustomer() START");
		List<Movie> movieListCustomer = movieRepository.findAll();
		Iterator<Movie> movieListIterator = movieListCustomer.iterator();

		// Gives list of all active Movies
		while (movieListIterator.hasNext()) {
			Movie movie = (Movie) movieListIterator.next();
			if (!movie.isActive()) {
				movieListIterator.remove();
			}
		}
		log.debug("MovieListCustomer: {}", movieListCustomer);
		log.info("public List<Movie> getMovieListCustomer()  END");
		return movieListCustomer;
	}

	@Override
	public void modifyMovie(int movieId, Movie movie) {
		log.info("public void modifyMovie(Movie movie) START");
		Movie movieFound = movieRepository.findById(movieId).orElseThrow(() -> {
			throw new MovieNotFoundException();
		});

		movieFound.setTitle(movie.getTitle());
		movieFound.setBoxOffice(movie.getBoxOffice());
		movieFound.setActive(movie.isActive());
		movieFound.setDateOfLaunch(movie.getDateOfLaunch());
		movieFound.setGenre(movie.getBoxOffice());
		movieFound.setHasTeaser(movie.isHasTeaser());

		log.info("public void modifyMovie(Movie movie)  END");

	}

	@Override
	public Movie getMovie(int movieId) {
		log.info("public Movie getMovie(int movieId) START");

		Movie movieFound = movieRepository.findById(movieId).orElseThrow(() -> {
			throw new MovieNotFoundException();
		});

		log.debug("MovieFound : {}", movieFound);
		log.info("public Movie getMovie(int movieId)  END");
		return movieFound;
	}

	@Override
	public void addMovie(Movie movie) {
		log.info("public void addMovie(Movie movie) START");

		movieRepository.save(movie);

		log.debug("Movie : {}", movie);
		log.info("public void addMovie(Movie movie)  END");

	}

	@Override
	public void removeMovie(int movieId) {
		log.info("public void removeMovie(int movieId) START");
		Movie movie = movieRepository.getOne(movieId);
		movieRepository.delete(movie);
		log.info("public void removeMovie(int movieId)  END");
	}

}
