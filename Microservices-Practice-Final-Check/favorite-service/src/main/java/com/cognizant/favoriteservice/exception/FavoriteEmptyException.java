package com.cognizant.favoriteservice.exception;

public class FavoriteEmptyException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	public FavoriteEmptyException() {
		super("User Id not Available. Favorites was never initialised.");
	}
}
