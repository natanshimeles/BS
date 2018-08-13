package com.example.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//annotation 
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
	
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String firstname;
	private String lastname;
	private String school;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public Student(String id, String firstname, String lastname, String school) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.school = school;
	}
	
	
	
	
	

}