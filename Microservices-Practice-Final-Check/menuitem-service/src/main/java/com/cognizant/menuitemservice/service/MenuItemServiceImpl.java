package com.cognizant.menuitemservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.dao.MenuItemDaoImpl;
import com.cognizant.menuitemservice.model.MenuItem;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MenuItemServiceImpl implements MenuItemService {
	
	
	@Autowired
	MenuItemDaoImpl menuItemDaoImpl;
	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		log.info("START");
		List<MenuItem> menuItemListAdmin = menuItemDaoImpl.getMenuItemListAdmin();
		log.debug("MenuItemListAdmin: {}",menuItemListAdmin);
		log.info("END");
		return menuItemListAdmin;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		log.info("START");
		List<MenuItem> menuItemListCustomer = menuItemDaoImpl.getMenuItemListCustomer();
		log.debug("MenuItemListCustomer: {}",menuItemListCustomer);
		log.info("END");
		return menuItemListCustomer;
	}

	@Override
	public void modifyMenuItem(int menuItemId, MenuItem menuItem) {
		log.info("START");
		menuItemDaoImpl.modifyMenuItem(menuItemId, menuItem);
		log.info("END");
	}

	@Override
	public MenuItem getMenuItem(int menuItemId) {
		log.info("START");
		MenuItem menuItem = menuItemDaoImpl.getMenuItem(menuItemId);
		log.info("END");
		return menuItem;
	}

	@Override
	public void addMenuItem(MenuItem menuItem) {
		log.info("START");
		menuItemDaoImpl.addMenuItem(menuItem);
		log.info("END");
	}

	@Override
	public void removeMenuItem(int menuItemId) {
		log.info("START");
		menuItemDaoImpl.removeMenuItem(menuItemId);
		log.info("END");
		
	}

	
}
