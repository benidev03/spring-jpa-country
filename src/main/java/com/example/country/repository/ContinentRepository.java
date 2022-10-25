package com.example.country.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.country.model.Continent;

@Repository
public interface ContinentRepository extends CrudRepository<Continent, Integer>{

}
