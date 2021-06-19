package com.fabRoadies.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabRoadies.entity.Bus;
import com.fabRoadies.repo.BusRepository;

/**
 * Service class for Bus
 * @author Dhruv Marothi & Shailendra
 * @version 1.0
 */
@Service
public class BusServiceImpl implements BusService{

	@Autowired
	BusRepository busRepository;
	
	public void save(Bus bus)
	{  
		busRepository.save(bus);
	}
	
	public void delete(String busno)
	{  
		busRepository.deleteById(busno);	
	}
	
	public List<Bus> findBuses(String source,String destination, LocalDate departDate)
	{
		return busRepository.findBuses(source,destination,departDate);
	}
	
	public List<Bus> findBuses()
	{
		return busRepository.findAll();
	}
	
	public Bus getBusById(String busno) {
		return busRepository.findById(busno).get();
	}

	@Override
	public void update(Bus bus) {
		if(busRepository.getById(bus.getBusno())!=null) {
			busRepository.save(bus);
		}
		else {
			System.out.println("Bus does not exist");
		}
	}
}
