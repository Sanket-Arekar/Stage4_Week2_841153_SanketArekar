package com.cognizant.favoriteservice.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.favoriteservice.model.Favorite;
import com.cognizant.favoriteservice.model.Movie;

@Repository
@Transactional
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

	// Fetch items by user_id
	@Query(nativeQuery = true, value = "SELECT * from user_favorites uf WHERE uf.user_id = :user_id")
	public ArrayList<Favorite> findByUserId(@Param("user_id") int user_id);

	// Fetch count of items in cart
	@Query(nativeQuery = true, value = "SELECT count(*) from user_favorites uf WHERE uf.user_id = :user_id")
	public int findUserIdCount(@Param("user_id") int user_id);
}
