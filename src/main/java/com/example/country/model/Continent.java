package com.example.country.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "continents")
public class Continent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "continent_id")
	private Integer continentId;
	
	private String name;

	
	
	public Integer getContinentId() {
		return continentId;
	}

	public void setContinentId(Integer continentId) {
		this.continentId = continentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

	
}
