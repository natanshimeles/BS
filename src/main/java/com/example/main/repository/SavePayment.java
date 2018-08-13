package com.example.main.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface SavePayment {
    
	
	@Update("UPDATE payment_details set paiddate=#{paiddate} where firstname=#{firstname} and lastname=#{lastname} and school=#{school} and studentid=#{studentid}")
	public void savedetails(@Param("studentid")String studentid,@Param("firstname")String firstname, @Param("lastname")String lastname, @Param("school")String school,@Param("paiddate") String paiddate);
    
    @Update("UPDATE payment_details set paid='yes' where firstname=#{firstname} and lastname=#{lastname} and school=#{school} and studentid=#{studentid}")
    public void savedetail(@Param("studentid")String studentid,@Param("firstname")String firstname, @Param("lastname")String lastname, @Param("school")String school,@Param("paiddate ") String paiddate);
    
    
    @Insert("INSERT INTO payment_history(stuid,firstname, lastname, school, amount,daate_of_paid) VALUES(#{stuid},#{firstname},"
    		+ "#{lastname},#{school},#{amount},#{daate_of_paid})")
    public void savetotalhistory(@Param("stuid")String id,@Param("firstname")String firstname,@Param("lastname") String lastname,@Param("school") String school,
    		@Param("amount") double amount,@Param("daate_of_paid") String daate_of_paid);
    
    
    @Insert("INSERT INTO monthly_payment(stuid, school, firstname, lastname, month, paid,type) VALUES "
    		+ "(#{stuid},#{school},#{firstname},#{lastname},#{month},#{paid},#{type})")
    public void savemonthlypayment(
    		@Param("stuid")String stuid,
    		@Param("school")String school,
    		@Param("firstname")String firstname,
    		@Param("lastname")String lastname,
    		@Param("month")String month,
    		@Param("paid")double paid,
    		@Param("type") String type );

     
    @Insert("insert into name(name) values(#{name})")
	public void addname(String firstname);
    

}


