package com.example.main.service;




import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.model.Student;

import com.example.main.repository.SaveStudent;

@Service
public class RegsiterStudent{
	
	private Calendar thisyear = new GregorianCalendar();
	Integer yearinnumber=(thisyear.get(Calendar.YEAR));
	String year = yearinnumber.toString();
	Integer monthinnumber=thisyear.get(Calendar.MONTH);
	String month = monthinnumber.toString();
	Integer dayinnumber=thisyear.get(Calendar.DATE);
	String day = monthinnumber.toString();
	String date=year+"-"+month+"-"+day;
	
	
    @Autowired
	private SaveStudent savestudent;
	
	
	
	/*public List<Student> register(){
		return savestudent.findall();
		
	}
	*/
	
	



	public void register(String studentid,String firstname, String lastname, String school, String paymenttype,String paymentamount, String date,
			String amounttime, String amountpertime,String whattype,String forhowmanymonth) {
		List<String> stuid=savestudent.getStudentById(studentid);
		
		if(stuid!=null  ) {
			if(stuid.size()!=0) {
			if(stuid.get(stuid.size()-1).equals(studentid)) {
				// do nothing
			}
			else {
				savestudent.savestu(studentid,firstname,lastname,school);
			}
			
			
			}
			else {
				savestudent.savestu(studentid,firstname,lastname,school);
			}
			
		
			}
		else {
			savestudent.savestu(studentid,firstname,lastname,school);
		
		
		}
		
		if(whattype.equals("just for this month")) {
			
		
		savestudent.saveforthismonth(studentid,firstname,lastname,school,paymenttype,paymentamount,date,amounttime,amountpertime,year);
		}
		else {
		
		savestudent.saveyearly(studentid, firstname, lastname, school, paymenttype, paymentamount, amountpertime, forhowmanymonth,year);
		savestudent.savetocheckifpaidwholeyear(studentid, firstname, lastname, school, paymenttype,"NO");
		}
	
	}}
