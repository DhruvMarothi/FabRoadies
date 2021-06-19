package com.fabRoadies.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabRoadies.dto.UserTickets;
import com.fabRoadies.entity.Ticket;
import com.fabRoadies.service.TicketService;

/**
 * Reperesents Ticket Controller
 * @author Dhruv Marothi
 * @version 1.0
 */
@CrossOrigin
@RestController
public class TicketController {

	@Autowired
	private TicketService service;
	///////
	
	//This method is now is attached with BusBookService Module.
	/*@PostMapping(value="/add/ticket/{busId}/{userId}/{noOfSeat}",consumes="application/json")
	public Ticket addTicket(@PathVariable("busId") String busId,@PathVariable("userId") int userId,@PathVariable int noOfSeat) {
		return service.bookTicket(busId, userId, noOfSeat);
	}*/
	
//	@PutMapping(value="/cancel/{ticketId}")
//	public void cancelBookTicket(@PathVariable("ticketId") Long ticketId) {
//		service.cancelBookTicket(ticketId);
//	}
	@GetMapping(value="/get/userTickets/{userId}",produces="application/json")
	public List<UserTickets> getAllTicketOfUser(@PathVariable("userId") int userId){
		//return service.getAllTicketsOfUser(userId);
		List<Ticket>ts=service.getAllTicketsOfUser(userId);
		List<UserTickets>ut=new ArrayList<>();
		for(int i=0;i<ts.size();i++)
		{
			UserTickets temp=new UserTickets();
			temp.ticketId=ts.get(i).getTicketId();
			temp.busno=ts.get(i).getBus().getBusno();
			temp.price=ts.get(i).getPrice();
			temp.reservationDate=ts.get(i).getReservationDate();
			temp.bustype=ts.get(i).getBus().getBusType();
			temp.source=ts.get(i).getBus().getDepartureCity();
			temp.destination=ts.get(i).getBus().getArrivalCity();
			if(ts.get(i).isBooked())
			{
				temp.booked="Booked";
			}
			
			ut.add(temp);
		}
	return ut;
	}
	
/*	@GetMapping(value="/get/userTickets/{userId}",produces="application/json")
	public List<Ticket> getAllTicketOfUser(@PathVariable("userId") int userId){
		return service.getAllTicketsOfUser(userId);
	}
	*/
	@DeleteMapping(value="/delete/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") Long ticketId) {
		service.deleteTicket(ticketId);
	}
	
	@GetMapping(value="/get/tickets",produces="application/json")
	public List<Ticket> getAllTicket(){
		return service.getAllTickets();
	}
	
	@GetMapping(value="/get/ticket/{ticketId}",produces="application/json")
	public Ticket getTicketById(@PathVariable("ticketId") Long ticketId){
		return service.getTicketById(ticketId);
	}
}
