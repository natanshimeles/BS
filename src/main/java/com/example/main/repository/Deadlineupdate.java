package com.example.main.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface Deadlineupdate {
	@Insert("Insert into montlydeadline(schoolname,startdate,paymenttype,deadline) values(#{schoolname},#{startdate},#{paymenttype},#{deadline})")
	public void updatedeadline(@Param("schoolname")String school,@Param("deadline")String deadline,
			@Param("paymenttype")String paymenttype,@Param("startdate")String startdate);

}
