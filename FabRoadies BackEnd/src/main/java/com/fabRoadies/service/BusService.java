package com.fabRoadies.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fabRoadies.entity.Bus;

/**
 * Service interface for Bus
 * @author Dhruv Marothi
 *@version 1.0
 */
@Service
public interface BusService {
	
	void save(Bus bus);
	
	void delete(String busno);
	
	List<Bus> findBuses(String source,String destination, LocalDate departDate);
	
	List<Bus> findBuses();
	
	Bus getBusById(String busno);
	
	void update(Bus bus);
}
