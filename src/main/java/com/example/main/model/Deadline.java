package com.example.main.model;

public class Deadline {
	private String schoolname, startdate, deadline,paymenttype;

	public Deadline(String schoolname, String startdate, String deadline,String paymenttype) {
		super();
		this.schoolname = schoolname;
		this.startdate = startdate;
		this.deadline = deadline;
		this.deadline=deadline;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public String getSchoolname() {
		return schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
}



