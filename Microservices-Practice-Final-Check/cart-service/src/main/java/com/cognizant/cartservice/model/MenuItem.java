package com.cognizant.cartservice.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//Menu Item class to store Menu Item
@Data
@Slf4j
public class MenuItem {

	private int id;
	private String name;
	private float price;
	private boolean active;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;

	// constructor
	public MenuItem() {
		log.info("Object created...");
	}
}