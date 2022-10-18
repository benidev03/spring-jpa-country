package com.example.country.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer region_id;
	
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name = "coninent_id", nullable = false)
	private Region continent;
	

	public Integer getRegion_id() {
		return region_id;
	}

	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
