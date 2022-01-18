package com.revature.stockYourself.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockYourself.beans.Stock;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.AllStocksAreEmptyException;
import com.revature.stockYourself.exceptions.DataNotFoundException;
import com.revature.stockYourself.exceptions.NoPortfolioByUserException;
import com.revature.stockYourself.exceptions.PortfolioIdUserIdConflictException;
import com.revature.stockYourself.exceptions.PortfolioToUpdateIsNullException;
import com.revature.stockYourself.exceptions.StockListWasEmptyException;
import com.revature.stockYourself.services.AdminService;
import com.revature.stockYourself.services.UserService;

@RestController
@RequestMapping(path="/stock")
@CrossOrigin(origins="http://localhost:4200")
public class StockController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private AdminService adminServ;
	
	private static Logger log = LogManager.getLogger(PortfolioController.class);
	
	@GetMapping
	public ResponseEntity<List<Stock>> getStocks() throws AllStocksAreEmptyException {
		log.info("Getting all stocks");
		
		List<Stock> allStocks = userServ.getAllStocks();
		if(!(allStocks.isEmpty())) {
			return ResponseEntity.ok(allStocks);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	
	@PutMapping
	public ResponseEntity<Void> buyStock(@RequestBody User loggedInUser, @RequestBody Stock stockToBuy) throws StockListWasEmptyException, DataNotFoundException, NoPortfolioByUserException, PortfolioIdUserIdConflictException, PortfolioToUpdateIsNullException {
		log.info("Logged in user is buying a stock");
		log.debug("User: " +loggedInUser+ " failed to buy stock: " +stockToBuy);
		
		if(loggedInUser != null && stockToBuy != null) {
			userServ.buyStock(loggedInUser, stockToBuy);
			userServ.updatePortfolio(loggedInUser, loggedInUser.getPortfolio());
			return ResponseEntity.accepted().build();
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	@PutMapping
	public ResponseEntity<Void> sellStock(@RequestBody User loggedInUser, @RequestBody Stock stockToSell) throws StockListWasEmptyException, NoPortfolioByUserException, DataNotFoundException, PortfolioIdUserIdConflictException, PortfolioToUpdateIsNullException { //instead of throwing here should I surround with a try catch block?
		log.info("Logged in user is selling a stock");
		log.debug("User: " +loggedInUser+ " failed to buy stock: " +stockToSell);
		
		if(loggedInUser != null && stockToSell != null) {
			userServ.sellStock(loggedInUser, stockToSell);
			userServ.updatePortfolio(loggedInUser, loggedInUser.getPortfolio());
			return ResponseEntity.accepted().build();
		}
		
		return ResponseEntity.status(HttpStatus.CONFLICT).build();
	}
	
}
