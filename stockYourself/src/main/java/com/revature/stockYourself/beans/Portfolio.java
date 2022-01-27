package com.revature.stockYourself.beans;


import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
//import org.springframework.data.annotation.Id;



@Entity
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int portfolioId;
	private String portfolioName;
//	private List<StockString> portfolioStringStocks;
	public Portfolio() {
		portfolioId = 0;
		portfolioName = "";
//		portfolioStringStocks = new ArrayList<StockString>();
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
	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + ", portfolioName=" + portfolioName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(portfolioId, portfolioName);
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
		return portfolioId == other.portfolioId && Objects.equals(portfolioName, other.portfolioName);
	}
	
	
}









