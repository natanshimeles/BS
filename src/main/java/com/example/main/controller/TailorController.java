package com.example.main.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.main.model.Student;
import com.example.main.model.TotalPayment;
import com.example.main.service.Paynow;
import com.example.main.service.RegisterNewPayment;
import com.example.main.service.SearchFee;
import com.example.main.service.SearchSchools;
import com.example.main.service.StudentSearchService;
import com.example.main.service.Verifytailor;

@Controller
@SessionAttributes("myusername_server_ip_tailor_controller")
public class TailorController {
	@Autowired
	private SearchFee searchfee;
	private List<TotalPayment> fee ;
	List<TotalPayment> totalyearfee;
	@Autowired
	private Paynow paynow;
	@Autowired
	private SearchSchools searchschools;
	@Autowired
	private Verifytailor tailorverifypassword;
	@Autowired
	private StudentSearchService studentseacrchservice;
	private ModelMap model = new ModelMap();
	
	
	
	
	@GetMapping("/fee/paywhatowedtillnow/{school}/{id}/{firstname}/{lastname}")
	public String showfee(@PathVariable("id") String id ,@PathVariable("firstname") String firstname ,@PathVariable("lastname") String lastname,
			@PathVariable("school") String school,Model fees,Model error) {
		if(model.containsAttribute("myusername_server_ip_tailor_controller")) {
		fee = searchfee.search(id,firstname,lastname,school);
		fees.addAttribute("fee",fee.toString());
		fees.addAttribute("firstname",firstname);
		fees.addAttribute("lastname",lastname);
		fees.addAttribute("school",school);
		fees.addAttribute("id",id);
		return "showfee";
		}
		else {
			String unautorized="unautorized";
			error.addAttribute("error",unautorized);
			return "index";
		}
		
	}
	
	@GetMapping("/fee/payfullyearlypayment/{school}/{id}/{firstname}/{lastname}")
	public String showfeeyearly(@PathVariable("id") String id ,@PathVariable("firstname") String firstname ,@PathVariable("lastname") String lastname,
			@PathVariable("school") String school,Model fees,Model error) {
		if(model.containsAttribute("myusername_server_ip_tailor_controller")) {
		
		totalyearfee = searchfee.searchyearly(id,firstname,lastname,school);
		fees.addAttribute("fee",totalyearfee.toString());
		fees.addAttribute("firstname",firstname);
		fees.addAttribute("lastname",lastname);
		fees.addAttribute("school",school);
		fees.addAttribute("id",id);
		return "showfee";
		}
		else {
			String unautorized="unautorized";
			error.addAttribute("error",unautorized);
			return "index";
		}
	}
	@GetMapping("/paynow/payfullyearlypayment/{school}/{id}/{firstname}/{lastname}")
	public String payfullyear(@PathVariable("id") String id, @PathVariable("firstname") String firstname ,@PathVariable("lastname") String lastname,
			@PathVariable("school") String school,Model fees,Model error) {
		if(model.containsAttribute("myusername_server_ip_tailor_controller")) {
		double totalpayment = fee.get(fee.size()-1).getTotal();
		if(fee!=null){
		paynow.paywhatowed(id,firstname,lastname,school,totalpayment,fee);
		}
		}
		else {
			String unautorized="unautorized";
			error.addAttribute("error",unautorized);
			}
		return "index";
	}
	
	
	@GetMapping("/paynow/paywhatowedtillnow/{school}/{id}/{firstname}/{lastname}")
	public String paynow(@PathVariable("id") String id, @PathVariable("firstname") String firstname ,@PathVariable("lastname") String lastname,
			@PathVariable("school") String school) {
		
		if(model.containsAttribute("myusername_server_ip_tailor_controller")) {
			fee=searchfee.search(id,firstname,lastname,school);
		if(fee!=null){
			double totalpayment = fee.get(fee.size()-1).getTotal();
			paynow.paywhatowed(id,firstname,lastname,school,totalpayment,fee);
		}
		else {
			return "error";
		}
		}
		
		
		return "index";
	}

	@GetMapping("tailor/logout")
	public String logout() {
		if(model.containsAttribute("myusername_server_ip_tailor_controller")) {
		model.remove("myusername_server_ip_tailor_controller");
		}
		return "index";
	}
  
	@RequestMapping(method=RequestMethod.POST ,value="/Main")
    public String adminverify(@RequestParam(name="sname") String  sname,@RequestParam("spassword") String spassword,Model error) {
      if( tailorverifypassword.verifypass(sname, spassword)) {
    	  model.addAttribute("myusername_server_ip_tailor_controller",sname);
          return "Main";
        	}
        else {
        	String wup = "Wrong user Name and Password";
        	error.addAttribute("error",wup);
        	return "index";
        }
    	
    }
	
	@GetMapping("/Main")
	public String adminverify(Model error,Model params) {
		String schools[]= searchschools.getschool();
		if(model.containsAttribute("myusername_server_ip_tailor_controller")) {
			
			params.addAttribute("schools", schools);    
			return "Main";
		}
		else {
			String unauthorized = "unauthorized";
        	error.addAttribute("error",unauthorized);
			return "index";
			
		}
	        	
	        
	    	
	    }
	
	@GetMapping("/search")
	public String search(Model error,Model params) {
		if(model.containsAttribute("myusername_server_ip_tailor_controller")) {
			String[] schools= searchschools.getschool();
			params.addAttribute("schools", schools);
			return "Main";
		}
		else {
			String unauthorized = "unauthorized";
        	error.addAttribute("error",unauthorized);
			return "index";
			
		}
	       
		
	}
	
	
	
	
	@PostMapping("/search")
	public String search(@RequestParam("studentid")String studentid,@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname ,@RequestParam("school") String school,@RequestParam("paymenttype") String paymenttype,
			Model models) {
		
		List<Student> students= studentseacrchservice.search(studentid,firstname,lastname,school);
		String firstn = students.get(0).getFirstname();
		String lastn = students.get(0).getLastname();
		String schooln = students.get(0).getSchool();	
		String id=students.get(0).getId();
		models.addAttribute("stuid",id);
		models.addAttribute("firstname",firstn);
		models.addAttribute("lastname",lastn);
		models.addAttribute("school",schooln);
		models.addAttribute("paymenttype",paymenttype);
		return "show";
	}
	
}
