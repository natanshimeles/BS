package com.example.main.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.repository.Deadlineupdate;

@Service
public class DeadlineUpdateService {
	@Autowired
	private Deadlineupdate deadlineupdate;
	private Calendar today= new GregorianCalendar();
	private String startdate="";
	
	public void updateDeadline(String schoolname,String deadline,String paymenttype) {
		Integer year =today.get(Calendar.YEAR);
		startdate+=year.toString()+"-";
		
		Integer month =today.get(Calendar.MONTH);
		
		startdate+=month.toString()+"-";
		
		Integer day = today.get(Calendar.DATE);
		startdate+=day.toString();
		
		
		deadlineupdate.updatedeadline(schoolname, deadline,paymenttype, startdate);
		
	}

	
}
