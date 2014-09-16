package com.datayes.paas.authorization.model;

import java.io.Serializable;

/**
 * @author qianzhong.fu
 *
 */
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	private int statusCode;
	private String message;
	public Message(){
	}
	public Message(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;	
	}
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
}
