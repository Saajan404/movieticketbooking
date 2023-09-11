package com.mtb.dto;

import java.util.List;


import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mtb.entity.Address;
import com.mtb.entity.ShowTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TheaterDTO {

	
	private int theaterId;
	
	@NotNull(message = "Name is required")
	@Size(min = 2, message = "min 2 characters required")
	@Size(max = 40, message = "max 40 characters required")
	@NotBlank
	private String theaterName;
	

	@NotNull(message = "total seat required")
	private int totalSeat;
	
	@OneToOne //one theater has one address
	private Address address;
	
	@OneToMany
	private List<ShowTime> showTime;
	
}
