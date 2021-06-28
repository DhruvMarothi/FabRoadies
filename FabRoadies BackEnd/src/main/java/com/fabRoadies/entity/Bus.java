package com.fabRoadies.entity;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Shailendra 
 * @version 1.0
 */
@Entity
public class Bus {

    @Id
    private String busno;
    private String agency;
    private String busType;
    private String departureCity;
    private String arrivalCity;
//    @Temporal(TemporalType.DATE)
	private LocalDate dateOfDeparture;
	private int price;
	private int seats;
	
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="HH:mm", timezone = "UTC")
    @Temporal(TemporalType.TIME)
    private Date departuretime;
    
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBusno() {
		return busno;
	}
	public void setBusno(String busno) {
		this.busno = busno;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departurecity) {
		this.departureCity = departurecity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalcity) {
		this.arrivalCity = arrivalcity;
	}	
	public LocalDate getDateOfDeparture() {
		return dateOfDeparture;
	}
	public void setDateOfDeparture(LocalDate dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}
	public Date getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(Date departuretime) {
		this.departuretime = departuretime;
	}
	
	
	///////////////
	
//	public List<Ticket> getTickets() {
//		return tickets;
//	}
//	public void setTickets(List<Ticket> tickets) {
//		this.tickets = tickets;
//	}  
//	
    
    
    
}