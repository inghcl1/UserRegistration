package com.user.registration.service;

import java.util.Base64;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.registration.dto.UserRequestDto;
import com.user.registration.dto.UserResponseDto;
import com.user.registration.entity.User;
import com.user.registration.exception.UserRegistrationException;
import com.user.registration.repository.UserRepository;
import com.user.registration.util.PasswordGenerator;
import com.user.registration.util.UserRegistrationConstants;

@Service
public class RegisterServiceImpl implements RegisterService {
	private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
	@Autowired
	UserRepository userRepository;

	@Override
	public UserResponseDto register(UserRequestDto userRequestDto) {
		logger.info("entered into registerService");

		User user = new User();
		user.setMobile(userRequestDto.getUserMobile());
		user.setUserName(userRequestDto.getUserName());
		Optional<User> user1 = userRepository.findByUserName(user.getUserName());
		Optional<User> user2 = userRepository.findByMobile(user.getMobile());
		UserResponseDto userResponseDto = new UserResponseDto();
		if (user1.isPresent()) {
			throw new UserRegistrationException(UserRegistrationConstants.USER_ALREADY_EXISTS);

		}
		if(user2.isPresent())
		{
			throw new UserRegistrationException(UserRegistrationConstants.USER_MOBILE_ALREADY_EXISTS);
		}
		if (user.getUserName() == "" || user.getMobile() == "") {
			throw new UserRegistrationException(UserRegistrationConstants.EMPTY_CREDENTIALS);
		} else {

			PasswordGenerator passwordGenerator = new PasswordGenerator();
			String passGen = passwordGenerator.generate(user.getUserName());
			logger.debug(passGen);
			Base64.Encoder encoder = Base64.getEncoder();
			String str = encoder.encodeToString(passGen.getBytes());
			logger.debug(str);
			/*
			 * byte[] actualByte = Base64.getDecoder() .decode(str);
			 * 
			 * String actualString = new String(actualByte); logger.debug(actualString);
			 */
			user.setPassword(str);
			userRepository.save(user);

			userResponseDto.setUserName(user.getUserName());
			userResponseDto.setMessage(UserRegistrationConstants.REGISTERSUCCESS);
			userResponseDto.setStatusCode(UserRegistrationConstants.STATUS_CODE);
			return userResponseDto;

		}
	}

}
