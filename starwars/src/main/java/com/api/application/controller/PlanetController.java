package com.api.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.application.document.Planet;
import com.api.application.service.PlanetService;

import reactor.core.publisher.Flux;

/**
 * Classe Controller que expoe as apis da aplicao.
 * @author carlos silva
 * @since 2022
 * @version 1.0
 * 
 * */
@RestController
public class PlanetController {

	@Autowired
	private PlanetService planetService;
	
	/** Listar todos os planetas
	 * @return Flux
	 */
	@GetMapping(value = "/getPlanets")
	public Flux<Planet> getPlanets(){
		return planetService.findAll();	
	}
	

	/** Listar pelo nome dos planetas
	 * @return Flux
	 */
	@GetMapping(value = "/getPlanetsByName/{name}")
	public Flux<Planet> getPlanetsByName (@PathVariable String name) {
		return planetService.searchByName(name);	
	}
	

	/** Excluindo o planeta
	 * @return Flux
	 */
	@DeleteMapping(value = "/delete/{id}")
	public void delete (@PathVariable String id) {
		 planetService.delete(id);	
	}
	


	/** Salvar o planeta na base de dados
	 * @return Flux
	 */
	@PostMapping(value="/save")
	public void save(@RequestBody Planet planet){
		planetService.save(planet);
	}
	
	/** List All planet from starwars Django API 
	 * @return Flux
	 */
	@PutMapping(value="/populate/{page}")
	public void populate(@PathVariable Integer page){
		planetService.populate(page);
	}
	
		
	
}
