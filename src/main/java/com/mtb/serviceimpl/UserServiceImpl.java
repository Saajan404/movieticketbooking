package com.mtb.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.mtb.dto.UserDTO;
import com.mtb.entity.User;
import com.mtb.exceptions.ResourceNotFoundException;
import com.mtb.repository.UserRepository;
import com.mtb.service.UserService;
import com.mtb.util.UserConverter;




@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserConverter userConverter;
	
	@Override
	public String createUser(User user) {
		
		String userNm = user.getUserEmail().substring(0,user.getUserEmail().indexOf('@'));
        user.setUserName(userNm);
		
        userRepository.save(user);
        
		return "User detail saved successfully!!";
	}

	//save the user details
	@Override
	public UserDTO saveUser(User user)  {
		
		String userNm = user.getUserEmail().substring(0,user.getUserEmail().indexOf('@'));
		
        user.setUserName(userNm);
		
        User existUser = userRepository.findByEmailOrContact(user.getUserEmail(), user.getContact());

       if (existUser != null) {

			throw new DataIntegrityViolationException("check your contact and email");
		}
        
        userRepository.save(user);
		
		return userConverter.convertUserEntityToDto(user);
	}

	//fetch the user details using id
	@Override
	public UserDTO getUserById(int userId) {
		
		User user =userRepository.findById(userId).orElseThrow(()->
		new ResourceNotFoundException("User", "userId", userId));
		
		return userConverter.convertUserEntityToDto(user);
	}

	
	//fetch user details using email
	@Override
	public UserDTO getUserByEmail(String userEmail) {
		
		User user = userRepository.findByEmail(userEmail).orElseThrow(()->
		new ResourceNotFoundException("User", "userEmail", userEmail));
		
		return userConverter.convertUserEntityToDto(user);
	}

	

	
}
