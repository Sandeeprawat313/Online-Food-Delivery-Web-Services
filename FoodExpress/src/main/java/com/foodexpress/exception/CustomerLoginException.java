package com.foodexpress.exception;

public class CustomerLoginException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerLoginException() {
		
	}
	
	public CustomerLoginException(String message) {
		super(message);
	}
}
