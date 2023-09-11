package com.mtb.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "showtime_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShowTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showTimeID;
	
	@Column(nullable = false)
	private LocalTime startTime;
	
	@Column(nullable = false)
	private LocalTime endTime;
	
	@Column(nullable = false)
	private LocalDate showDate;
	
	@Column(nullable = false)
	private double showPrice;
	
	@ManyToOne
	private  Movie movie;
	 
	@ManyToOne
	private Theater theater;
	 
	@OneToMany
	private List<Booking> booking;
	
}
