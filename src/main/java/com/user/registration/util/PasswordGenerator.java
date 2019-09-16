package com.user.registration.util;

import java.util.Random;

public class PasswordGenerator {

	public String generate(String sub) {
	
		 Random rand = new Random(); 
		 		 
		   Integer randgen = rand.nextInt(10000); 
	
	  
	     String pass=sub.substring(0, 3).concat("@").concat(randgen.toString());
	     return pass;
		
	}

}
