package com.fabRoadies.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fabRoadies.entity.Ticket;

/**
 * @author Dhruv Marothi
 * @version 1.0
 */
public interface TicketRepo extends JpaRepository<Ticket, Long>{
	
	List<Ticket> findByUserId(int userId);
			
}
