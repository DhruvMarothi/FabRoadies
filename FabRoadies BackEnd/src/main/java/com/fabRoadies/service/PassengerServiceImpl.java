package com.fabRoadies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabRoadies.entity.Passenger;
import com.fabRoadies.repo.PassengerRepo;
import com.fabRoadies.repo.TicketRepo;

/**
 * Reperesents Passenger Service Implementation
 * @author Dhruv Marothi
 * @version 1.0
 */
@Service
public class PassengerServiceImpl implements PassengerService{

	@Autowired
	TicketRepo repo;
	@Autowired
	PassengerRepo prepo;
	
	@Override
	public List<Passenger> getPassengerListByTicketId(Long ticketId) {
		return repo.findById(ticketId).get().getPassenger();
	}

}
