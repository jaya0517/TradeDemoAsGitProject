package com.dbInterview.TradeDemo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		System.out.println("in ExceptionInternal Not supported");
		String errorMessage =  ex.getMessage();
		int httpCode = HttpStatus.BAD_REQUEST.value();
		String httpStatusCode = HttpStatus.BAD_REQUEST.name();
		
		ErrorResponse errorResponse = new ErrorResponse(errorMessage, httpCode, httpStatusCode);
		 return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		System.out.println("in MethodArgumentNot Valid Not supported");
		String errorMessage =  ex.getBindingResult().getFieldError().getDefaultMessage();
		int httpCode = HttpStatus.BAD_REQUEST.value();
		String httpStatusCode = HttpStatus.BAD_REQUEST.name();
		
		ErrorResponse errorResponse = new ErrorResponse(errorMessage, httpCode, httpStatusCode);
		
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		System.out.println("in Handler Not foumd");
		String errorMessage =  ex.getMessage();
		int httpCode = HttpStatus.BAD_REQUEST.value();
		String httpStatusCode = HttpStatus.BAD_REQUEST.name();
		
		ErrorResponse errorResponse = new ErrorResponse(errorMessage, httpCode, httpStatusCode);
		 return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		System.out.println("in method Not supported");
		String errorMessage =  ex.getMessage();
		int httpCode = HttpStatus.BAD_REQUEST.value();
		String httpStatusCode = HttpStatus.BAD_REQUEST.name();
		
		ErrorResponse errorResponse = new ErrorResponse(errorMessage, httpCode, httpStatusCode);
		 return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
