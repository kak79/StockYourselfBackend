package com.revature.stockYourself.exceptions;

public class IncorrectCredentialsException extends Exception {
	private static final long serialVersionUID = -499641981696353283L;
	
	public IncorrectCredentialsException() {
			super("Username or password was incorrect.");
	}
}
