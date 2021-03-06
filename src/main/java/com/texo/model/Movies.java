package com.texo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movies {

	@Id
	public long id;
	public Date year;
	public String title;
	public String  studios;
	public String producers;
	public boolean winner;
	
	
	public Movies() {
		
	}
	
	

	

	public Movies(Integer id, Date year, String title, String studios, String producers, boolean winner) {
		super();
		this.id = id;
		this.year = year;
		this.title = title;
		this.studios = studios;
		this.producers = producers;
		this.winner = winner;
	}





	public Long getId() {
		return id;
	}


	public void setId(long l) {
		this.id = l;
	}



	public Date getYear() {
		return year;
	}


	public void setYear(Date year) {
		this.year = year;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getStudios() {
		return studios;
	}


	public void setStudios(String studios) {
		this.studios = studios;
	}


	public String getProducers() {
		return producers;
	}


	public void setProducers(String producers) {
		this.producers = producers;
	}


	public boolean isWinner() {
		return winner;
	}


	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	
	
	
}
