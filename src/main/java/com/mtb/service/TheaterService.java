package com.mtb.service;

import com.mtb.dto.TheaterDTO;
import com.mtb.entity.Theater;

public interface TheaterService {

	//save theater details
	TheaterDTO saveTheater(Theater theater);

    //assign movie and theater to showTime
	void assignShowtimeToTheaterAndMovie(int sTId, int tId, int mId);

	
	//method to get theater details by using id
	TheaterDTO getTheaterById(int theaterId);
	
}
