package com.revature.stockYourself.exceptions;

public class StockListWasEmptyException extends Exception {
	private static final long serialVersionUID = 3211257287736921707L;

	public StockListWasEmptyException() {
		super("Stock List was empty.");
	}
}
