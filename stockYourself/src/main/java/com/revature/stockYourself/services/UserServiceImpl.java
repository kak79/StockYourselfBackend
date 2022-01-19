package com.revature.stockYourself.services;

import java.util.Map;
import java.util.Set;

import com.revature.stockYourself.beans.Portfolio;
import com.revature.stockYourself.beans.StockString;
import com.revature.stockYourself.beans.User;
import com.revature.stockYourself.exceptions.IncorrectCredentialsException;
import com.revature.stockYourself.exceptions.UsernameAlreadyExistsException;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserServiceImpl implements UserService {

	@Override
	public User register(User newUser) throws UsernameAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User logIn(String username, String password) throws IncorrectCredentialsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock getStockByStockname(String stockname) throws Exception {
		Stock stock = YahooFinance.get(stockname);
		return stock;
	}

	@Override
	public Map<String, Stock> getListOfStocks(String[] listOfStocknames) throws Exception {
		Map<String, Stock> stocks = YahooFinance.get(listOfStocknames);
		return stocks;
	}

	@Override
	public Stock getStockHistoryWeekly(String stockname,int years) throws Exception {
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.YEAR, -years);
		Stock stock = YahooFinance.get(stockname, from, to, Interval.WEEKLY);
		return stock;
	}
	
	public Portfolio addStockToPortfolio(User user,StockString stock) {
		Portfolio port = user.getPortfolio();
		port.getPortfolioStingStocks().add(stock);
		return port;
	}
	
	public Portfolio removeStockToPortfolio(User user,StockString stock) {
		Portfolio port = user.getPortfolio();
		Portfolio portnew = new Portfolio();
		port.getPortfolioStingStocks().forEach(st -> {
			if (st!= stock) {
				portnew.getPortfolioStingStocks().add(st);
			}
		});
		user.setPortfolio(portnew);
		return portnew;
	}
	
	
	

}