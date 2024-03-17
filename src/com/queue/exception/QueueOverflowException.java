package com.queue.exception;

public class QueueOverflowException extends RuntimeException {

	private static final long serialVersionUID = -8782339822110576764L;
	
	public QueueOverflowException(String message) {
		super(message);
	}

}
