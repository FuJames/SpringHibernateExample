package com.datayes.paas.authorization.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author qianzhong.fu
 *
 */
@Entity
@Table(name="feature")
public class Feature  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "feature_id", unique = true, nullable = false)
	private long id;
	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="app_id")
	@JsonBackReference
	private Application app;
	@Column(name = "name", nullable = false)
	private String name;
//	@Column(name = "ch_name", nullable = false)
//	private String chName;
	@Column(name = "method", nullable = false)
	private String method;
	@Column(name = "url", nullable = false)
	private String url;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Application getApp() {
		return app;
	}
	public void setApp(Application app) {
		this.app = app;
	}
}
