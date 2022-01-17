package com.revature.stockYourself.exceptions;

public class NoPortfolioByUsernameException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public NoPortfolioByUsernameException() {
		super("No Portfolio was found for the given username");
	}

}
