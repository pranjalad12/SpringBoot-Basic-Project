package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{
	
	
	//customised query
	//method name should start with findBy,followed by exact property name,  
	List<Alien>  findByAname(String aname);
	
	List<Alien> findByAidGreaterThan(int aid);
}
