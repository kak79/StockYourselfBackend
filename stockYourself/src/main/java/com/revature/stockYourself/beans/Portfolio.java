package com.revature.stockYourself.beans;

import java.util.ArrayList;

import java.util.List;
import java.util.Objects;import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="portfolio")
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int portfolioId;
	private String portfolioName;
	// private double points;
	@ManyToMany
	@JoinTable(name="portfolio_stock",
			joinColumns = @JoinColumn(name="portfolo_id"),
			inverseJoinColumns = @JoinColumn(name="stock_string"))
	private List<StockString> portfolioStingStocks;
	
	public Portfolio() {
		portfolioId = 0;
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
	public int getPortfolioId() {
		return portfolioId;
=======
	public List<StockString> getPortfolioStingStocks() {
		return portfolioStingStocks;
	}

	public void setPortfolioStingStocks(List<StockString> portfolioStingStocks) {
		this.portfolioStingStocks = portfolioStingStocks;
>>>>>>> 619ff788b8ff55624d19b9c66070ed89fcf47782
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", portfolioName=" + portfolioName + ", portfolioStingStocks="
				+ portfolioStingStocks + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(portfolioId, portfolioName, portfolioStingStocks);
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
		return portfolioId == other.portfolioId && Objects.equals(portfolioName, other.portfolioName)
				&& Objects.equals(portfolioStingStocks, other.portfolioStingStocks);
	}
	
	

	
	
}