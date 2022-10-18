package com.example.country.model;

import java.time.LocalDate;

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
	private Integer country_id;
	
	private String name;
	private float area;
	private LocalDate national_day;
	private char country_code2;
	private char country_code3;
	
	
	@ManyToOne
	@JoinColumn(name = "region_id", nullable = false)
	private Country region;
	
	
	
	
	public Integer getCountry_id() {
		return country_id;
	}
	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
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
	public LocalDate getNational_day() {
		return national_day;
	}
	public void setNational_day(LocalDate national_day) {
		this.national_day = national_day;
	}
	public char getCountry_code2() {
		return country_code2;
	}
	public void setCountry_code2(char country_code2) {
		this.country_code2 = country_code2;
	}
	public char getCountry_code3() {
		return country_code3;
	}
	public void setCountry_code3(char country_code3) {
		this.country_code3 = country_code3;
	}

	
	
}
