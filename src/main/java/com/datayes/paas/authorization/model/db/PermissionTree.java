package com.datayes.paas.authorization.model.db;

import java.util.ArrayList;
import java.util.List;

public class PermissionTree {
	private long id;
	private String name;
	private List<TreeNode> features = new ArrayList<TreeNode>();
	public List<TreeNode> getFeatures() {
		return features;
	}
	public void setFeatures(List<TreeNode> features) {
		this.features = features;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
