package com.shr.exception;

public abstract class AbstractException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void message(ErrorEnum ee){
		System.out.println(ee.getMessage() + "-" + ee.getCode());
	}
	
	
}
