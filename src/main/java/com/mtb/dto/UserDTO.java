package com.mtb.dto;

import java.util.List;


import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.mtb.entity.Booking;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	
	private int userId;
	
	
	@Email
	@NotNull(message = "contact is required")
	private String userEmail;
	
	@Size(min = 8 , message ="min. 8 charater requires")
	@Size(max = 25 , message =" max 25  charater requires")
	private String userName;
	
	@Size(min = 8 , message ="min. 8 charater requires")
	@Size(max = 40 , message ="max 40 charater requires")
	@NotNull(message = "contact is required")
	private String password;
	
	@NotNull(message = "contact is required")
	@Size(min = 10 , max = 10)
	@Pattern(regexp = "[6789]{1}[0-9]{9}", message = "invalid contact detail")
	private String contact;
	
	@OneToMany
	private List<Booking> booking;
	
}
