package com.javacodegeeks.enterprise.ws;

public class InvalidInputException extends Exception{
	
	
	private String errorDetails;
	
	public InvalidInputException(String reason, String errorDetails)
	{
		super(reason);
	}
	
	public String getFaultInfo()
	{
		return errorDetails;
	}

}
