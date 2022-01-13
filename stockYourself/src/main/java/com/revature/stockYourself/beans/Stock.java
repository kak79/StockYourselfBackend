package com.revature.stockYourself.beans;

import java.math.BigDecimal;
import java.util.Objects;

public class Stock {
	private String name;
	private BigDecimal price;
	private BigDecimal change;
	private String currency;
	private BigDecimal bid;
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
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
	
	
	public BigDecimal getBid() {
		return bid;
	}
	
	
	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(bid, change, currency, name, price);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(bid, other.bid) && Objects.equals(change, other.change)
				&& Objects.equals(currency, other.currency) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price);
	}


	@Override
	public String toString() {
		return "Stock [name=" + name + ", price=" + price + ", change=" + change + ", currency=" + currency + ", bid="
				+ bid + "]";
	}
	
	
	
}
