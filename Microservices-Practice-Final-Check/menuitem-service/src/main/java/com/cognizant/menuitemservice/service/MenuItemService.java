package com.cognizant.menuitemservice.service;

import java.util.List;
import java.util.Optional;

import com.cognizant.menuitemservice.model.MenuItem;

public interface MenuItemService {

	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer();

	public void modifyMenuItem(int menuItemId,MenuItem menuItem);

	public MenuItem getMenuItem(int menuItemId);
	
	public void addMenuItem(MenuItem menuItem);
	
	public void removeMenuItem(int menuItemId);
}
