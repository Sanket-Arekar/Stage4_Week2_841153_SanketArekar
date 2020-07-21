package com.cognizant.authenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.models.User;


public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String userName); 
}
