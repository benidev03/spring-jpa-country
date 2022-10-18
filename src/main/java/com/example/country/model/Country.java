package com.example.country.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "countries")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer countryId;
	
	private String name;
	private float area;
	
	@Column(name = "national_day")
	private LocalDate nationalDay;
	
	@Column(name = "country_code2")
	private char countryCode2;
	
	@Column(name = "country_code3")
	private char countryCode3;
	
	
	@ManyToOne
	@JoinColumn(name = "region_id", nullable = false)
	private Region region;


	public Integer getCountryId() {
		return countryId;
	}


	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getArea() {
		return area;
	}


	public void setArea(float area) {
		this.area = area;
	}


	public LocalDate getNationalDay() {
		return nationalDay;
	}


	public void setNationalDay(LocalDate nationalDay) {
		this.nationalDay = nationalDay;
	}


	public char getCountryCode2() {
		return countryCode2;
	}


	public void setCountryCode2(char countryCode2) {
		this.countryCode2 = countryCode2;
	}


	public char getCountryCode3() {
		return countryCode3;
	}


	public void setCountryCode3(char countryCode3) {
		this.countryCode3 = countryCode3;
	}


	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}
	
	
	
	
	

	
	
}
