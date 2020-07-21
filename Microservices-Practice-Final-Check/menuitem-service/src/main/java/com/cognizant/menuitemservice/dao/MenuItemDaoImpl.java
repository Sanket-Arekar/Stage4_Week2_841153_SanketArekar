package com.cognizant.menuitemservice.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.exception.MenuItemNotFoundException;
import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.repository.MenuItemRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class MenuItemDaoImpl implements MenuItemDao {

	//Reference is used to retrieve MenuItem Data from Database 
	@Autowired
	MenuItemRepository menuItemRepository;

	@Override
	public List<MenuItem> getMenuItemListAdmin() {

		log.info("MenuItemDaoImpl public List<MenuItem> getMenuItemListAdmin() START");
		
		//Gives list of all MenuItems 
		List<MenuItem> menuItemListAdmin = menuItemRepository.findAll();
		
		log.debug("MenuItemListAdmin: {}", menuItemListAdmin);
		log.info("MenuItemDaoImpl public List<MenuItem> getMenuItemListAdmin()  END");
		return menuItemListAdmin;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		log.info("MenuItemDaoImpl public List<MenuItem> getMenuItemListCustomer() START");
		List<MenuItem> menuItemListCustomer = menuItemRepository.findAll();
		Iterator<MenuItem> menuItemListIterator = menuItemListCustomer.iterator();
		
		//Gives list of all active MenuItems
		while (menuItemListIterator.hasNext()) {
			MenuItem menuItem = (MenuItem) menuItemListIterator.next();
			if (!menuItem.isActive()) {
				menuItemListIterator.remove();
			}
		}
		log.debug("MenuItemListCustomer: {}", menuItemListCustomer);
		log.info("MenuItemDaoImpl public List<MenuItem> getMenuItemListCustomer()  END");
		return menuItemListCustomer;
	}

	@Override
	public void modifyMenuItem(int menuItemId, MenuItem menuItem) {

		log.info("public void modifyMenuItem(MenuItem menuItem) START");
		MenuItem menuItemFound = menuItemRepository.findById(menuItemId).orElseThrow(()->{throw new MenuItemNotFoundException();});

		menuItemFound.setName(menuItem.getName());
		menuItemFound.setPrice(menuItem.getPrice());
		menuItemFound.setActive(menuItem.isActive());
		menuItemFound.setDateOfLaunch(menuItem.getDateOfLaunch());
		menuItemFound.setCategory(menuItem.getCategory());
		menuItemFound.setFreeDelivery(menuItem.isFreeDelivery());
		
		log.info("public void modifyMenuItem(MenuItem menuItem)  END");

	}

	@Override
	public MenuItem getMenuItem(int menuItemId) {

		log.info("public MenuItem getMenuItem(int menuItemId) START");
		
		MenuItem menuItemFound = menuItemRepository.findById(menuItemId).orElseThrow(()->{throw new MenuItemNotFoundException();});
		
		log.debug("MenuItemFound : {}", menuItemFound);
		log.info("public MenuItem getMenuItem(int menuItemId)  END");
		return menuItemFound;
	}

	@Override
	public void addMenuItem(MenuItem menuItem) {
		log.info("public void addMenuItem(MenuItem menuItem) START");

		menuItemRepository.save(menuItem);

		log.debug("MenuItem : {}", menuItem);
		log.info("public void addMenuItem(MenuItem menuItem)  END");
	}

	@Override
	public void removeMenuItem(int menuItemId) {

		log.info("public void removeMenuItem(int menuItemId, MenuItem menuItem) START");
		MenuItem menuItem = menuItemRepository.getOne(menuItemId);
		menuItemRepository.delete(menuItem);
		log.info("public void removeMenuItem(int menuItemId, MenuItem menuItem)  END");
	}

}
