package com.mtb.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address_Details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	
	@Column(length = 100 ,nullable = false)
	private String locality;
	
	@Column(length = 50 ,nullable = false)
	private String city;
	
	
	@Column(length = 30 ,nullable = false)
	private String state;
	
	@Column(nullable = false)  // not null
	private int pincode;
}
