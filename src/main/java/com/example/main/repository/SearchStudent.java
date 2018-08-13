package com.example.main.repository;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.main.model.Student;

@Mapper
public interface SearchStudent {
	
	@Select("SELECT sid, firstname, lastname, school FROM student where firstname=#{firstname} and lastname=#{lastname} and school=#{school} and sid=#{studentid} ")
	public List<Student> search(@Param("studentid") String id,@Param("firstname") String firstname , @Param("lastname") String lastname, @Param("school") String school);
	
	@Select("SELECT sid, firstname, lastname, school FROM student where firstname=#{firstname} and sid=#{studentid} ")
	public List<Student> searchusingfirst(@Param("studentid") String id,@Param("firstname") String firstname);
     
	@Select("SELECT sid, firstname, lastname, school FROM student where firstname=#{firstname} and school=#{school} and sid=#{studentid} ")
	public List<Student> searchusingschoolandfirstname(@Param("studentid") String id,@Param("firstname") String firstname, @Param("school") String school);
	
	@Select("SELECT sid, firstname, lastname, school FROM student` where firstname=#{firstname} and lastname=#{lastname} and sid=#{studentid} ")
	public List<Student> searchusingfirstandlastname(@Param("studentid") String id,@Param("firstname") String firstname,@Param("lastname") String lastname);

	@Select("SELECT sid, firstname, lastname, school FROM student where school=#{school} and sid=#{studentid} ")
	public List<Student> searchusingschool(@Param("studentid") String id,@Param("school") String school);

	@Select("SELECT sid, firstname, lastname, school FROM student where firstname=#{firstname} and school=#{school} and sid=#{studentid} ")
	public List<Student> searchusinglastandschoolname(@Param("studentid") String id,@Param("lastname")String lastname,@Param("school")String school);
    
	@Select("SELECT sid, firstname, lastname, school FROM student where lastname=#{lastname} and sid=#{studentid} ")
	public List<Student> searchusinglastname(@Param("studentid") String id,@Param("lastname") String lastname);

}
