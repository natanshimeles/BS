package com.example.main;

import org.springframework.web.context.annotation.SessionScope;



@SessionScope
public class Session {
	
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Session() {
		
	}
	
	
	

}
