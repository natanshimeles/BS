package com.example.main.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.main.service.CreateUser;
import com.example.main.service.DeadlineUpdateService;
import com.example.main.service.RegisterNewPayment;
import com.example.main.service.RegsiterStudent;
import com.example.main.service.ResgiterSchools;
import com.example.main.service.SearchSchools;
import com.example.main.service.VerifyPassword;



@Controller
@SessionAttributes("myusername_server_ip_controller")
public class AdminController {
	@Autowired
	private RegsiterStudent registerstudent;
	@Autowired
	private ResgiterSchools register;
	@Autowired
	private CreateUser createuser;
	@Autowired
	private VerifyPassword verifypassword;
	@Autowired
	private DeadlineUpdateService deadlineupdateservice;
	@Autowired
	private SearchSchools searchschools;
	private ModelMap model = new ModelMap();
	@Autowired
	private RegisterNewPayment registernewpayment;
	
	@PostMapping("/regiternewpayment")
	public String regpay(@RequestParam("type")String type, @RequestParam("desc")String desc,Model error) {
		if(model.containsAttribute("myusername_server_ip_controller")) {
		registernewpayment.save(type, desc);
		}
		else {
			String unautorized="unautorized";
			error.addAttribute("error",unautorized);
		}
		return "index";
		
	}
	
	 @PostMapping("/admin")
	    public String adminverify(@RequestParam("aname") String  aname,@RequestParam("apassword") String apassword,Model error,Model parameters) {
	      
		
		   if( verifypassword.verify(aname, apassword)) {
			   model.addAttribute("myusername_server_ip_controller",aname);
			   String schools[]= searchschools.getschool();
			   String payments[]=searchschools.getpayments();
			   parameters.addAttribute("schools",schools);
			   parameters.addAttribute("payments",payments);
			   
	        	return "admin";
	        	}
	        else {
	        	String Wrongusername="wrong User name and password";
	        	error.addAttribute("error",Wrongusername);
	        	return "index";
	        }
	    	
	    }
		 
		 
	 
	 
	 @GetMapping("/admin")
	    public String adminverify(Model error) {
	      
		 if(model.containsAttribute("myusername_server_ip_controller")){
			 return "admin";
		 }
		 else {
			 String Wrongusername="unautorized";
	         error.addAttribute("error",Wrongusername);
		  
	        	return "index";
	        }
	    	
	    
	 }
	 @PostMapping("/updatedeadline")
	 public String updatedeadline(@RequestParam("deadline")String deadline,@RequestParam("school")String school,@RequestParam("paymenttext") String paymenttype,Model success) {
		  
		 if(model.containsAttribute("myusername_server_ip_controller")){
		 deadlineupdateservice.updateDeadline(school, deadline,paymenttype);
		 String succesful="succesful";
		 success.addAttribute("succesful",succesful);
		 }
		 return "index";
		 
		 
	 }

	
	@PostMapping("/createuser")
	public String saveusers(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname
			,@RequestParam("branch") String branch,@RequestParam("username") String username,
			@RequestParam("password") String password,Model success) {
		  
		 if(model.containsAttribute("myusername_server_ip_controller")){
		createuser.saveusers(firstname,lastname,branch,username,password);
		String succesful="succesful";
		 success.addAttribute("succesful",succesful);
		 }
		 return "index";

	}
	
	@PostMapping("/savenewpaymentdetail")
    public String savestudents(
    		@RequestParam("studentid") String studentid,
    		@RequestParam("firstname") String firstname,
    		@RequestParam("lastname") String lastname, 
    		@RequestParam("school") String school,
    		@RequestParam("paymenttype") String  paymenttype ,
    		@RequestParam("paymentamount") String paymentamount,
    		@RequestParam("deadline") String deadline,
    		@RequestParam("amounttime") String amounttime,
    		@RequestParam("amountpertime") String amountpertime,
    		@RequestParam("whattype") String whattype,
    		@RequestParam("forhowmanymonth") String forhowmanymonth
    		,Model success) {
		  
		 if(model.containsAttribute("myusername_server_ip_controller")){
        registerstudent.register(studentid,firstname,lastname,school,paymenttype,paymentamount,deadline,amounttime,amountpertime,whattype,forhowmanymonth);
        String succesful="succesful";
		 success.addAttribute("succesful",succesful);
		 }
		 return "index";
    }
	
	 @PostMapping("/registerschool")
	    public String registerschool(
	    		@RequestParam("schoolname") String school_name,@RequestParam("schooladdress") String school_address,Model success){
	    	register.saveschools(school_name, school_address);
	    	  
			 if(model.containsAttribute("myusername_server_ip_controller")){
	    	String succesful="succesful";
	    	success.addAttribute("succesful",succesful);
			 }
			 return "index";
	    }
  
	 @GetMapping("admin/logout")
		public String logout() {
		  
		 if(model.containsAttribute("myusername_server_ip_controller")){
			model.remove("myusername_server_ip_controller");
		 }
			return "index";
		}
 
}