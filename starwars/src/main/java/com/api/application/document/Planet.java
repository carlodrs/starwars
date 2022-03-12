package com.api.application.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * POJO que sera a classe responsavel por armazenar  e recuperar os dados contidos na collection
 * @see Document Documento armazenado na base
 * @since 2022  
 * @author carlos silva
 * @version 1.0
 */

@Document
public class Planet {
	
	
	public Planet() {
		// TODO Auto-generated constructor stub
	}
	
	public Planet(String id, String nome, String clima, String terreno, Integer filmes) {
		super();
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.filmes = filmes;
	}
	
	
	@Id
	private String id;
	
	private String nome, clima, terreno;
	
	private Integer filmes;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	
	public Integer getFilmes() {
		return filmes;
	}

	public void setFilmes(Integer filmes) {
		this.filmes = filmes;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getId() + " " + this.getNome();
	}
}
