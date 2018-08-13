package com.example.main.service;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.MapAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.model.FullyearPaid;
import com.example.main.model.MonthlypaymentDetail;
import com.example.main.model.TotalPayment;
import com.example.main.repository.Fee;

@Service
public class SearchFee {
	@Autowired 
	private Fee fee;
	private GregorianCalendar today = new GregorianCalendar();
	private List<TotalPayment> toallytopay = null;
	private List<TotalPayment> totalyearpay = null;
	
	private double amountobeadded = 0;
	
	
	public List<TotalPayment>searchyearly(String id,String firstname, String lastname, String school) {
		//search year and pay year left
		totalyearpay =new LinkedList<>();
		
		
		
		return totalyearpay;
		
	}

	public List<TotalPayment>  search(String id,String firstname, String lastname, String school) {
		toallytopay =new LinkedList<>();
		
		// TODO Auto-generated method stub
		List<com.example.main.model.YearlyFee> yearpayment =fee.geteverymonthfee(id,firstname, lastname, school);
		List<com.example.main.model.MonthlyFee> onemonthpayment =fee.getonemonthfee(id, firstname, lastname, school);	
		List<MonthlypaymentDetail> montlydetail = fee.getmonthly(id, firstname, lastname, school);
		List<FullyearPaid> fullyearpaid=fee.FullyearPaid(id, firstname, lastname, school);
		
		//check yearly payment
		if(onemonthpayment.isEmpty()&&yearpayment.isEmpty()) {
			TotalPayment totalpayment = new TotalPayment("total",0,"empty",0.0,0,"empty");
			toallytopay.add(totalpayment);
			return toallytopay;
		}
		
		
		
		GregorianCalendar deadline = null;
		Double total =0.0;
		String day=null;
		
		GregorianCalendar lastpaiddate = null;
		int days=0;
		int month=0;
		Integer year=0;
		String totallyreview ="";
		int count = 1;
		//payment which is paid once a year
		for(com.example.main.model.MonthlyFee n : onemonthpayment) {
			int howmuch=0;
			
			Integer paymentwithoutpenalty =n.getPayment_amount();
			howmuch+=paymentwithoutpenalty;
			total+=paymentwithoutpenalty;
			day =n.getDeadline();
					
					
					deadline = getdate(day);
					
					
					if(today.after(deadline)) {
						
						
						int deadline_days=n.getDeadline_days();
						int deadline_amount =n.getDealine_amounts();
						amountobeadded = 0;
						Date startDate = deadline.getTime();
						Date endDate = today.getTime();
						long startTime = startDate.getTime();
						long endTime = endDate.getTime();
						long diffTime = endTime - startTime;
						long totaldeadlinedays = diffTime / (1000 * 60 * 60 * 24);
						//int totaldeadlinedays = yearamount+monthamount +dayamount;
						amountobeadded=deadline_amount*totaldeadlinedays/deadline_days;
						total+=amountobeadded;
						howmuch+=amountobeadded;
						
						
						
						 
						
					}
					TotalPayment totalpayment = new TotalPayment(n.getPayment_type(),paymentwithoutpenalty,n.getDeadline(),amountobeadded,howmuch,"monthly");
					toallytopay.add(totalpayment);
					totallyreview+=count+". ";
					totallyreview+=totalpayment.toString();
					totallyreview+="----->    ";
					 count++;
	}	
			
			/////////////////////////////////////////////////////////
		//payment which is paid every month

		
		if(!montlydetail.isEmpty() ) {
			String montlydeadline =montlydetail.get(montlydetail.size()-1).getMonth();
			lastpaiddate = getdate(montlydeadline);
					
			}
		
		//school ......... 
		List<com.example.main.model.Deadline> deadlines =fee.getdeadline(school);

		for(int i=0;i<deadlines.size();i++) {
			
			int k=0;
			boolean addit=true;
			
		/*	while(k<fullyearpaid.size()) {
				
				String thisfee=fullyearpaid.get(k).getType();
				String answer=fullyearpaid.get(k).getPaid();
				if(thisfee.equals(deadlines.get(i).getPaymenttype())) {
					if(answer.equals("YES")) {
						addit=false;
					}
				}
				k++;
				
			}*/
			if(addit){
				
				
			
			String currnetdeadline = deadlines.get(i).getDeadline();
			String currentstartdate =deadlines.get(i).getStartdate();
			GregorianCalendar paymentstartdate=getdate(currentstartdate);
			GregorianCalendar paymentdate =getdate(currnetdeadline);
			if(paymentstartdate.after(lastpaiddate)||(lastpaiddate==null)) {
				
				
				for(com.example.main.model.YearlyFee yearly:yearpayment) {
					
					if(yearly.getPayment_type().equals(deadlines.get(i).getPaymenttype())) {
						// add ketat
						//then go to save
						
						long penalty=0;
						//today is after payment day
						if(today.after(paymentdate)) {
							//int deadline_days=;
							int deadline_amount =Integer.parseInt(yearly.getDeadline_amount());
							
							Date startDate = paymentdate.getTime();
							Date endDate = today.getTime();
							long startTime = startDate.getTime();
							long endTime = endDate.getTime();
							long diffTime = endTime - startTime;
							long totaldeadlinedays = diffTime / (1000 * 60 * 60 * 24);
							//int totaldeadlinedays = yearamount+monthamount +dayamount;
							penalty=deadline_amount*totaldeadlinedays;
							
						}
						
						
						int paymentwithoutpenalty = Integer.parseInt(yearly.getPayment_amount());
						long paymentwithpenalty=paymentwithoutpenalty+penalty;
						TotalPayment totalpayment = new TotalPayment(deadlines.get(i).getPaymenttype(),paymentwithoutpenalty,deadlines.get(i).getDeadline(),penalty,paymentwithpenalty,"yearly");
						toallytopay.add(totalpayment);
						
						total+=paymentwithpenalty;
						
						
					}
				}
				
			}
			}
			
			
			
		}
		
	//Integer s =deadline.get(Calendar.MONTH);
		
		totallyreview+="----------------------------->Totally: ";
		totallyreview+=total;
		TotalPayment lastpayment = new TotalPayment("total",0,"empty",0.0,total,"totally");
		toallytopay.add(lastpayment);
		
	return toallytopay;
	}
	
	
	
	
	public static GregorianCalendar getdate(String day) {
		GregorianCalendar deadline = null;
		int days=0;
		int month=0;
		int year=0;
		int j=0;
		int i=0;
		for(;i<day.length();i++) {
			if(day.charAt(i)=='-') {
				year = Integer.parseInt(day.substring(j, i));
				i++;
				j=i;
				break;
			}
			
		}
		
		for(;i<day.length();i++) {
			if(day.charAt(i)=='-') {
				month = Integer.parseInt(day.substring(j,i));
				i++;
				j=i;
				break;
			}
		}
		
		        month--;
				days = Integer.parseInt(day.substring(j,day.length()));
				
				
				
				deadline = new GregorianCalendar(year,month,days);
				return deadline;
				
	}

}
