package com.mtb.entity;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "theater_Details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Theater {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theaterId;
	
	@Column(length = 40, nullable = false)
	private String theaterName;
	
	@Column(nullable = false)
	private int totalSeat;
	
	@OneToOne //one theater has one address
	private Address address;
	
	@OneToMany
	private List<ShowTime> showTime;

	
}

