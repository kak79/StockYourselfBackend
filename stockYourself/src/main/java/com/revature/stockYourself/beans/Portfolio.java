package com.revature.stockYourself.beans;


import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import yahoofinance.Stock;

@Entity
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int portfolioId;
	private List<yahoofinance.Stock> stocks;
	
	public Portfolio() {
		portfolioId = 0;
<<<<<<< HEAD
<<<<<<< HEAD
		
	}
	
	
	public Stock getStock1() {
		return stock1;
	}

	public void setStock1(Stock stock1) {
	//	stock1 = yahoofinance.get(stock1.getName());
		this.stock1 = stock1;
	}

	public Stock getStock2() {
		return stock2;
	}

	public void setStock2(Stock stock2) {
		this.stock2 = stock2;
	}

	public Stock getStock3() {
		return stock3;
	}

	public void setStock3(Stock stock3) {
		this.stock3 = stock3;
	}

	public Stock getStock4() {
		return stock4;
	}

	public void setStock4(Stock stock4) {
		this.stock4 = stock4;
=======
		portfolioName = " ";
		portfolioStingStocks = new ArrayList<>();
	}	
	
=======
		stocks = new ArrayList<>();
	}

>>>>>>> 6fb72ffccb81b8ccf41dbea5629265934019aeff
	public int getPortfolioId() {
		return portfolioId;
	}	
	
	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
>>>>>>> 619ff788b8ff55624d19b9c66070ed89fcf47782
	}
	
	
	
	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

<<<<<<< HEAD
<<<<<<< HEAD
	public int getPortfolioId() {
		return portfolioId;
=======
	public List<StockString> getPortfolioStingStocks() {
		return portfolioStingStocks;
	}

	public void setPortfolioStingStocks(List<StockString> portfolioStingStocks) {
		this.portfolioStingStocks = portfolioStingStocks;
>>>>>>> 619ff788b8ff55624d19b9c66070ed89fcf47782
=======
	public List<StockString> getPortfolioStringStocks() {
		return portfolioStingStocks;
	}

	public void setPortfolioStringStocks(List<StockString> portfolioStringStocks) {
		this.portfolioStingStocks = portfolioStringStocks;
>>>>>>> 6fb72ffccb81b8ccf41dbea5629265934019aeff
	}

	public List<yahoofinance.Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<yahoofinance.Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(portfolioId, stocks);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Portfolio other = (Portfolio) obj;
		return portfolioId == other.portfolioId && Objects.equals(stocks, other.stocks);
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", stocks=" + stocks + "]";
	}

	
	
	

	
	
}