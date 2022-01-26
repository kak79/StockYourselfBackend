package com.revature.stockYourself.exceptions;

public class PortfolioEnteredWasNull extends Exception{
	private static final long serialVersionUID = -5788794041571239536L;

	public PortfolioEnteredWasNull() {
		super("The portfolio entered was null");
	}
}
