package com.example.main.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SearchSchool {

	@Select("select school_name from school")
	List<String>getschool();
}
