package com.revature.stockYourself.exceptions;

public class NoPortfolioByStockException extends Exception {
	private static final long serialVersionUID = -6759532622186345519L;
	
	public NoPortfolioByStockException() {
		super("No portfolio by stock");
	}
}
