package com.cognizant.menuitemservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.menuitemservice.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer>{ 
}
