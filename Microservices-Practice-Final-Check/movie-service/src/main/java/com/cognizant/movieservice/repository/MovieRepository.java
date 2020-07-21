package com.cognizant.movieservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.movieservice.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
