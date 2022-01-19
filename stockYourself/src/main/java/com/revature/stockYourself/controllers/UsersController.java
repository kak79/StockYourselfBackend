package com.revature.stockYourself.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.services.UserService;

import yahoofinance.Stock;

@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins="http://localhost:4200")
public class UsersController {
	private static UserService userServ;
	
	@Autowired
	public UsersController(UserService userServ) {
		this.userServ=userServ;
	}
	
	
	@PostMapping(path="/{userId}/portfolio")
	public ResponseEntity<Map<String,Stock>> viewMyPortfolio(@RequestBody User userPort,@PathVariable int userId) throws Exception {
		Map<String, Stock> stock = userServ.getListOfStocks(userPort.getPortfolio().getPortfolioStingStocks());
		if (stock != null) {
			return ResponseEntity.ok(stock);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping(path="/{userId}/portfolio")
	public ResponseEntity<Portfolio> removeStockFromPortfolio(@RequestBody User user,@RequestBody StockString stock) throws Exception {
		
		if(stock != null && user != null) {
			Portfolio port = userServ.removeStockToPortfolio(user, stock);
			return ResponseEntity.ok(port);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping(path="/{userId}")
	public ResponseEntity<Portfolio> addStockToPortfolio(@RequestBody User user,@RequestBody StockString stock) throws Exception {
		
		if(stock != null && user != null) {
			Portfolio port = userServ.addStockToPortfolio(user, stock);
			return ResponseEntity.ok(port);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
}
