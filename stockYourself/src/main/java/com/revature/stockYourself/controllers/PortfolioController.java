package com.revature.stockYourself.controllers;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.BadGetAllPortfolios;
import com.revature.stockYourself.exceptions.NoPortfolioByStock;
import com.revature.stockYourself.exceptions.NoPortfolioByUsernameException;
import com.revature.stockYourself.services.AdminService;
import com.revature.stockYourself.services.UserService;

@RestController
@RequestMapping(path="/portfolio")
@CrossOrigin(origins="http://localhost:4200")
public class PortfolioController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private AdminService adminServ;
	
	private static Logger log = LogManager.getLogger(PortfolioController.class);
	
	@GetMapping
	public ResponseEntity<List<Portfolio>> getProfolios() throws BadGetAllPortfolios {
		log.info("Getting all profolios");
		
		List<Portfolio> allPortfolios =  userServ.getAllPortfolios();
		if (!(allPortfolios.isEmpty())) {
			return ResponseEntity.ok(allPortfolios);
		} else {
			return ResponseEntity.badRequest().build();	
		}
		
	}
	
	@GetMapping
	public ResponseEntity<Portfolio> getPortfolioByUserId(@PathVariable int userId) throws NoPortfolioByUsernameException {
		log.info("Getting portfolio by given user id");
		
	try {	
		log.debug("Can not get portfolio by given user id: " +userId);
		
		if(userId > 1) {
			Portfolio portfolio = userServ.getPortfolioByUsername(userServ.getUserById(userId).getUsername());
				if (portfolio != null) {
					return ResponseEntity.ok(portfolio);
				} else {
					return ResponseEntity.noContent().build();
				}
		}
	} catch (NoPortfolioByUsernameException e) {
		log.error("Username input does not return portfolio");
		
	   }
	return ResponseEntity.notFound().build();
			
	}
	
	@GetMapping
	public ResponseEntity<Portfolio> getPortfolioByUsername(@PathVariable String username) throws NoPortfolioByUsernameException {
		if(username != null) {
			Portfolio portfolio = userServ.getPortfolioByUsername(username);
				if (portfolio != null) {
					ResponseEntity.ok(portfolio);
				} else {
					ResponseEntity.noContent();
				}
		} 
		
		return ResponseEntity.notFound().build();
		
	}
	
	@GetMapping
	public ResponseEntity<Portfolio> getPortfolioByStock(@PathVariable String stockName) throws NoPortfolioByUsernameException, NoPortfolioByStock {
		if(stockName != null) {
			List<Portfolio> portfolioByStocks = userServ.getPortfolioByStock(stockName);
				if (!(portfolioByStocks.isEmpty())) {
					ResponseEntity.ok(portfolioByStocks);
				} else {
					ResponseEntity.noContent();
				}
		} 
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	@PutMapping(path="/myportfolio")
	public ResponseEntity<Void> updatePortfolio(@RequestBody User loggedInUser, @RequestBody Portfolio portfolioToUpdate) {
		log.info("Updating Portfolio");
		log.debug("Failed to update portfolio: " +portfolioToUpdate);
		
		if(portfolioToUpdate != null) {
			userServ.updatePortfolio(loggedInUser, portfolioToUpdate);
			ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} 
		
		return ResponseEntity.badRequest().build();	
	}

}
