package com.fabRoadies.entity;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/** 
 * @author Pratik 
 * @version 1.0
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    private String name;
    private String phoneNumber;
    ////////////////
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="roll_id")
	private Roles roll;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {

		Decoder decoder = Base64.getDecoder();
		String passwords = new String(decoder.decode(this.password.getBytes()));
		return passwords;
	}
	public void setPassword(String password) {
		Encoder encoder = Base64.getEncoder();
		String passwords = encoder.encodeToString(password.getBytes());
		//System.out.println(encodedPassword);
		this.password = passwords;
	}
	
	public Roles getRoll() {
		return roll;
	}
	public void setRoll(Roles roll) {
		this.roll = roll;
	}
}
