package com.cognizant.cartservice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cartservice.dao.CartDaoImpl;
import com.cognizant.cartservice.exception.MenuItemNotFoundException;
import com.cognizant.cartservice.model.MenuItem;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	CartDaoImpl cartDaoImpl;
	
	@Override
	public void addCartItem(int userId, int menuItemId) throws MenuItemNotFoundException {
		
		cartDaoImpl.addCartItem(userId, menuItemId);
		
	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(int userId) {
		
		return cartDaoImpl.getAllCartItems(userId);
	}

	@Override
	public void deleteCartItem(int userId, int menuItemId) {
		
		cartDaoImpl.deleteCartItem(userId, menuItemId);
	}

}
