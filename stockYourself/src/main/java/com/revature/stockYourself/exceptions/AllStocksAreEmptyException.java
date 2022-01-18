package com.revature.stockYourself.exceptions;

public class AllStocksAreEmptyException extends Exception {
	private static final long serialVersionUID = 8967547592904215569L;
	
	public AllStocksAreEmptyException( ) {
		super("All stocks are empty.");
	}
	
}
