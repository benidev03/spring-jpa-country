package com.example.country.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.country.model.Continent;
import com.example.country.model.Country;
import com.example.country.model.Region;
import com.example.country.repository.ContinentRepository;
import com.example.country.repository.CountryRepository;

@RestController
@RequestMapping("/world")
public class ContinentController {
	
	@Autowired
	private ContinentRepository continentRepository;
	
	
	@GetMapping("/continents")
	public List<Continent> getRegions(){
		
		return  (List<Continent>) continentRepository.findAll();
		
	}
	
	@GetMapping("/continents/{continentId}")  
	public ResponseEntity<Continent> getRegionById(@PathVariable(value = "continentId") int continentId) {
		
		Optional<Continent> c = continentRepository.findById(continentId);
		
		if (c.isPresent())
			
			return new ResponseEntity<Continent> (c.get(), HttpStatus.OK);		//ritorno l'istanza di region
		else
			return new ResponseEntity<Continent> ((Continent) null, HttpStatus.NOT_FOUND); //ritorno l'oggetto vuoto
	}

}
