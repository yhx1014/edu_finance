package com.edu.finance.framework.exception;

/**
 * 基础不受检异常
 * 
 *
 */
public class BaseRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BaseRuntimeException() {
	}

	public BaseRuntimeException(String message) {
		super(message);
	}

	public BaseRuntimeException(Throwable cause) {
		super(cause);
	}

	public BaseRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseRuntimeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
