/*
 * Copyright (c) 2016. Bond(China)
 */

package com.huajun56.common.exception;

public class SystemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7861491757330299666L;

	public SystemException(String msg, Exception e) {
		super(msg, e);
	}
}
