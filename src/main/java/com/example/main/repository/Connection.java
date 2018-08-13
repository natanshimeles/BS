package com.example.main.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Connection {
    
	@Select("select * from users")
	List<String> findall();

}
