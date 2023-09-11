package com.mtb.entity;


import java.time.LocalTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Booking_Details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@Column(nullable = false)
	private int numberOfTicket;
	
	@Column(nullable = false)
	private LocalTime bookingTime;
	
	@Column
	private Double bookingPrice;
	
	
	@ManyToOne   //many booking done by  one user
	private User user;
	
	
	@ManyToOne
	private ShowTime showTime;
	
	
	
}
