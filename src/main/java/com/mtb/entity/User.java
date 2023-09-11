package com.mtb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user_Details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	
	
	@Column(length = 50,nullable = false , unique = true)
	private String userEmail;
	
	@Column(length = 25, nullable= false)
	private String userName;
	
	@Column(length = 40,nullable = false )
	private String password;
	
	@Column(length = 10, nullable = false, unique = true)
	private String contact;
	
	@OneToMany
	private List<Booking> booking;

	

	

}
