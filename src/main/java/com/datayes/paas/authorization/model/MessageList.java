package com.datayes.paas.authorization.model;

import java.util.List;

/**
 * @author qianzhong.fu
 *
 */
public class MessageList extends Message{
	private static final long serialVersionUID = 1L;
	private List<String> entities;
	public List<String> getEntities() {
		return entities;
	}
	public void setEntities(List<String> entities) {
		this.entities = entities;
	}
	public MessageList() {
	}
	public MessageList(int statusCode, String message) {
		super(statusCode, message);
	}
	public MessageList(int statusCode, String message,List<String> entities) {
		super(statusCode, message);
		this.entities = entities;
	}
	
}
