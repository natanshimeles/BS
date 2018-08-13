package com.example.main.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CreateNewUser {
    
	
	@Insert("insert into tailoruser(username,password,firstname,lastname,branch) values(#{username}, #{password}, #{firstname}, #{lastname}, #{branch})")
	void savenow(@Param("username") String username, @Param("password")String password,
			@Param("firstname")String firstname,@Param("lastname") String lastname, 
			@Param("branch")String branch);

}
