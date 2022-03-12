package com.api.application.service;

import java.util.Arrays;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.application.document.GlobalResult;
import com.api.application.document.Planet;
import com.api.application.document.StarWarsPlanet;
import com.api.application.repository.PlanetRepository;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service responsavel por executar os servicos da aplicacao
 * @author carlos silva
 * @since 2002
 * @version 1.0
 * */
@Service
public class PlanetService {
	
	@Value("${django.starwars.endpoint}")
	private String endpoint;

	@Autowired
	private PlanetRepository planetRepository;
	
	/**
	 * Salvas as informacoes na base de dados
	 * @param planet
	 * @return 
	 * @return void
	 * */
	public Disposable save (Planet planet){
		planet.setId(UUID.randomUUID().toString());
		return planetRepository.save(planet).subscribe();
	}
	
	
	/**
	 * Busca o dado individual do banco
	 * @param id
	 * @return Mono
	 * */
	public Mono<Planet> findBy(String id){
		return planetRepository.findById(id);
	}
	
	/**
	 * Listar todas informacoes da base
	 * @return Flux
	 * */
	public Flux<Planet> findAll(){
		return planetRepository.findAll();
	}
	

	/**
	 * Pesquisar pelo nome de planetas
	 * @param planetName
	 * @return Flux
	 * */
	public Flux<Planet> searchByName(String planetName){
		return planetRepository.findByNome(planetName);
	}
	
	
	/** 
	 * Metodo para realizar a exclusao do planeta
	 * @param id
	 * @return 
	 * @return Mono
	 */
	public void delete(String id) {
		planetRepository.deleteById(id).subscribe();
	}

	/** 
	 * Metodo para recuperar os planetas da api django e inclui-los na base de dados
	 * @param page 
	 * @return void
	 */
	
	public void populate(Integer page) {
		
		
		//AQUI RECUPERA-SE VIA REST TEMPLATE A CHAMADA EXTERNA	
		
		ResponseEntity<?> response = null;
		RestTemplate rest = getRestTemplate();
	
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<GlobalResult> entity = new HttpEntity<GlobalResult>(null, httpHeaders);

		String url = endpoint + "/planets"; 
		response = rest.exchange(url, HttpMethod.GET, entity, GlobalResult.class);
		GlobalResult result = (GlobalResult)response.getBody();
		
		// AQUI IREMO POPULAR A BASE DE DADOS COM OS DADOS VINDOS DA API
		for (StarWarsPlanet p : result.getResults())
			this.save(this.retrievePlanet(
							p.getName(), 	
							p.getClimate(), 	
							p.getTerrain(),
							p.getFilms().length));
	}

	
	/** Metodo responsavel por criar o objeto planeta que vai para base de dados
	 *  @param name
	 *	@param cimate
	 *	@param terrain
	 *  @param id
	 *  @return Planet
	 */
	private Planet retrievePlanet(String name, String climate, String terrain, Integer films) {
		// TODO Auto-generated method stub
		return new Planet(UUID.randomUUID().toString(), name, climate, terrain, films);
	}
	
	
	/**
	 * Rest template para chamada externa
	 * @return RestTemplate
	 * */
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(10000);
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		return restTemplate;

	}
}
