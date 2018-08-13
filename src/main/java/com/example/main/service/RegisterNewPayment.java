package com.example.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.main.repository.PaymentTypes;

@Service
public class RegisterNewPayment {
	@Autowired
	private PaymentTypes paymentypes;

	public void save(String type, String desc) {
		paymentypes.insert(type,desc);		
	}

}
