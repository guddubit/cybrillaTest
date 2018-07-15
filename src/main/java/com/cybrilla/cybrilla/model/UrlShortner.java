package com.cybrilla.cybrilla.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UrlShortner {
	
	@Id
	@GeneratedValue
	private Long id;
	private String url;
	private String description;
	
	public UrlShortner() {}
	
	public UrlShortner(Long id, String url) {
		super();
		this.id = id;
		this.url = url;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
