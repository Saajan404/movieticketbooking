package com.mtb.service;



import org.springframework.web.bind.MethodArgumentNotValidException;

import com.mtb.dto.UserDTO;
import com.mtb.entity.User;

public interface UserService {

	String createUser(User user);

	UserDTO saveUser(User user) throws MethodArgumentNotValidException;

	UserDTO getUserById(int userId);
	
	UserDTO getUserByEmail(String userEmail);

	
	
	
}
