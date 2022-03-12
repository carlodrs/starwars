package com.api.application.document;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GlobalResult {
	
	private Integer count;
	private String next;
    private String previous;
    private List<StarWarsPlanet> results;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<StarWarsPlanet> getResults() {
		return results;
	}
	public void setResults(List<StarWarsPlanet> results) {
		this.results = results;
	}
}
