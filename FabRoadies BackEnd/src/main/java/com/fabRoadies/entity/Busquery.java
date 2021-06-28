package com.fabRoadies.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/** 
 * @author Dhruv Marothi 
 * @version 1.0
 */
@Entity
public class Busquery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
	private String source;
    private String destination;
    private LocalDate dateOfDeparture;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateOfDeparture() {
		return dateOfDeparture;
	}
	public void setDateOfDeparture(LocalDate dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
}
