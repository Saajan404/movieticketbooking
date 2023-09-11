package com.mtb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtb.dto.TheaterDTO;
import com.mtb.entity.Theater;
import com.mtb.service.TheaterService;
import com.mtb.util.TheaterConverter;

@RestController
public class TheaterController {

	@Autowired
	TheaterService theaterService;

	@Autowired
	TheaterConverter theaterConverter;

	// save theater details
	@PostMapping("/saveTheater")
	TheaterDTO saveTheater(@Valid @RequestBody TheaterDTO theaterDto) {

		Theater theater = theaterConverter.convertDtoToTheaterEntity(theaterDto);

		return theaterService.saveTheater(theater);

	}

	// assign movie and theater to showTime
	@PostMapping("/assignShowTime/{sTId}/toTheater/{tId}/toMovie/{mId}")
	public ResponseEntity<String> assignShowtimeToTheaterAndMovie(@PathVariable("sTId") int sTId,
			@PathVariable("tId") int tId, @PathVariable("mId") int mId) {

		theaterService.assignShowtimeToTheaterAndMovie(sTId, tId, mId);

		return new ResponseEntity<String>(
				"Theater with id" + tId + " and Movie with Id" + mId + "assigned to SHowTime id" + sTId, HttpStatus.OK);

	}

	// method to get theater details by using id
    @GetMapping("/getTheaterById/{tId}")
	TheaterDTO getTheaterById(@PathVariable("tId") int theaterId) {

		return theaterService.getTheaterById(theaterId);

	}

}
