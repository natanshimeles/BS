package com.example.main.service;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.example.main.repository.CheckPassword;



@Service
public class VerifyPassword {
	private  PasswordEncoder enc =new BCryptPasswordEncoder() ;
	private CheckPassword checkpassword;
	
	public VerifyPassword(CheckPassword checkpassword ) {
		this.checkpassword = checkpassword;
		
	}
	
	public boolean verify(String username, String password) {
		if(enc.matches(password, checkpassword.findpassword(username))) {
			return true;
		}
		else {
			return false;
			
		}
		
	}

	
	
	

}
