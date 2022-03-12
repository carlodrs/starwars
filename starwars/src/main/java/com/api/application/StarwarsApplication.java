package com.api.application;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *  Classe principal - Application Class
 *  Ira carregar as classes necessarias para executar a aplicacao Rest
 *  @author carlos silva
 *  @since 2022
 * */

@SpringBootApplication
public class StarwarsApplication {
	
	private static Logger LOGGER  = Logger.getLogger(StarwarsApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(StarwarsApplication.class, args);
		LOGGER.info("Star Wars Webflux app carregado!!!!!");
	}
}
