package com.user.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.registration.dto.LoginDTO;
import com.user.registration.dto.LoginResponseDTO;
import com.user.registration.service.LoginService;



@RestController
@RequestMapping("/hcl")
public class LoginController {

	@Autowired
	LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> getUser(@RequestBody LoginDTO loginDTO) {

		return new ResponseEntity<>(loginService.getUserDetails(loginDTO), HttpStatus.OK);

	}
}