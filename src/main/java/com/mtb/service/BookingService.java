package com.mtb.service;

import com.mtb.dto.BookingDTO;
import com.mtb.entity.Booking;

public interface BookingService {

	BookingDTO saveBooking(Booking booking,int userId, int showTimeId, int theaterId, int movieId);

	

	
	
}
