package com.cognizant.ExchangeServiceProxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.cartservice.model.MenuItem;

@FeignClient(name = "menuitem-service")
public interface MenuItemExchangeServiceProxy {

	// to fetch menu item from feign client
	@GetMapping("/menu-item/customer/{menuItemId}")
	public MenuItem findMenuItemById(@PathVariable("menuItemId") int menuItemId);
}