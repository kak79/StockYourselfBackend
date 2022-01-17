package com.revature.stockYourself.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Portfolio {

	private int portfolioId;
	private Stock stock1;
	private Stock stock2;
	private Stock stock3;
	private Stock stock4;
	private Stock stock5;
	private List<Stock> portfolioStocks;
	
	
	public Stock getStock1() {
		return stock1;
	}

	public void setStock1(Stock stock1) {
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
	}

	public Stock getStock5() {
		return stock5;
	}

	public void setStock5(Stock stock5) {
		this.stock5 = stock5;
	}

	public Portfolio() {
		portfolioId = 0;
	}

	public int getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}
	
	public List<Stock> getPortfolioStocks() {
		 portfolioStocks = new ArrayList<Stock>();
		if(stock1 != null) {
			portfolioStocks.add(stock1);
		}
		if(stock2 != null) {
			portfolioStocks.add(stock2);
		}
		if(stock3 != null) {
			portfolioStocks.add(stock3);
		}
		if(stock4 != null) {
			portfolioStocks.add(stock4);
		}
		if(stock5 != null) {
			portfolioStocks.add(stock5);
		}
		return portfolioStocks;
		
	}
	
	public void setPortfolioStocksToStocks(List<Stock> stocksToUpdate) {
		if (!(stocksToUpdate.isEmpty())) {
			if(stocksToUpdate.get(0) != null) {
				stock1 = stocksToUpdate.get(0);
				}
			if(stocksToUpdate.get(1) != null) {
				stock2 = stocksToUpdate.get(1);
			}
			if(stocksToUpdate.get(2) != null) {
				stock3 = stocksToUpdate.get(2);
			}
			if(stocksToUpdate.get(3) != null) {
				stock4 = stocksToUpdate.get(3);
			}
			if(stocksToUpdate.get(4) != null) {
				stock5 = stocksToUpdate.get(4);
			}
		} else {
			// throw new StockListWasEmptyException(); //create StockListWasEmpty() exception
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(portfolioId, stock1, stock2, stock3, stock4, stock5);
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
		return portfolioId == other.portfolioId && Objects.equals(stock1, other.stock1)
				&& Objects.equals(stock2, other.stock2) && Objects.equals(stock3, other.stock3)
				&& Objects.equals(stock4, other.stock4) && Objects.equals(stock5, other.stock5);
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", stock1=" + stock1 + ", stock2=" + stock2 + ", stock3="
				+ stock3 + ", stock4=" + stock4 + ", stock5=" + stock5 + "]";
	}

	
	
	
	
}
