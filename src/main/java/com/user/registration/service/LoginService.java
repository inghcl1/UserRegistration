package com.user.registration.service;

import org.springframework.stereotype.Service;

import com.user.registration.dto.LoginDTO;
import com.user.registration.dto.LoginResponseDTO;



@Service
public interface LoginService {
	
	public LoginResponseDTO getUserDetails(LoginDTO loginDTO);

}
