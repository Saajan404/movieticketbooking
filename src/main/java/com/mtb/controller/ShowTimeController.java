package com.mtb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtb.entity.ShowTime;
import com.mtb.service.ShowTimeService;

@RestController
public class ShowTimeController {
	
	@Autowired
	ShowTimeService showTimeService;
	
	
	@PostMapping("/saveShowTime")
	ShowTime saveShowTime(@Valid @RequestBody ShowTime showTime) {
		
		
		return showTimeService.saveShowTime(showTime);
		
		
		
	}

}
