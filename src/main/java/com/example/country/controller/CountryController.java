package com.example.country.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.country.model.Continent;
import com.example.country.model.Country;
import com.example.country.model.Region;
import com.example.country.repository.ContinentRepository;
import com.example.country.repository.CountryRepository;
import com.example.country.repository.RegionRepository;

@RestController
@RequestMapping("/world")
public class CountryController {
	
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@GetMapping("/countries")
	public List<Country> getRegions(){
		
		return  (List<Country>) countryRepository.findAll();
		
	}
	
	//restituire una nazione dato il suo Id
	@GetMapping("/countries/{countryId}")  
	public ResponseEntity<Country> getCountryById(@PathVariable(value = "countryId") int countryId) {
		
		Optional<Country> c = countryRepository.findById(countryId);
		
		if (c.isPresent())
			
			return new ResponseEntity<Country> (c.get(), HttpStatus.OK);		//ritorno l'istanza di country
		else
			return new ResponseEntity<Country> ((Country) null, HttpStatus.NOT_FOUND); //ritorno l'oggetto vuoto
	}
	
	@GetMapping("/countrybyregion/{regionId}") 
	public List<Country> getCountryByRegion(@PathVariable(value = "regionId") int regionId){
		
		Optional<Region> c = regionRepository.findById(regionId);
		
		if(c.isPresent()) {
			
			return (List<Country>) countryRepository.findByRegion(c.get());
		}else {
			
			return null;
		}
	}
	
	//inserire una nuova nazione
	@PostMapping()
	public ResponseEntity<Country> insertCountry(@RequestBody Country country) {
		
		return new ResponseEntity<Country>(countryRepository.save(country), HttpStatus.CREATED);
	}

}
