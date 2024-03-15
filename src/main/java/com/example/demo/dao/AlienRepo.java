package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alien;

//public interface AlienRepo extends CrudRepository<Alien, Integer>{
//	
//	
//	//customised query
//	//method name should start with findBy,followed by exact property name,  
//	List<Alien>  findByAname(String aname);
//	
//	List<Alien> findByAidGreaterThan(int aid);
//	
////	@Query("from Alien where aname=?1 order by aname")
////	List<Alien> findByAnameSorted(String aname);
//}
public interface AlienRepo extends JpaRepository<Alien, Integer>{
	
	
	//customised query
	//method name should start with findBy,followed by exact property name,  
	List<Alien>  findByAname(String aname);
	
	List<Alien> findByAidGreaterThan(int aid);
	
//	@Query("from Alien where aname=?1 order by aname")
//	List<Alien> findByAnameSorted(String aname);
}
