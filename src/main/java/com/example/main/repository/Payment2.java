package com.example.main.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Payment2 {

	
	@Select("SELECT payment_type,howmanymothpaidonce FROM yearlypayment where")
	public String getname(@Param("name")String name,@Param("school") String school);
	
}
