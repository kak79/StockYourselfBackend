package com.revature.stockYourself.beans;import java.util.List;
import java.util.Objects;import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;@Entity
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int portfolioId;
	// private double points;
	@ManyToMany
	@JoinTable(name="portfolio_stock",
			joinColumns = @JoinColumn(name="portfolo_id"),
			inverseJoinColumns = @JoinColumn(name="stock_string"))
	private List<String> portfolioStingStocks;
	
	public Portfolio() {
		portfolioId = 0;
	}	
	
	public int getPortfolioId() {
		return portfolioId;
	}	
	
	public void setPortfolioId(int portfolioId) {
		this.portfolioId = portfolioId;
	}	
	
	@Override
	public String toString() {
		return "Portfolio [portfolioId=" + portfolioId + "]";
	}	
	
	@Override
	public int hashCode() {
		return Objects.hash(portfolioId);
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
		return portfolioId == other.portfolioId;
	}
	
	
	
}