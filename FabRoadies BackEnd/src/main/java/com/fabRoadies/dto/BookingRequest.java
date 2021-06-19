package com.fabRoadies.dto;

import java.time.LocalDate;

/**
 * Reperesents Booking request entity encountered when ticket is booked.
 * @author Shailendra
 * @version 1.0
 */
public class BookingRequest {
	private int userid;
	private String seatno;
    private String busno;
    private String name;
    private String gender;
    private int age;
    private String email;
    private String phone;
//    private LocalDate reservationDate;
    
    
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getSeatno() {
		return seatno;
	}
	public void setSeatno(String seatno) {
		this.seatno = seatno;
	}
	public String getBusno() {
		return busno;
	}
	public void setBusno(String busno) {
		this.busno = busno;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    




}
