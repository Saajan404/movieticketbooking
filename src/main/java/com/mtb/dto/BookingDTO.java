package com.mtb.dto;

import java.time.LocalTime;


import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.mtb.entity.ShowTime;
import com.mtb.entity.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookingDTO {
	
	
	private int bookingId;
	
	@NotNull(message ="number of ticket is required" )
	private int numberOfTicket;
	
	@NotNull(message ="booking time is required" )
	private LocalTime bookingTime;
	

	private Double bookingPrice;
	
	
	@ManyToOne   //many booking done by  one user
	private User user;
	
	
	@ManyToOne
	private ShowTime showTime;

}
