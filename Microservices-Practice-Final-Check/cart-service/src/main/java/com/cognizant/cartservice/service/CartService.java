package com.cognizant.cartservice.service;

import java.util.ArrayList;

import com.cognizant.cartservice.exception.MenuItemNotFoundException;
import com.cognizant.cartservice.model.MenuItem;

public interface CartService {

	//to add item in given user cart
			void addCartItem(int userId, int menuItemId) throws MenuItemNotFoundException;

			//fetch all items in given user cart
			ArrayList<MenuItem> getAllCartItems(int userId);

			//delete item from given user and cart
			void deleteCartItem(int userId, int menuItemId);
}
