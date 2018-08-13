package com.example.main.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaymentTypes {
	
	@Insert("insert into payment(payment_type,payment_description) values(#{payment_type},#{payment_description})")
	public void insert(@Param("payment_type") String payment_type,@Param("payment_description") String payment_description  );
	
	@Select("select payment_type from payment")
	public List<String> getpayment();
    
}
