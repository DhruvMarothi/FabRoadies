package com.fabRoadies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fabRoadies.entity.Ticket;

/**
 * Reperesents Ticket Service
 * @author Dhruv Marothi
 * @version 1.0
 */
@Service
public interface TicketService {
	Ticket bookTicket(String busId, int userId,int numberOfSeat);
    void cancelBookTicket(Long ticketId);
    List<Ticket> getAllTicketsOfUser(int userId);
    void deleteTicket(Long id);
    List<Ticket> getAllTickets();
    Ticket getTicketById(Long id);
}
