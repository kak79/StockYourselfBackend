package com.revature.stockYourself.exceptions;

public class NoPortfolioByUserException extends Exception {
	private static final long serialVersionUID = 2417327565222929423L;
	
	public NoPortfolioByUserException( ) {
		super("No portfolio by user.");
	}
}
