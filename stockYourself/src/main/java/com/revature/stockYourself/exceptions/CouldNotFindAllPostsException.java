package com.revature.stockYourself.exceptions;

public class CouldNotFindAllPostsException extends Exception{
	private static final long serialVersionUID = -1858211160890566365L;

	public CouldNotFindAllPostsException() {
		super("Could not find all posts.");
	}
}
