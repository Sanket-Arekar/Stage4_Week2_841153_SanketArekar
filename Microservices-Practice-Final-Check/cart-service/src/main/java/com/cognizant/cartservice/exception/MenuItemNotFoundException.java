package com.cognizant.cartservice.exception;

public class MenuItemNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MenuItemNotFoundException() {
		super("MenuItem Id not Available.");
	}

}