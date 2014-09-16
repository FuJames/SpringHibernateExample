package com.datayes.paas.authorization.model;

import java.io.Serializable;

/**
 * @author qianzhong.fu
 *
 */
public class NameFamily implements Serializable{
	private static final long serialVersionUID = 1L;
	private String enName;
	private String chName;
	public NameFamily(){
	}
	public NameFamily(String enName, String chName) {
		super();
		this.enName = enName;
		this.chName = chName;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
}
