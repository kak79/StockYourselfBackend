package com.revature.stockYourself.beans;

import java.util.Objects;

public class Portfolio {

	private int portfolioId;
	
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
