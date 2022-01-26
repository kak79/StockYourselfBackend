package com.revature.stockYourself.exceptions;

public class PortfolioIdUserIdConflictException extends Exception {
	private static final long serialVersionUID = 8636155846678413830L;

	public PortfolioIdUserIdConflictException() {
		super("Portfolio id and user id conflict.");
	}
}
