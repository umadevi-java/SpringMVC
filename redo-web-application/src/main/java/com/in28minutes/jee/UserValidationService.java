package com.in28minutes.jee;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {
	public boolean isUserValid(String usr, String pwd) {
		if(usr.equals("uma") && pwd.contentEquals("ert"))
			return true;
		else
			return false;
		
	}

}
