package com.datayes.paas.authorization.exception;

public class PermissionException extends Exception{
	private static final long serialVersionUID = 1L;
	private int statusCode;
	private String message;
	public PermissionException(){}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PermissionException(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
}
