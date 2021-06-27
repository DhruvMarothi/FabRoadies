package com.fabRoadies.rest;

import java.io.IOException;
import java.net.MalformedURLException;
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

/**
 * @author Dhruv Marothi
 * @version 1.0
 */
@RestController
@CrossOrigin(origins= {"*"})
public class BusBookController {
	@Autowired
    private BusBookService reservationService;
	
//	For sending otp on user registered phone number.
	@GetMapping(value= "/otpSend/{uid}")
	public void otpSend(@PathVariable("uid") int uid) {
		reservationService.otpSend(uid);
	}
	
// For validating the otp received from the user and completing the reservation process if validated successfully.
	@RequestMapping(value = "/completeReservation/{otp}",method = RequestMethod.POST)
	 public void completeReservation(@RequestBody List<BookingRequest> reservationRequest,@PathVariable("otp") int otp) throws MessagingException, MalformedURLException, IOException{		
		if(reservationService.verification(otp))
			reservationService.bookBus(reservationRequest);
//        return null;
    }  
}
