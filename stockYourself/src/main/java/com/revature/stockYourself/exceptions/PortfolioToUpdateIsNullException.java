package com.revature.stockYourself.exceptions;

public class PortfolioToUpdateIsNullException extends Exception {
	private static final long serialVersionUID = 2304685062052343064L;

	public PortfolioToUpdateIsNullException() {
		super("Portfolio to update is null");
	}
}
