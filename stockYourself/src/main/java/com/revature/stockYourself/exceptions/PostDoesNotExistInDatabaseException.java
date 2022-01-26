package com.revature.stockYourself.exceptions;

public class PostDoesNotExistInDatabaseException extends Exception{
	private static final long serialVersionUID = 815908087840635724L;

	public PostDoesNotExistInDatabaseException() {
		super("That post does not exists in the database");
	}
}
