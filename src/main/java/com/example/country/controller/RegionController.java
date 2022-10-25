package com.example.country.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.country.model.Continent;
import com.example.country.model.Country;
import com.example.country.model.Region;
import com.example.country.repository.ContinentRepository;
import com.example.country.repository.RegionRepository;

@RestController
@RequestMapping("/world")
public class RegionController {
	
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private ContinentRepository continentRepository;
	
	
	@GetMapping("/regions")
	public List<Region> getRegions(){
		
		return  (List<Region>) regionRepository.findAll();
		
	}
	
	@GetMapping("/regions/{regionId}")  
	public ResponseEntity<Region> getRegionById(@PathVariable(value = "regionId") int regionId) {
		
		Optional<Region> r = regionRepository.findById(regionId);
		
		if (r.isPresent())
			
			return new ResponseEntity<Region> (r.get(), HttpStatus.OK);	//ritorno l'istanza di region
		else
			return new ResponseEntity<Region> ((Region) null, HttpStatus.NOT_FOUND); //ritorno l'oggetto vuoto
	}
	
	@GetMapping("/regionbycontinent/{continentId}") 
	public List<Region> getRegionByContinent(@PathVariable(value = "continentId") int continentId){
		
		Optional<Continent> c = continentRepository.findById(continentId);
		
		if(c.isPresent()) {
			
			return (List<Region>) regionRepository.findByContinent(c.get());
		}else {
			
			return null;
		}
		
		
		
	}

}
