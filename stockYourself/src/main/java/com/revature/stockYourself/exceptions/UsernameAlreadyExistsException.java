package com.revature.stockYourself.exceptions;

public class UsernameAlreadyExistsException extends Exception {
	private static final long serialVersionUID = 7954396422108634125L;

	public UsernameAlreadyExistsException() {
			super("The chosen username is already used by another user.");
	}
}
