package com.fabRoadies.rest;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fabRoadies.dto.BookingRequest;
import com.fabRoadies.entity.Ticket;
import com.fabRoadies.service.BusBookService;

@RestController
@CrossOrigin(origins= {"*"})
public class BusBookController {
	@Autowired
    private BusBookService reservationService;

	@RequestMapping(value = "/completeReservation",method = RequestMethod.POST)
	 public String completeReservation(@RequestBody List<BookingRequest> reservationRequest) throws MessagingException{
      
        Ticket reservation=reservationService.bookBus(reservationRequest);
        return null;
      
    }  
	
}
