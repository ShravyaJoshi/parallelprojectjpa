package com.cg.mpw.exception;

public class InsufficientBalException extends RuntimeException{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientBalException(String msg){
		super(msg);
	}
}
