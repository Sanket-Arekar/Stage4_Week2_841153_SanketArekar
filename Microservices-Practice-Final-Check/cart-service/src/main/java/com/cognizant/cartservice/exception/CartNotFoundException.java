package com.cognizant.cartservice.exception;

public class CartNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CartNotFoundException() {
		super("User Id not Available. Cart was never initialised.");
	}

}