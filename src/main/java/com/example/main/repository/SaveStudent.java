package com.example.main.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.main.model.MonthlypaymentDetail;
import com.example.main.model.Student;


@Mapper
public interface SaveStudent {
	@Select("select * from schools")
	List<Student> findall();
	
	@Select("select sid from student where sid = #{sid}")
	public List<String> getStudentById(@Param("sid")String sid);	
	
	
	
	@Insert("INSERT INTO payment_details"
			+ "(studentid,firstname, lastname, school, payment_type, payment_amount, "
			+ "deadline, deadline_days, dealine_amounts,startdate,paid,paiddate,whichyear ) VALUES "
			
			+ "(#{studentid},#{firstname},#{lastname}, #{school},#{payment_type},#{payment_amount},"
			+ "#{deadline}, #{deadline_days}, #{dealine_amounts},'NULL','NO','not paid yet',#{whichyear})")
	void saveforthismonth(@Param("studentid") String studentid,@Param("firstname")String firstname, @Param("lastname")String lastname, @Param("school")String school
			,@Param("payment_type")String paymenttype,
			@Param("payment_amount")String paymentamount, @Param("deadline")String date,@Param("deadline_days") String amounttime,
			@Param("dealine_amounts")String amountpertime,
			@Param("whichyear") String whichyear);
	
	@Insert("INSERT INTO yearlypayment(studentid, firstname,lastname,school, payment_type, payment_amount, deadline_amount, howmanymothpaidonce,whichyear)"
			+ " VALUES(#{studentid}, #{firstname},#{lastname},#{school}, #{payment_type}, #{payment_amount}, #{deadline_amount}, #{howmanymothpaidonce},#{whichyear})")
	void saveyearly(
			@Param("studentid") String studentid,
			@Param("firstname")String firstname,
			@Param("lastname")String lastname,
			@Param("school")String school,
			@Param("payment_type")String paymenttype,
			@Param("payment_amount")String paymentamount,
			@Param("deadline_amount")String amountpertime,
			@Param("howmanymothpaidonce")String howmanymothpaidonce,
			@Param("whichyear") String whichyear
			);



    @Insert("INSERT INTO monthly_payment(stuid, school, firstname, lastname, month, paid) VALUES (#{stuid},#{school},#{firstname},#{lastname},#{month},#{paid})") 
	void savedetail(@Param("stuid")String studentid, @Param("firstname")String firstname, @Param("lastname")String lastname, @Param("school")String school,
			@Param("month")String month,@Param("paid") String paid);



   @Insert("INSERT INTO fullyearpaid(stuid, firstname, lastname, school, type, paid) VALUES(#{stuid},#{firstname},#{lastname},#{school},#{type},#{paid}) ")
	void savetocheckifpaidwholeyear(@Param("stuid")String studentid, 
			@Param("firstname")String firstname, @Param("lastname")String lastname,
			@Param("school")String school,
			@Param("type")String paymenttype,@Param("paid") String paid);
   
   @Insert("INSERT INTO  student(sid, firstname, lastname, school) values (#{sid} , #{firstname}, #{lastname}, #{school} )")
   void savestu(
		   @Param("sid") String sid,
		   @Param("firstname") String firstname,
		   @Param("lastname") String lastname,
		   @Param("school") String school);
    
    
}
