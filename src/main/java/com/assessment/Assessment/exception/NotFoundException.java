package com.assessment.Assessment.exception;

public class NotFoundException extends RuntimeException{ 

	public NotFoundException() {
		super("Entity not exists.");
	}
	
	public NotFoundException(String message) {
		super(message);
	}
}
