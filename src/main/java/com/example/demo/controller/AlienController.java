package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController
{
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	@GetMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home.jsp";
	}
	@PostMapping("/addAlien")   ///for sending raw data use @RequestBody Alien alien
	public Alien addAliensPost(Alien alien)
	{
		repo.save(alien);
		return alien;
	}
	@DeleteMapping("/addAlien/{aid}")   ///for sending raw data use @RequestBody Alien alien
	public String delAlien(@PathVariable int aid)
	{
		Alien alien=repo.getReferenceById(aid);
		System.out.println("hello");
		System.out.println(alien);
		repo.delete(alien);
		
		return "deleted";
	}
	@PutMapping(path="/alien")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv=new ModelAndView("fetch.jsp");
		Alien alien=repo.findById(aid).orElse(new Alien());
//		System.out.println(repo.findAll());
//		List<Alien> lists=repo.findByAname("Navin");
//		System.out.println(lists);
//		System.out.println(repo.findByAidGreaterThan(100));
		mv.addObject(alien);
		return mv;
	}	
	@RequestMapping(path="/Aliens")
	@ResponseBody
	public List<Alien> getAliens()
	{
		
		return repo.findAll();
	}
	@RequestMapping("/Aliens/{aid}")
	@ResponseBody
	public Optional<Alien> getAlienByAid(@PathVariable("aid") int aid)
	{
		return repo.findById(aid);
		
	}
}