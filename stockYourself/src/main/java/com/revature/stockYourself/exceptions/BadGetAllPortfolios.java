package com.revature.stockYourself.exceptions;

public class BadGetAllPortfolios extends Exception {
	private static final long serialVersionUID = 19419037348933032L;

	public BadGetAllPortfolios() {
		super("Could not gell all user portfolios");
		
	}
}
