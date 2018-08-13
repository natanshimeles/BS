package com.example.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.main.repository.CreateNewUser;

@Service
public class CreateUser {
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Autowired
	private CreateNewUser newuser;
	

	public void saveusers(String firstname, String lastname, String branch, String username, String password) {
		String newpassword= passwordEncoder.encode(password);
		newuser.savenow(username,newpassword,firstname,lastname,branch);
		
		
	}
}