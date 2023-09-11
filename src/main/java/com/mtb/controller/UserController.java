package com.mtb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtb.dto.UserDTO;
import com.mtb.entity.User;
import com.mtb.service.UserService;
import com.mtb.util.UserConverter;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserConverter userConverter;

	@PostMapping("/createUser")
	public String createUser(@Valid @RequestBody UserDTO userDto) {

		final User user = userConverter.convertDtoToUserEntity(userDto);

		return userService.createUser(user);

	}

	//save the user details 
	@PostMapping("/saveUser")
	public UserDTO saveUser(@Valid @RequestBody UserDTO userDto) throws MethodArgumentNotValidException {

		final User user = userConverter.convertDtoToUserEntity(userDto);

		return userService.saveUser(user);
	}

	//fetch the value using id
	@GetMapping("/getUser/{userId}")
	public UserDTO getUserById(@PathVariable("userId") int id) {

		return userService.getUserById(id);

	}

	//get the value using email
	@GetMapping("/getUserByEmail/{userEmail}")
	public UserDTO getUserByEmail(@PathVariable("userEmail") String userEmail) {
		
		return userService.getUserByEmail(userEmail);
	}

}
