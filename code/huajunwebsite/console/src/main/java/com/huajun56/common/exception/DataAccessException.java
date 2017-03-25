/*
 * Copyright (c) 2015. Bond(China)
 */

package com.huajun56.common.exception;

public class DataAccessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -45615426235893009L;

	public DataAccessException(String msg, Exception e) {
		super(msg, e);
	}

}
