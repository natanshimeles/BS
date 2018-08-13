package com.example.main.model;

public class TotalPayment {
	private String paymentname;
	private int howmuch;
	private String deadline;
	private double penalty;
	private double total;
	private String type;
	public String getPaymentname() {
		return paymentname;
	}
	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}
	public int getHowmuch() {
		return howmuch;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setHowmuch(int howmuch) {
		this.howmuch = howmuch;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public double getPenalty() {
		return penalty;
	}
	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "TotalPayment [paymentname=" + paymentname + ", howmuch=" + howmuch + ", deadline=" + deadline
				+ ", penalty=" + penalty + ", total=" + total + ", type=" + type + "]";
	}
	public TotalPayment(String paymentname, int howmuch, String deadline, double penalty, double total, String type) {
		super();
		this.paymentname = paymentname;
		this.howmuch = howmuch;
		this.deadline = deadline;
		this.penalty = penalty;
		this.total = total;
		this.type = type;
	}
	
	
	

}
