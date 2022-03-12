package com.api.application.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.api.application.document.Planet;

import reactor.core.publisher.Flux;

/**
 * Interface utilizada para realizar as operacoes de banco
 * @see ReactiveMongoRepository
 * @author carlos silva
 * @version 1.0
 * */
public interface PlanetRepository extends ReactiveMongoRepository<Planet, String> {

	public Flux<Planet> findByNome(String planetName);

}
