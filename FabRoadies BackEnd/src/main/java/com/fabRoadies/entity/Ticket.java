package com.fabRoadies.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

/**
 * Reperesents Ticket entity
 * @author Dhruv Marothi
 * @version 1.0
 */
@Entity
public class Ticket {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;  
    ///////////////////////////
	@ManyToOne
	@JsonBackReference
    @JoinColumn(name="bus_id")
    private Bus bus;
	////////////////////////////
	@NotNull
    private double price;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate reservationDate;
    /////////////////////////
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User user;
    //////////////////////////
    @OneToMany(mappedBy="ticket")
    private List<Passenger> passenger;
    
    private boolean booked=true;

    
    //Getters and Setters
    public long getTicketId() {
		return ticketId;
	}
	public void setTicketId(long ticketId) {
		this.ticketId = ticketId;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
    public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate localDate) {
		this.reservationDate = localDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}
	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

}
