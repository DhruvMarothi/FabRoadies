package com.fabRoadies.rest;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(value= "/otpSend")
	public void otpSend() {
		reservationService.otpSend();
	}
	
	@RequestMapping(value = "/completeReservation/{otp}",method = RequestMethod.POST)
	 public void completeReservation(@RequestBody List<BookingRequest> reservationRequest,@PathVariable("otp") int otp) throws MessagingException{
		
		if(reservationService.verification(otp))
			reservationService.bookBus(reservationRequest);
//        return null;
      
    }  
	
}
