package com.example.main.model;

public class MonthlypaymentDetail {
	private String stuid, school, firstname, lastname, month, paid,fullyearpayment,type;

	public MonthlypaymentDetail(String stuid, String school, String firstname, String lastname, String month,
			String paid,String fullyearpayment,String type) {
		super();
		this.stuid = stuid;
		this.school = school;
		this.firstname = firstname;
		this.lastname = lastname;
		this.month = month;
		this.paid = paid;
		this.fullyearpayment=fullyearpayment;
		this.type=type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFullyearpayment() {
		return fullyearpayment;
	}

	public void setFullyearpayment(String fullyearpayment) {
		this.fullyearpayment = fullyearpayment;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}
	

}
