package com.datayes.paas.authorization.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author qianzhong.fu
 *
 */
@Entity
@Table(name="application")
public class Application implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "app_id", unique = true, nullable = false)
	private long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "version", nullable = false)
	private String version;
	@OneToMany(cascade = CascadeType.ALL,mappedBy="app")
	@JsonManagedReference
	private Set<Feature> features;
	
	public Set<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
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
