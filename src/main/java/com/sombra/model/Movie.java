package com.sombra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "movie")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Movie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="director")
	private String director;

	public Movie() {
		super();
	}

	public Movie(int id, String title, String director) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
	
}
