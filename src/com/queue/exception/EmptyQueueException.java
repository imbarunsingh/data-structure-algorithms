package com.queue.exception;

public class EmptyQueueException extends RuntimeException {

	private static final long serialVersionUID = -8782339822110576764L;
	
	public EmptyQueueException(String message) {
		super(message);
	}

}
