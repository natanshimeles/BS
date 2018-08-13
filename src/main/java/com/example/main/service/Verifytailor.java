package com.example.main.service;

import com.example.main.repository.VerifyPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class Verifytailor {
	@Autowired
	private VerifyPass verifypassword;
	private  PasswordEncoder enc =new BCryptPasswordEncoder() ;
	
	
	public boolean verifypass(String username, String password) {
		String realpassword = verifypassword.getpassword(username);
		if(enc.matches(password, realpassword)) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
}
