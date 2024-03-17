package com.linkedlist.common;

public class EmptyLinkedListException extends RuntimeException {

	private static final long serialVersionUID = -5489810075462667740L;

	public EmptyLinkedListException() {
		super();		
	}
	
	public EmptyLinkedListException(String message) {
		super(message);		
	}
}
