package org.lee.spring.hibernate.model;

@SuppressWarnings("serial")
public class LibException extends RuntimeException {

	public LibException() {
		super();
	}

	public LibException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public LibException(String message, Throwable cause) {
		super(message, cause);
	}

	public LibException(String message) {
		super(message);
	}

	public LibException(Throwable cause) {
		super(cause);
	}

}
