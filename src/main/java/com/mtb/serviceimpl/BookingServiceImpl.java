package com.mtb.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.mtb.dto.BookingDTO;
import com.mtb.entity.Booking;
import com.mtb.entity.Movie;
import com.mtb.entity.ShowTime;
import com.mtb.entity.Theater;
import com.mtb.entity.User;
import com.mtb.exceptions.MoreSeatNotAvailavleException;
import com.mtb.exceptions.ResourceNotFoundException;
import com.mtb.repository.BookingRepository;
import com.mtb.repository.MovieRepository;
import com.mtb.repository.ShowTimeRepository;
import com.mtb.repository.TheaterRepository;
import com.mtb.repository.UserRepository;
import com.mtb.service.BookingService;
import com.mtb.util.BookingConverter;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	ShowTimeRepository showTimeRepository;

	@Autowired
	BookingConverter bookingConverter;

	@Autowired
	TheaterRepository theaterRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	MovieRepository movieRepository;

	@Override
	public BookingDTO saveBooking(Booking booking, int userId, int showTimeId, int theaterId, int movieId)throws MoreSeatNotAvailavleException {

		
		//ShowTime showTime = showTimeRepository.findById(showTimeId);
		Theater theater   = theaterRepository.findById(theaterId).orElseThrow(()->
		new ResourceNotFoundException("Theater", "theaterId", theaterId));
		
		Movie movie       = movieRepository.findById(movieId).orElseThrow(()->
		new ResourceNotFoundException("Movie", "movieId", movieId));
		User user         = userRepository.findById(userId).orElseThrow(()->
		new ResourceNotFoundException("User", "userId", userId));
	
		ShowTime showTime = showTimeRepository.findByMovieAndTheater(movie, theater);

		
		
		int NoOfTicket = booking.getNumberOfTicket();
		double price = showTime.getShowPrice();
		booking.setBookingPrice(NoOfTicket * price);
		int totalSeat = theater.getTotalSeat();
		
		if(NoOfTicket<=totalSeat) {
		theater.setTotalSeat(totalSeat - NoOfTicket);
		}
		else {
			
			throw new MoreSeatNotAvailavleException(totalSeat);
		}
		
		booking.setUser(user);
		booking.setShowTime(showTime);

		showTimeRepository.save(showTime);
		movieRepository.save(movie);
		theaterRepository.save(theater);
		userRepository.save(user);
		bookingRepository.save(booking);


		return bookingConverter.convertBookingEntityToDto(booking);
	}

	


}
