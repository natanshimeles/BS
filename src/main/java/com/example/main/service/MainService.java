package com.example.main.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.main.repository.Connection;

@Service
public class MainService {
	public static List<String> s= new LinkedList<>(); 
	
	
	private Connection conn;
	
	public MainService(Connection conn) {
		this.conn = conn;
		
	}
	
	public  List<String> getstudents() {
	
		return conn.findall();
	}

	public void addservice(String name) {
		s.add(name);
		
	}

}
