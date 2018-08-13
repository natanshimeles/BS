package com.example.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.repository.PaymentTypes;
import com.example.main.repository.SearchSchool;

@Service
public class SearchSchools {
	@Autowired
	private SearchSchool searchschool;
	@Autowired
	private PaymentTypes paymenttypes;
	public String []getschool(){
		List<String> Listschools= searchschool.getschool();
		String[] schools = new String[Listschools.size()];
		schools=Listschools.toArray(schools);
		return schools;
	}
	public String[] getpayments() {
		// TODO Auto-generated method stub
		List<String> Listpayments= paymenttypes.getpayment();
		String[] payments = new String[Listpayments.size()];
		payments=Listpayments.toArray(payments);
		return payments;
	}
	

}
