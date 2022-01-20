package com.revature.stockYourself.exceptions;

public class CreatorWasNullException extends Exception{
	private static final long serialVersionUID = 7830155036364332323L;

	public CreatorWasNullException() {
		super("User Creator that was entered was null");
	}
}
