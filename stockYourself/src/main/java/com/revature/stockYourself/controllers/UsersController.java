package com.revature.stockYourself.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.StockData;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.services.UserService;
import com.revature.stockYourself.services.UserServiceImpl;

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
	
	@GetMapping("/stock/{stockStringId}")
	public String getStockDetails(@PathVariable int stockStringId, Model model)throws Exception {
		StockString stockString = userServ.;
		List<StockData> stockList = new ArrayList<>();
		stockList.add(stockData);
		model.addAttribute("stockList",stockList);
		return "stock";
	}
	
	
	@GetMapping(path="/portfolio/{portfolioId}")
	public ResponseEntity<List<StockString>> getPortfolioById(@RequestBody Portfolio existingPort,@PathVariable int portfolioId) throws Exception {
		if(existingPort != null) {
		List<StockString>stocks = userServ.getPortfolio(existingPort);
		return ResponseEntity.ok(stocks);
		}
		return null;
	}
	
	
	@PutMapping(path="/portfolio/{portfolioId}/")
	public ResponseEntity<Void> removeStockFromPortfolio(@RequestBody Portfolio existingPort,@RequestBody StockString stock,@PathVariable int portfolioId) throws Exception {
		
		if(stock != null && existingPort != null) {
			userServ.removeStockFromPortfolio(existingPort, stock);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping(path="/stock/{stockStringId}")
	public ResponseEntity<Void> addStockToPortfolio(@RequestBody Portfolio existingPort,@RequestBody StockString stock, @PathVariable int portforlioId) throws Exception {
		
		if(stock != null && existingPort != null) {
			userServ.addStockToPortfolio(existingPort, stock);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
}
