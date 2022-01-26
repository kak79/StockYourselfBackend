package com.revature.stockYourself.controllers;

import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class UsersController {
<<<<<<< HEAD
	private static UserService userServ;
	
	@Autowired
	public UsersController(UserService userServ) {
		this.userServ=userServ;
	}
	
  // POST to /users/auth
	@PostMapping(path="/auth")
	public ResponseEntity<String> logIn(@RequestBody Map<String, String> credentials) {
		String username = credentials.get("username");
		String password = credentials.get("password");
			
		try {
			User user = userServ.logIn(username, password);
			String token = Integer.toString(user.getUserId());
			return ResponseEntity.ok(token);
		} catch (IncorrectCredentialsException e) {
			return ResponseEntity.notFound().build();
		}
	}
		
	// GET to /users/{userId}/auth
	@GetMapping(path="/{userId}/auth")
	public ResponseEntity<User> checkLogin(@PathVariable int userId) {
		User loggedInUser = userServ.getUserById(userId);
		if (loggedInUser!=null) {
			return ResponseEntity.ok(loggedInUser);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping(path="/{userId}/portfolio")
	public ResponseEntity<Map<String,Stock>> viewMyPortfolio(@RequestBody User userPort,@PathVariable int userId) throws Exception {
		Map<String, Stock> stock = userServ.getListOfStocks(userPort.getPortfolio().getPortfolioStingStocks());
		if (stock != null) {
			return ResponseEntity.ok(stock);
		} else {
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
=======
>>>>>>> 6fb72ffccb81b8ccf41dbea5629265934019aeff
	
	
}
