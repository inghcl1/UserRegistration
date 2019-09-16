package com.user.registration.service;

import org.springframework.stereotype.Service;

import com.user.registration.dto.UserRequestDto;
import com.user.registration.dto.UserResponseDto;

@Service
public interface RegisterService {

	UserResponseDto register(UserRequestDto userRequestDto);

}
