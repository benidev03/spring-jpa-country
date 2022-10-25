package com.example.country.model;

import javax.persistence.Column;
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
	@Column(name = "region_id")
	private int regionID;
	
	private String name;
	
	
	@ManyToOne
	@JoinColumn(name = "continent_id", nullable = false)
	private Continent continent;


	public Integer getRegionID() {
		return regionID;
	}


	public void setRegionID(Integer regionID) {
		this.regionID = regionID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

}
