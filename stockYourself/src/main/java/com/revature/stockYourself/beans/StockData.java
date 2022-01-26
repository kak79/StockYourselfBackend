package com.revature.stockYourself.beans;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class StockData {
	private String name;
	
	private String stocksymbol;
	private BigDecimal price;
	private BigDecimal change;
	private String currency;
	
	
	


	public StockData(String name, BigDecimal price, BigDecimal change, String currency) {
		super();
		this.name = name;
		this.price = price;
		this.change = change;
		this.currency = currency;
	}


	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public String getStocksymbol() {
		return stocksymbol;
	}


	public void setStocksymbol(String stocksymbol) {
		this.stocksymbol = stocksymbol;
	}


	public BigDecimal getPrice() {
		return price;
	}
	
	
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
	public BigDecimal getChange() {
		return change;
	}
	
	
	public void setChange(BigDecimal change) {
		this.change = change;
	}
	
	
	public String getCurrency() {
		return currency;
	}
	
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((change == null) ? 0 : change.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((stocksymbol == null) ? 0 : stocksymbol.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockData other = (StockData) obj;
		if (change == null) {
			if (other.change != null)
				return false;
		} else if (!change.equals(other.change))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (stocksymbol == null) {
			if (other.stocksymbol != null)
				return false;
		} else if (!stocksymbol.equals(other.stocksymbol))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "StockData [name=" + name + ", stocksymbol=" + stocksymbol + ", price=" + price + ", change=" + change
				+ ", currency=" + currency + "]";
	}


	
	
	
	
}
