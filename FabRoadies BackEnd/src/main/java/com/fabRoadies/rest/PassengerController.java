package com.fabRoadies.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fabRoadies.entity.Passenger;
import com.fabRoadies.service.PassengerService;

/**
 * Reperesents Passenger Controller
 * @author Dhruv Marothi
 * @version 1.0
 */
@CrossOrigin
@RestController
public class PassengerController {
	
	@Autowired
	private PassengerService service;
	
	@GetMapping(value="/get/Passengers/{ticketId}",produces="application/json")
	public List<Passenger> getPassengerListByTicketId(@PathVariable("ticketId")Long ticketId){
		return service.getPassengerListByTicketId(ticketId);
	}

}
