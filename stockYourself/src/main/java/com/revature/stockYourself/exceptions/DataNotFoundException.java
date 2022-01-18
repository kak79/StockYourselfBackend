package com.revature.stockYourself.exceptions;

public class DataNotFoundException extends Exception{
	private static final long serialVersionUID = -7675545193660758975L;
	
	public DataNotFoundException() {
		super("Data not found.");
	}
}
