package com.user.registration.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.user.registration.dto.LoginDTO;
import com.user.registration.dto.LoginResponseDTO;
import com.user.registration.service.LoginServiceImpl;
import com.user.registration.util.UserRegistrationConstants;



@RunWith(MockitoJUnitRunner.class)
public class LoginControllerTest {

	@Mock
	LoginServiceImpl loginServiceImpl;

	@InjectMocks
	LoginController loginController;

	@Test
	public void testGetUser() {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setUserName("raja@gmail.com");
		loginDTO.setPassword("raja@123");
		
		LoginResponseDTO loginResponseDTO=new LoginResponseDTO();
		loginResponseDTO.setUserId(1);
		loginResponseDTO.setUserName("raja@gmail.com");
		loginResponseDTO.setMessage(UserRegistrationConstants.LOGIN_SUCCESS);
		loginResponseDTO.setStatusCode(UserRegistrationConstants.LOGIN_SUCCESS_CODE);
		
		Mockito.when(loginServiceImpl.getUserDetails(loginDTO)).thenReturn(loginResponseDTO);
		LoginResponseDTO actualValue=loginServiceImpl.getUserDetails(loginDTO);
		assertEquals(loginResponseDTO.getStatusCode(), actualValue.getStatusCode());
		
	}

}
