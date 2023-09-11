package com.mtb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtb.dto.BookingDTO;
import com.mtb.entity.Booking;
import com.mtb.service.BookingService;
import com.mtb.util.BookingConverter;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	BookingConverter bookingConverter;
	
	@PostMapping("/saveBooking/userId/{uId}/showTimeId/{sTId}/theaterId/{tId}/movieId/{mId}")
	BookingDTO saveBooking(@Valid @RequestBody BookingDTO bookingDto,@PathVariable("uId") int uId,@PathVariable("sTId") int sTId,@PathVariable("tId") int tId,@PathVariable("mId") int mId) {
		
		final Booking booking = bookingConverter.convertDtoToBookingEntity(bookingDto);
		
		
		return bookingService.saveBooking(booking, uId, sTId, tId, mId);
		
	}
	
	
	
	
		
	

	
	
}
