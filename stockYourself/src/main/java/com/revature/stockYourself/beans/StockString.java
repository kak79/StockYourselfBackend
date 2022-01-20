package com.revature.stockYourself.beans;import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="stock_string")
public class StockString {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockStringId;
	private String stockString;
	
	public StockString() {
		stockStringId = 0;
		stockString = " ";
	}
	
	public int getStockStringId() {
		return stockStringId;
	}
	
	
	public void setStockStringId(int stockStringId) {
		this.stockStringId = stockStringId;
	}
	
	
	public String getStockString() {
		return stockString;
	}
	
	
	public void setStockString(String stockString) {
		this.stockString = stockString;
	}
	
	
	@Override
	public String toString() {
		return "stockString [stockStringId=" + stockStringId + ", stockString=" + stockString + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(stockString, stockStringId);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockString other = (StockString) obj;
		return Objects.equals(stockString, other.stockString) && stockStringId == other.stockStringId;
	}
	
}