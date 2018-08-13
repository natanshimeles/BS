package com.example.main.model;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MonthlyFee {
	private String firstname; 
	private String lastname;
	private String school;
	private String payment_type;
	private Integer payment_amount;
	private String deadline;
	private Integer deadline_days;
	private Integer dealine_amounts;
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
	public Integer getPayment_amount() {
		return payment_amount;
	}
	public void setPayment_amount(Integer payment_amount) {
		this.payment_amount = payment_amount;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public Integer getDeadline_days() {
		return deadline_days;
	}
	public void setDeadline_days(Integer deadline_days) {
		this.deadline_days = deadline_days;
	}
	public Integer getDealine_amounts() {
		return dealine_amounts;
	}
	public void setDealine_amounts(Integer dealine_amounts) {
		this.dealine_amounts = dealine_amounts;
	}
	public MonthlyFee(String firstname, String lastname, String school, String payment_type, Integer payment_amount,
			String deadline, Integer deadline_days, Integer dealine_amounts) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.school = school;
		this.payment_type = payment_type;
		this.payment_amount = payment_amount;
		this.deadline = deadline;
		this.deadline_days = deadline_days;
		this.dealine_amounts = dealine_amounts;
	} 	

}
