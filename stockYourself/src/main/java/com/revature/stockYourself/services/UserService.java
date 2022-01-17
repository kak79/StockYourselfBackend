package com.revature.stockYourself.services;



import java.util.List;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.Stock;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.BadGetAllPortfolios;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.NoPortfolioByStock;
import com.revature.stockYourself.exceptions.NoPortfolioByUserIdException;
import com.revature.stockYourself.exceptions.NoPortfolioByUsernameException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

public interface UserService {
	public User register(User newUser) throws UsernameAlreadyExistsException;
	public User logIn(String username, String password) throws IncorrectCredentialsException;
	public User getUserById(int id);
	
	
	public Portfolio getPortfolioByUsername(String username) throws NoPortfolioByUsernameException;
	public Portfolio getPortfolioByUserId(int userId) throws NoPortfolioByUserIdException;
	public List<Portfolio> getAllPortfolios() throws BadGetAllPortfolios;
	public List<Portfolio> getPortfolioByStock(String stockName) throws NoPortfolioByStock;
	public void updatePortfolio(User loggedInUser, Portfolio portfolioToUpdate);
	public List<Stock> getAllStocks();
	public void buyStock(User loggedInUser, Stock stockToBuy);  //can be handled in frontend and sent to updatePortfolio
	public void sellStock(User loggedInUser, Stock stockToSell);  ////can be handled in frontend and sent to updatePortfolio
	
	
}
