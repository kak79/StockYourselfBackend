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
		stocks = new ArrayList<>();
	}

	public int getPortfolioId() {
		return portfolioId;
	}	
	
	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}
	
	
	
	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public List<StockString> getPortfolioStringStocks() {
		return portfolioStingStocks;
	}

	public void setPortfolioStringStocks(List<StockString> portfolioStringStocks) {
		this.portfolioStingStocks = portfolioStringStocks;
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