package com.example.main.model;

public class FullyearPaid {
	private String stuid, firstname, lastname, type, paid,school;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public FullyearPaid(String stuid, String firstname, String lastname, String type, String paid,String school) {
		super();
		this.stuid = stuid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.paid = paid;
		this.school=school;
	}
	

}
