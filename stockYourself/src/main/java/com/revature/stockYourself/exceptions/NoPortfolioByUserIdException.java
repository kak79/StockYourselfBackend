package com.revature.stockYourself.exceptions;

public class NoPortfolioByUserIdException extends Exception{
	private static final long serialVersionUID = 6192321851606725943L;

	public NoPortfolioByUserIdException() {
		super("No Portfolio was found for the given userId");
	}
}
