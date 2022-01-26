package com.revature.stockYourself.exceptions;

public class PostAndOrUserWasNull extends Exception{
	private static final long serialVersionUID = -8477614693365474361L;
	
	public PostAndOrUserWasNull() {
		super("Entered post and/or user was null");
	}

}
