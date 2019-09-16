package com.user.registration.util;

public class UserRegistrationConstants {
	public static final String REGISTERSUCCESS="user registered successfully";
	public static final Integer STATUS_CODE=200;
	public static final String USER_ALREADY_EXISTS="username already exists";
	public static final String USER_MOBILE_ALREADY_EXISTS="mobilenumber  already registered";
	public static final String EMPTY_CREDENTIALS="username or mobile number cannot be empty";
	public static final String LOGIN_SUCCESS = "Logged In Successfully";
	public static final String LOGIN_FAILURE = "Incorrect Username or password";
	public static final Integer LOGIN_SUCCESS_CODE = 201;
	public static final Integer LOGIN_FAILURE_CODE = 401;
	public static final String REGISTER_SUCCESS = "registration successfull";
	public String getUserNotFound() {
		return "Please enter valid userId";
	}

}
