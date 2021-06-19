
package com.fabRoadies.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Passenger {
	   @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    private String seatno;
	    
	    private String name;
	    private String gender;
	    private int age;
	    
		@JsonBackReference
		@ManyToOne
		@JoinColumn(name="ticket_id")
		private Ticket ticket;
	    
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getSeatno() {
			return seatno;
		}
		public void setSeatno(String seatno) {
			this.seatno = seatno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Ticket getTicket() {
			return ticket;
		}
		public void setTicket(Ticket ticket) {
			this.ticket = ticket;
		}
	   
	    
}
