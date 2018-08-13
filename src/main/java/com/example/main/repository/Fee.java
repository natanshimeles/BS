package com.example.main.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.main.model.Deadline;
import com.example.main.model.FullyearPaid;
import com.example.main.model.MonthlypaymentDetail;

@Mapper
public interface Fee {
	@Select("SELECT COUNT(*) FROM monthly_payment WHERE stuid=#{stuid} and school=#{school} and firstname=#{firstname} and lastname=#{lastname} and type=#{type} ")
	public int howmanytimespaidsofar(
			@Param("stuid") String id,
			@Param("school") String school,
			@Param("firstname") String firstname, 
			@Param("lastname") String lastname,
			@Param("type") String type);
	
	@Select("select studentid, firstname, lastname, school, payment_type, payment_amount, deadline_amount, howmanymothpaidonce "
			+ "from yearlypayment where studentid=#{studentid} and firstname=#{firstname} and lastname=#{lastname} and school=#{school}")
	public List<com.example.main.model.YearlyFee> geteverymonthfee(
			@Param("studentid") String id,
			@Param("firstname") String firstname,
			@Param("lastname") String lastname, 
			@Param("school") String school);
	
	@Select("SELECT schoolname, startdate, deadline, paymenttype FROM montlydeadline where schoolname=#{school}")
	public List<Deadline>getdeadline(@Param("school") String school);
	
	@Select("SELECT stuid, firstname, lastname, school,type, paid FROM fullyearpaid WHERE school=#{school} and firstname=#{firstname} and lastname=#{lastname} and stuid=#{stuid} and NOT paid='YES'")
	public List<FullyearPaid> FullyearPaid(@Param("stuid")String stuid,@Param("firstname")String firstname,@Param("lastname")String lastname,@Param("school")String school);
	
	
	@Select("select firstname, lastname, school, payment_type, "
			+ "payment_amount, deadline, deadline_days,"
			+ " dealine_amounts from payment_details"
			+ " where studentid =#{studentid} and firstname=#{firstname} and lastname=#{lastname} and school=#{school} and Not paid='yes'")
	public List<com.example.main.model.MonthlyFee> getonemonthfee(@Param("studentid") String id,
			@Param("firstname") String firstname,
			@Param("lastname") String lastname,
			@Param("school") String school);
	
	@Select("SELECT stuid, school, firstname, lastname, month, paid,fullyearpayment,type FROM monthly_payment "
    		+ "WHERE stuid=#{stuid} and firstname=#{firstname} and lastname=#{lastname} and school=#{school} ")
    List<MonthlypaymentDetail> getmonthly(@Param("stuid")String id,@Param("firstname")String firstname,@Param("lastname")String lastname,@Param("school")String school );

}


