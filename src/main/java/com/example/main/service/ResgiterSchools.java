package com.example.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.model.SchoolModel;

import com.example.main.repository.SaveSchool;

@Service
public class ResgiterSchools {
	@Autowired
	private SaveSchool saveschool;
	
	
	
	
	
	
	
	
	


	public String saveschools(String school_name, String school_address) {
		    saveschool.insertschool(school_name, school_address);
			return "admin";
	}
	
	
}
