package com.cognizant.cartservice.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ExchangeServiceProxy.MenuItemExchangeServiceProxy;
import com.cognizant.cartservice.exception.MenuItemNotFoundException;
import com.cognizant.cartservice.model.Cart;
import com.cognizant.cartservice.model.MenuItem;
import com.cognizant.cartservice.repository.CartRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartDaoImpl implements CartDao {

	@Autowired
	MenuItemExchangeServiceProxy proxyService;

	@Autowired
	CartRepository cartRepository;

	@Override
	public void addCartItem(int userId, int menuItemId) throws MenuItemNotFoundException {
		log.debug("START");

		MenuItem item = proxyService.findMenuItemById(menuItemId);
		if (item == null) {
			throw new MenuItemNotFoundException();
		}

		Cart cart = new Cart();
		cart.setItem_id(menuItemId);
		cart.setUser_id(userId);
		cartRepository.save(cart);
		log.debug("END");
	}

	@Override
	public ArrayList<MenuItem> getAllCartItems(int userId) {
		log.debug("START");

		if (cartRepository.findUserIdCount(userId) == 0) {
			return null;
		}

		ArrayList<Cart> cartList = cartRepository.findByUserId(userId);
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		log.debug(Integer.toString(menuItemList.size()));
		log.debug(menuItemList.toString());
		if (cartList != null) {
			for (Cart cart : cartList) {
				MenuItem menuItem = proxyService.findMenuItemById(cart.getItem_id());
				menuItemList.add(menuItem);
			}
		}
		log.debug("task executed.");
		return menuItemList;
	}

	@Override
	public void deleteCartItem(int userId, int menuItemId) {
		log.debug("START");
		MenuItem menuItem = proxyService.findMenuItemById(menuItemId);
		ArrayList<Cart> cartList = cartRepository.findByUserId(userId);
		Cart delCart = null;
		for (Cart cart : cartList) {
			if (cart.getItem_id() == menuItemId) {
				delCart = cart;
			}

			if (delCart != null) {
				log.debug("deleting: " + menuItem.toString());
				cartRepository.delete(delCart);
			}
		}
	}

}
