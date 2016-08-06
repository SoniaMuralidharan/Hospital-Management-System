package com.hms.exceptions;

import java.util.List;

public class HmsBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HmsBusinessException() {
		// TODO Auto-generated constructor stub
	}

	private List<String> errorList;

	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	public HmsBusinessException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HmsBusinessException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public HmsBusinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HmsBusinessException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
