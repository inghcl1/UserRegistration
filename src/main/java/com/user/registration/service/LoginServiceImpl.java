package com.user.registration.service;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.registration.dto.LoginDTO;
import com.user.registration.dto.LoginResponseDTO;
import com.user.registration.entity.User;
import com.user.registration.exception.UserRegistrationException;
import com.user.registration.repository.UserRepository;
import com.user.registration.util.UserRegistrationConstants;


@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger lOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public LoginResponseDTO getUserDetails(LoginDTO loginDTO) {
		
		lOGGER.info("Inside LoginServiceImpl");

		String userName = loginDTO.getUserName();
		String password = loginDTO.getPassword();

		LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
	
		if (userName.equals("") || password.equals("")) {

			throw new UserRegistrationException(UserRegistrationConstants.EMPTY_CREDENTIALS);

		}

		else {
			Optional<User> userList = userRepository.findByUserNameAndPassword(userName, password);

			if (!(userList.isPresent())) {
				throw new UserRegistrationException(UserRegistrationConstants.LOGIN_FAILURE);

			}
			
			else {
			
				
	
				loginResponseDTO.setUserName(userList.get().getUserName());
				loginResponseDTO.setUserId(userList.get().getUserId());
			
				loginResponseDTO.setMessage(UserRegistrationConstants.REGISTER_SUCCESS);
				loginResponseDTO.setStatusCode(UserRegistrationConstants.LOGIN_SUCCESS_CODE);

			}

		}

		return loginResponseDTO;
	}
}