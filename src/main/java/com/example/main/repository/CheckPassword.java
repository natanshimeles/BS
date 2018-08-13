package com.example.main.repository;


import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CheckPassword {
	
	@Select("select password from adminuser where user_name=#{name} ")
	String findpassword(@PathParam("name") final String name);
	
	

}
