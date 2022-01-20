package com.revature.stockYourself.exceptions;

public class PostEnteredWasNullException extends Exception{
	private static final long serialVersionUID = -5768890111177802133L;

	public PostEnteredWasNullException() {
		super("The post that was entered was null");
	}
}
