package com.api.application.runner;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.api.application.document.Planet;
import com.api.application.service.PlanetService;

//@Component
//@Transactional
public class Runner implements CommandLineRunner {
	
	@Autowired
	private PlanetService planetService;
	
	private static Logger LOGGER = Logger.getLogger(Runner.class.getName());	
	@Override
	public void run(String... args) throws Exception {
		
		LOGGER.info("Executando o runner para inclusao no banco de dados");
		
		Planet planet = new Planet();
		planet.setId(UUID.randomUUID().toString());
		planet.setClima("Equatorial");
		planet.setNome("BOTPLAB");
		planet.setTerreno("Argiloso");
		
		planetService.save(planet);
		
		LOGGER.info("Salvo com sucesso!");
		
	}

}
