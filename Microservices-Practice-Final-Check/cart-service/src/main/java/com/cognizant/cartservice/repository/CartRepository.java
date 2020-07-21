package com.cognizant.cartservice.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.cartservice.model.Cart;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	//Fetch items by user_id
	@Query(nativeQuery = true, value="SELECT * from user_carts uc WHERE uc.user_id = :user_id")
	public ArrayList<Cart> findByUserId(@Param("user_id") int user_id); 

	//Fetch count of items in cart
	@Query(nativeQuery = true, value="SELECT count(*) from user_carts uc WHERE uc.user_id = :user_id")
	public int findUserIdCount(@Param("user_id") int user_id);
}