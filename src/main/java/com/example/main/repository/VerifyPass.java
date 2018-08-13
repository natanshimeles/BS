package com.example.main.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VerifyPass {
	
	@Select("select password from tailoruser where username=#{username}")
	public String getpassword(@Param("username")String username);

	

}
