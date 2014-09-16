package com.datayes.paas.authorization.model;

import java.io.Serializable;

/**
 * @author qianzhong.fu
 *
 */
public class UserPermission implements Serializable{

	private static final long serialVersionUID = 1L;
	private String tenantDomain;
	private String userName;
	private String instanceEnName;
	private String method;
	private String url;
	
	public String getTenantDomain() {
		return tenantDomain;
	}
	public void setTenantDomain(String tenantDomain) {
		this.tenantDomain = tenantDomain;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getInstanceEnName() {
		return instanceEnName;
	}
	public void setInstanceEnName(String instanceEnName) {
		this.instanceEnName = instanceEnName;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
