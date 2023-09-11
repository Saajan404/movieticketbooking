package com.mtb.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.mtb.entity.Booking;
import com.mtb.entity.Movie;
import com.mtb.entity.Theater;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShowTimeDTO {
	
	
	private int showTimeID;
	
	@NotNull(message = "start is required")
	private LocalTime startTime;
	
	@NotNull(message = "end time is required")
	private LocalTime endTime;
	
	@NotNull(message = "show date is required")
	private LocalDate showDate;
	
	@NotNull(message = "show price is required")
	private double showPrice;
	
	@ManyToOne
	private  Movie movie;
	 
	@ManyToOne
	private Theater theater;
	 
	@OneToMany
	private List<Booking> booking;

}
