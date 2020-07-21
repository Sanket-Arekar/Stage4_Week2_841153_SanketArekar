package com.cognizant.ExchangeServiceProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.favoriteservice.model.Movie;

@FeignClient(name = "movie-service")
public interface MovieExchangeServiceProxy {

	// to fetch movie from feign client
	@GetMapping("/movie/customer/{movieId}")
	public Movie findMovieById(@PathVariable("movieId") int movieId);
}