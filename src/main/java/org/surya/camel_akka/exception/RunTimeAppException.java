package org.surya.camel_akka.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunTimeAppException extends RuntimeException {
	protected transient Logger log = LoggerFactory.getLogger(getClass());

	private static final long serialVersionUID = 7636472896525772984L;

	public RunTimeAppException() {
	}

	public RunTimeAppException(String message) {
		super(message);
	}

	public RunTimeAppException(String message, Throwable cause) {
		super(message, cause);
		log.info(message, cause);
	}

	public RunTimeAppException(Throwable cause) {
		super(cause);
	}
}