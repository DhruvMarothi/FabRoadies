package com.fabRoadies.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fabRoadies.entity.Bus;

/**
 * Used for search query based on source,destination and dateOfDeparture
 * @author Dhruv Marothi
 *@version 1.0
 */
public interface BusRepository extends JpaRepository<Bus,String> {
	
	@Query("FROM Bus WHERE arrivalCity= :destination and departureCity= :source and dateOfDeparture= :departDate")
	List<Bus> findBuses( @Param("source") String source, @Param("destination")String destination, @Param("departDate") LocalDate departDate);
	

	

}
