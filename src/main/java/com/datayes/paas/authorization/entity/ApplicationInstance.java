package com.datayes.paas.authorization.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * @author qianzhong.fu
 *
 */
@Entity
@Table(name="app_instance")
public class ApplicationInstance implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="instance_id",nullable=false,unique=true)
	private long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name="app_id",nullable=false)
	private long appId;
	@Column(name="tenant_domain",nullable=true)
	private String tenantDomain;
	
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
	public long getAppId() {
		return appId;
	}
	public void setAppId(long appId) {
		this.appId = appId;
	}
	public String getTenantDomain() {
		return tenantDomain;
	}
	public void setTenantDomain(String tenantDomain) {
		this.tenantDomain = tenantDomain;
	}
	
}
