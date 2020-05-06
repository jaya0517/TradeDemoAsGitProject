package com.dbInterview.TradeDemo.exception;

public class ErrorResponse {

	String message;
	int httpCode;
	String httpStatus;
	
	public ErrorResponse() {
	
	}
	
	public ErrorResponse(String message, int httpCode, String httpStatus) {
		super();
		this.message = message;
		this.httpCode = httpCode;
		this.httpStatus = httpStatus;
	}
	
	
	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	
	
	
	
}
