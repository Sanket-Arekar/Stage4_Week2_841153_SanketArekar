package com.cognizant.cartservice.model;

import javax.persistence.Column;

//import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//Entity Class
@Entity
@Table(name = "user_carts")
@Data
@Slf4j
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "item_id")
	private int item_id;
	
	//constructor
	public Cart(){
		log.info("Cart object created.");
	}
}