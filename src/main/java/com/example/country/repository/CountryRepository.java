package com.example.country.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.country.model.Continent;
import com.example.country.model.Country;
import com.example.country.model.Region;


@Repository
public interface CountryRepository extends CrudRepository<Country, Integer>{
	
	public List<Country> findByRegion(Region region);
}
