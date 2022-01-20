package com.revature.stockYourself.services;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public interface UserService {
	public User register(User newUser) throws UsernameAlreadyExistsException;
	public User logIn(String username, String password) throws IncorrectCredentialsException;
	public User getUserById(int id);
	public yahoofinance.Stock getStockByStockname(String stockname) throws Exception;
	public Map<String, Stock> getListOfStocks(List<StockString> listOfStocknames)throws Exception;
	public Stock getStockHistoryWeekly(String stockname,int years) throws Exception;
	public Portfolio addStockToPortfolio(User user,StockString stock);
	public Portfolio removeStockToPortfolio(User user,StockString stock);
}