package com.mtb.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mtb.dto.UserDTO;
import com.mtb.entity.User;

@Component
public class UserConverter {
	
	// method to convert dto to User entity
		public User convertDtoToUserEntity(UserDTO uDto) {
			User user = new User();

			if (uDto != null) {

	           //for all or use BeanUtils
				BeanUtils.copyProperties(uDto, user);

			}

			return user;

		}

		// method to convert User entity to dto

		public UserDTO convertUserEntityToDto(User user) {
			UserDTO uDto = new UserDTO();

			if (user != null) {
				BeanUtils.copyProperties(user, uDto);

			}
			return uDto;

		}

}
