package com.example.main.model;

public class YearlyFee {
	private String studentid, firstname, lastname, school, payment_type, payment_amount, deadline_amount, howmanymothpaidonce;

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(String payment_amount) {
		this.payment_amount = payment_amount;
	}

	public String getDeadline_amount() {
		return deadline_amount;
	}

	public void setDeadline_amount(String deadline_amount) {
		this.deadline_amount = deadline_amount;
	}

	public String getHowmanymothpaidonce() {
		return howmanymothpaidonce;
	}

	public void setHowmanymothpaidonce(String howmanymothpaidonce) {
		this.howmanymothpaidonce = howmanymothpaidonce;
	}

	public YearlyFee(String studentid, String firstname, String lastname, String school, String payment_type,
			String payment_amount, String deadline_amount, String howmanymothpaidonce) {
		super();
		this.studentid = studentid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.school = school;
		this.payment_type = payment_type;
		this.payment_amount = payment_amount;
		this.deadline_amount = deadline_amount;
		this.howmanymothpaidonce = howmanymothpaidonce;
	}

}
