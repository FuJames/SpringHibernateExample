package com.datayes.paas.authorization.model.db;

import java.io.Serializable;

public class TreeNode implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	public TreeNode(){}
	public TreeNode(long id,String name){
		this.id = id;
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
