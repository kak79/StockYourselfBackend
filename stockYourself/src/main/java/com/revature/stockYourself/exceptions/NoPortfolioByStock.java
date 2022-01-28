package com.revature.stockYourself.exceptions;

public class NoPortfolioByStock extends Exception {
	private static final long serialVersionUID = 7956600415917729130L;

	public NoPortfolioByStock() {
		super("No portflios were found containing that stock");
	}
}
