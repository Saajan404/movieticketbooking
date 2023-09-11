package com.mtb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtb.dto.TheaterDTO;
import com.mtb.entity.Address;
import com.mtb.entity.Movie;
import com.mtb.entity.ShowTime;
import com.mtb.entity.Theater;
import com.mtb.exceptions.ResourceNotFoundException;
import com.mtb.repository.AddressRepository;
import com.mtb.repository.MovieRepository;
import com.mtb.repository.ShowTimeRepository;
import com.mtb.repository.TheaterRepository;
import com.mtb.service.TheaterService;
import com.mtb.util.TheaterConverter;





@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	TheaterRepository theaterRepository;
	
	@Autowired
	TheaterConverter theaterConverter;
	
	@Autowired
	ShowTimeRepository showTimeRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	AddressRepository addRepository; 
	
	@Override
	public TheaterDTO saveTheater(Theater theater) {
		
		
		

		//setting address
		Address address = addRepository.save(theater.getAddress());
		theater.setAddress(address);

		theaterRepository.save(theater);
		
		return theaterConverter.convertTheaterEntityToDto(theater);
	}
	
	
   //assign movie and theater to showTime
	@Override
	public void assignShowtimeToTheaterAndMovie(int showTimeId, int theaterId, int movieId) {
	
		Theater theater = theaterRepository.findById(theaterId).orElseThrow(()->
		new ResourceNotFoundException("Theater", "theaterId", theaterId));
		
        Movie movie = movieRepository.findById(movieId).orElseThrow(()->
		new ResourceNotFoundException("Movie", "movieId", movieId));
        
        ShowTime showTime = showTimeRepository.findById(showTimeId).orElseThrow(()->
		new ResourceNotFoundException("ShowTime", "showTimeId", showTimeId));
		
    		 showTime.setMovie(movie);
    		 showTime.setTheater(theater);
    		 
    		 
    		 showTimeRepository.save(showTime);
    		 movieRepository.save(movie);
    		 theaterRepository.save(theater);
		
	}
	
	
	//method to get theater details by using id
	@Override
	public TheaterDTO getTheaterById(int theaterId) {
		
		Theater theater = theaterRepository.findById(theaterId).orElseThrow(()->
		new ResourceNotFoundException("Theater", "theaterId", theaterId));
		
		return theaterConverter.convertTheaterEntityToDto(theater);
	}
}