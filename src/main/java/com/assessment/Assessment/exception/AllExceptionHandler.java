package com.assessment.Assessment.exception;

import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException ex) {
		HashMap<String, String> map =  new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("status", String.valueOf(HttpStatus.NOT_FOUND));
		ResponseEntity<Map<String, String>> resp = new ResponseEntity<Map<String,String>>(map, HttpStatus.NOT_FOUND);
		return resp;
	}
	
	
	@ExceptionHandler(DateTimeParseException.class)
	public ResponseEntity<Map<String, String>> handleDateTimeParseException(DateTimeParseException ex) {
		HashMap<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
		ResponseEntity<Map<String, String>> resp = new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
		return resp;
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException ex) {
		HashMap<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("status", String.valueOf(HttpStatus.BAD_REQUEST));
		ResponseEntity<Map<String, String>> resp = new ResponseEntity<Map<String,String>>(map, HttpStatus.BAD_REQUEST);
		return resp;
	}
}
