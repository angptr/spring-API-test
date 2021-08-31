package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
public class FlowerController {
	
	private FlowerService service;
	
//	to get list of flowers
	@GetMapping("/flowers")
	public List<Flower> getAll() {
		return service.getAllFlowers();
	}
	
//	to save flower after add
	@PostMapping("/flowers")
	public Flower saveFlower(@RequestBody Flower flower) {
		return service.save(flower);
	}

//	to get flower by id
	@GetMapping("/flowers/{id}")
	public Flower getFlowerById(@PathVariable("id") Long id, Model model) {
		return service.getFlowerById(id);
	}
	
//	to delete flower
	@DeleteMapping("/flowers/{id}")
	public void deleteFlowerById(@PathVariable("id") Long id) {
		service.deleteFlower(id);
	}
	
//	to update flower
	@PutMapping("/flowers/{id}")
	public Flower updateFlowerById(@RequestBody Flower flower, @PathVariable("id") Long id) {		
		return service.updateFlower(id, flower);
	}
	
}
