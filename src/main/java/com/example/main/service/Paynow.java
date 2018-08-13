package com.example.main.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.model.TotalPayment;
import com.example.main.repository.SavePayment;

@Service
public class Paynow {
	@Autowired
	private SavePayment savepayment;
	private Calendar thisyear = new GregorianCalendar();
	Integer yearinnumber=(thisyear.get(Calendar.YEAR));
	String year = yearinnumber.toString();
	
	Integer monthinnumber=thisyear.get(Calendar.MONTH);
	String month = monthinnumber.toString();
	
	Integer dayinnumber=thisyear.get(Calendar.DATE);
	String day = dayinnumber.toString();
	
	String date=year+"-"+month+"-"+day;

	public void paywhatowed(String id,String firstname, String lastname, String school, double totalpayment,List<TotalPayment> fee) {
		savepayment.addname(firstname);
		for(TotalPayment payment: fee) {
			if(payment.getType().equals("yearly")) {
				savepayment.savemonthlypayment(id, school, firstname, lastname, date, payment.getTotal(),payment.getPaymentname());
			}
			
		
		
		}
		
		
		GregorianCalendar paidate = new GregorianCalendar();
		String month="";
		
		
		Integer year =paidate.get(Calendar.YEAR);
		month+=year.toString()+"-";
		
		Integer months =paidate.get(Calendar.MONTH);
		month+=months.toString()+"-";
		
		Integer day = paidate.get(Calendar.DATE);
		month+=day.toString()+"/";
		
		Integer hour =paidate.get(Calendar.HOUR);
		month+=hour.toString()+":";
		
		Integer minute =paidate.get(Calendar.MINUTE);
		month+=minute.toString()+":";
		
		Integer second =paidate.get(Calendar.SECOND);
		month+=second.toString();
		
		savepayment.savedetails(id,firstname,lastname,school,month);
	    savepayment.savetotalhistory(id,firstname,lastname,school,totalpayment,month);
		savepayment.savedetail(id,firstname, lastname, school, month);
		
		
	}

}
