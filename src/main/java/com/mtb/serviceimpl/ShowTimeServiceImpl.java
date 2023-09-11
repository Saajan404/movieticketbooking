package com.mtb.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtb.entity.ShowTime;
import com.mtb.repository.ShowTimeRepository;
import com.mtb.service.ShowTimeService;

@Service
public class ShowTimeServiceImpl implements ShowTimeService{

	@Autowired
	ShowTimeRepository showTimeRepository;
	
	
	@Override
	public ShowTime saveShowTime(ShowTime showTime) {

		showTimeRepository.save(showTime);
		return showTime;
	}}
