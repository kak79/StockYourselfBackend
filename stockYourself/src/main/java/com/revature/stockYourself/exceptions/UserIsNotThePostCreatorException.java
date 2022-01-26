package com.revature.stockYourself.exceptions;

public class UserIsNotThePostCreatorException extends Exception{
	private static final long serialVersionUID = 3938335835044290223L;
	
	public UserIsNotThePostCreatorException() {
		super("The user is not the creator of this post");
	}

}
