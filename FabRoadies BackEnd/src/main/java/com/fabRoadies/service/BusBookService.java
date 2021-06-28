
package com.fabRoadies.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabRoadies.dto.BookingRequest;
import com.fabRoadies.entity.Bus;
import com.fabRoadies.entity.Passenger;
import com.fabRoadies.entity.Ticket;
import com.fabRoadies.entity.User;
import com.fabRoadies.repo.BusRepository;
import com.fabRoadies.repo.PassengerRepo;
import com.fabRoadies.repo.TicketRepo;
import com.fabRoadies.repo.UserRepo;
import com.fabRoadies.utils.Emailsend;
import com.fabRoadies.utils.PdfGenerator;
import com.fabRoadies.utils.SendSms;
import com.itextpdf.text.DocumentException;

/**
 * Reperesents Booking request service encountered when ticket is booked.
 * @author Dhruv Marothi & Shailendra & Pratik
 * @version 3.0
 */
@Service
@Transactional
public class BusBookService {

	@Autowired
	private BusRepository busRepository;
	@Autowired
	private PassengerRepo passengerRepository;

	@Autowired
	private TicketRepo reservationRepository;
	@Autowired
	private UserRepo userRepository;
	@Autowired
	private Emailsend service;
	
	private Random random = new Random();
	private String id = String.format("%04d", random.nextInt(10000));
	private String otpSent;
	private String phoneNumber;

	public Ticket bookBus(List<BookingRequest> reservationRequest) throws MessagingException, MalformedURLException, IOException {

		///////// Ticket add///////////
		String busno = reservationRequest.get(0).getBusno();
		int userid = reservationRequest.get(0).getUserid();

		Optional<Bus> busOptional = busRepository.findById(busno);

		if (!busOptional.isPresent()) {
			throw new RuntimeException();
		}

		Bus bus = busOptional.get();
		Optional<User> userOptional = userRepository.findById(userid);
		User user = userOptional.get();
		this.phoneNumber = user.getPhoneNumber();
		Ticket reservation = new Ticket();
		reservation.setBus(bus);
		reservation.setUser(user);
		reservation.setReservationDate(bus.getDateOfDeparture());
		
		reservation.setPrice(bus.getPrice()*reservationRequest.size());
		
		Ticket savedReservation = reservationRepository.save(reservation);

		List<Passenger> listOfPassenger = new ArrayList<>();
		for (int i = 0; i < reservationRequest.size(); i++) {

			///////// Passenger add///////////

			Passenger passenger = new Passenger();
			passenger.setSeatno(reservationRequest.get(i).getSeatno());
			passenger.setName(reservationRequest.get(i).getName());
			passenger.setGender(reservationRequest.get(i).getGender());
			passenger.setAge(reservationRequest.get(i).getAge());
			passenger.setTicket(reservation);
			listOfPassenger.add(passenger);
			passengerRepository.save(passenger);
		}
		try

		{
			PdfGenerator.generateItenary(listOfPassenger,"C:\\Users\\ibmjfsdb209\\Desktop\\Pdf\\"+"Passenger.pdf");
			
			String s="C:\\Users\\ibmjfsdb209\\Desktop\\Pdf\\"+"Passenger.pdf";
			service.sendEmailWithAttachment(reservationRequest.get(0).getEmail(),
					"This is Email Body with Attachment",
					"This email has attachment",
					s);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
//		Message Sent

//		hello This is FabRoadies.Have a safe Journey
		SendSms.sendsms("Hello, This is FabRoadies.Have a safe Journey and enjoy your trip",reservationRequest.get(0).getPhone());
		
//		System.out.println("message sent");
		return savedReservation;
	}
	
	public void otpSend(int uid) {
		System.out.println(id);
		SendSms.sendsms("Your OTP no. is: "+ id +" .DO NOT SHARE IT ANYONE ELSE",userRepository.findById(uid).get().getPhoneNumber());
		this.otpSent=id;
//		return this.id;
	}
	
	public boolean verification(int otp) {
		System.out.println(otp);
		System.out.println(this.id);
		System.out.println(this.otpSent);
		if(Integer.toString(otp).equals(this.otpSent)) {
			System.out.println("Dhruv");
			return true;
		}
		else {
			return false;
		}
	}
}