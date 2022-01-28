package com.revature.stockYourself.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.services.UserService;

@RestController
@RequestMapping(path="/users")
@CrossOrigin(origins="http://localhost:4200")
public class UsersController {

	private static UserService userServ;
	
	public UsersController() { super(); }
	
	@Autowired
	public UsersController(UserService userServ) {
		UsersController.userServ=userServ;
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
	


	@PostMapping(path="/portfolio/{userId}")
	public ResponseEntity<Portfolio> removeStockFromPortfolio(@RequestBody Portfolio portfolio,@RequestBody StockString stock,@PathVariable int userId) throws Exception {
		
		if(stock != null && portfolio != null) {
			Portfolio port = userServ.removeStockFromPortfolio(portfolio, stock);
			return ResponseEntity.ok(port);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@GetMapping(path="/portfolio/{portfolioId}")
	public ResponseEntity<List<StockString>> getPortfolioById(@RequestBody Portfolio existingPort,@PathVariable int portfolioId) throws Exception {
		if(existingPort != null) {
		List<StockString>stocks = userServ.getPortfolioStocks(existingPort);
		return ResponseEntity.ok(stocks);
		}
		return null;
	}
	


	@PostMapping(path="/stock/{userId}")
	public ResponseEntity<Void> addStockToPortfolio(@RequestBody Portfolio existingPort,@RequestBody StockString stock, @PathVariable int userId) throws Exception {
		
		if(stock != null && existingPort != null) {
			userServ.addStockToPortfolio(existingPort, stock);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	
	@GetMapping(path="/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		User user = userServ.getUserById(userId);
		if (user != null)
			return ResponseEntity.ok(user);
		else
			return ResponseEntity.notFound().build();
	}
	
}
