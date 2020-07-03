package com.shine2share.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hero {
	public Hero(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Hero() {
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
