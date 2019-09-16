package com.user.registration.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.user.registration.dto.UserRequestDto;
import com.user.registration.dto.UserResponseDto;
import com.user.registration.entity.User;
import com.user.registration.exception.UserRegistrationException;
import com.user.registration.repository.UserRepository;
import com.user.registration.service.RegisterServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RegisterServiceImplTest {
	@InjectMocks
	RegisterServiceImpl registerService;
	@Mock
	UserRepository userRepository;

	@Test
	public void testRegister() {
		String userName = "sai";
		String mobileNumber="97789";
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setStatusCode(200);
		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setUserMobile("9272882");
		userRequestDto.setUserName("saikiranhelo");
		User user = new User();
		BeanUtils.copyProperties(userRequestDto, user);
		Optional<User> user1 = Optional.of(user);
		Mockito.when(userRepository.findByUserName(userName)).thenReturn(user1);
		Mockito.when(userRepository.findByMobile(mobileNumber)).thenReturn(user1);
		Mockito.when(userRepository.save(Mockito.anyObject())).thenReturn(user);
		UserResponseDto dto = registerService.register(userRequestDto);
		assertEquals(userResponseDto.getStatusCode(), dto.getStatusCode());

	}

	@Test(expected = UserRegistrationException.class)
	public void testEmptyCredentials() {

		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setUserMobile("");
		userRequestDto.setUserName("");
		UserResponseDto dto = registerService.register(userRequestDto);
	}
	@Test(expected = UserRegistrationException.class)
	public void MobileNumberAlreadyRegistered() {
		String mobileNumber="98";
		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setUserMobile("97838389");
		userRequestDto.setUserName("sai");
		User user = new User();
		BeanUtils.copyProperties(userRequestDto, user);
		Optional<User> user1 = Optional.of(user);
		Mockito.when(userRepository.findByUserName(user.getUserName())).thenReturn(user1);
		Mockito.when(userRepository.findByMobile(mobileNumber)).thenReturn(user1);
		Mockito.when(userRepository.save(Mockito.anyObject())).thenReturn(user);
		UserResponseDto dto = registerService.register(userRequestDto);
	
	}
	@Test(expected = UserRegistrationException.class)
	public void testAlreadyExisting() {
String userName="hello";
		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setUserMobile("97838389");
		userRequestDto.setUserName("sai");
		User user = new User();
		BeanUtils.copyProperties(userRequestDto, user);
		Optional<User> user1 = Optional.of(user);
		Mockito.when(userRepository.findByUserName(userName)).thenReturn(user1);
		Mockito.when(userRepository.findByMobile(user.getUserName())).thenReturn(user1);
		Mockito.when(userRepository.save(Mockito.anyObject())).thenReturn(user);
		UserResponseDto dto = registerService.register(userRequestDto);
	}
}
