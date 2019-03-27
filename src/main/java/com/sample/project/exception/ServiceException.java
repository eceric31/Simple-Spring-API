package com.sample.project.exception;

/**
 * A generic exception for services.
 */
public class ServiceException extends Exception {
	/**
	 * Constructor with error message.
	 *
	 * @param message error message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * Constructor with another exception.
	 *
	 * @param throwable other exception
	 */
	public ServiceException(Throwable throwable) {
		super(throwable);
	}


	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
