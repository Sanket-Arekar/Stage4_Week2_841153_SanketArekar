package com.cognizant.loan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoanController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoanController.class);
	
	@GetMapping("/loans/{number}")
	public String getLoanDetails(@PathVariable int number) {
		
		logger.info("Method getLoanDetails STARTED");
		
		logger.info("Method getLoanDetails ENDED");
		return "loan number:"+ number;
	}

}
