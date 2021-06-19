package com.fabRoadies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fabRoadies.entity.Passenger;

/**
 * Reperesents Passenger Service
 * @author Dhruv Marothi
 * @version 1.0
 */
@Service
public interface PassengerService {
	
	List<Passenger> getPassengerListByTicketId(Long ticketId);
}
