package com.example.main.repository;


import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.example.main.model.SchoolModel;


@Mapper
public interface SaveSchool {
	@Select("select  school_name, school_address  from school")
	List<SchoolModel> findall();
	
	@Insert("insert into school(school_name,school_address) values(#{school_name},#{school_address})")
	void insertschool(@Param("school_name") String school_name, @Param("school_address") String school_address);

	

}
