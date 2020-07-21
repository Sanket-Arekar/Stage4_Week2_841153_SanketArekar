package com.cognizant.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@GetMapping("/accounts/{number}")
	public String getAccountDetails(@PathVariable int number) {
		
		logger.info("Method getAccountDetails STARTED");
		
		
		
		
		logger.info("Method getAccountDetails ENDED");
		return "number:"+ number;
	}

}
