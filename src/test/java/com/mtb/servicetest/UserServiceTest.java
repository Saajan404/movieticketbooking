package com.mtb.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.mtb.entity.User;
import com.mtb.repository.UserRepository;
import com.mtb.service.UserService;

@SpringBootTest
class UserServiceTest {

	
	@Autowired
	UserService userService;
	
	@MockBean
	UserRepository userRepository;
	
	@Test
	void testSaveUser() throws MethodArgumentNotValidException {
		
		
		
		User user = User.builder().contact("8643276873")
                .userEmail("shivendra@gmail.com").password("shiva@12").build();

	
	
	
	Mockito.when(userRepository.save(user)).thenReturn(user);
	
	assertEquals("shivendra@gmail.com",userService.saveUser(user).getUserEmail());
	
	
	
	}
	
	@Test
	void testGetUserById() {
	
	
	User user = User.builder().contact("8643276873")
            .userEmail("shivendra@gmail.com").password("shiva@12").build();

	Optional<User> opUser = Optional.of(user);
	Mockito.when(userRepository.findById(user.getUserId())).thenReturn(opUser);
	
	
	String email = userService.getUserById(user.getUserId()).getUserEmail();	
	assertTrue( email.equals("shivendra@gmail.com"));
	
	
	
	
	}

}
