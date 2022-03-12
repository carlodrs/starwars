package com.api.application.document;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Classe document que abstrai o retornado da Django Starwars API
 * @author carlos silva
 * @since 2022
 * @version 1.0
 * @see Planet
 * */
@Document
public class StarWarsPlanet{
	
	private String name;
	private String rotation_period;
	private String orbital_period; 
	private String diameter; 
	private String climate;
	private String gravity; 
	private String terrain; 
	private String surface_water;
	private String population; 
	private String[] residents;
	private String[] films;
	private Date created; 
	private Date edited; 
	private String url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRotation_period() {
		return rotation_period;
	}
	public void setRotation_period(String rotation_period) {
		this.rotation_period = rotation_period;
	}
	public String getOrbital_period() {
		return orbital_period;
	}
	public void setOrbital_period(String orbital_period) {
		this.orbital_period = orbital_period;
	}
	public String getDiameter() {
		return diameter;
	}
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getGravity() {
		return gravity;
	}
	public void setGravity(String gravity) {
		this.gravity = gravity;
	}
	public String getTerrain() {
		return terrain;
	}
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	public String getSurface_water() {
		return surface_water;
	}
	public void setSurface_water(String surface_water) {
		this.surface_water = surface_water;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public String[] getResidents() {
		return residents;
	}
	public void setResidents(String[] residents) {
		this.residents = residents;
	}
	public String[] getFilms() {
		return films;
	}
	public void setFilms(String[] films) {
		this.films = films;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getEdited() {
		return edited;
	}
	public void setEdited(Date edited) {
		this.edited = edited;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
	