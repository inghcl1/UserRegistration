package com.user.registration.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.registration.dto.UserRequestDto;
import com.user.registration.service.RegisterService;


@RestController
@RequestMapping("/hcl")
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	@Autowired
	RegisterService registerService;
	@PostMapping("/register")
	public ResponseEntity userRegistration(@RequestBody UserRequestDto userRequestDto)
	{
		logger.info("entered into register controller");
		return new ResponseEntity<>(registerService.register(userRequestDto),HttpStatus.OK);
	}

}
