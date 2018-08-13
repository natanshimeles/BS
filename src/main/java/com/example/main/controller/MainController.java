package com.example.main.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
class MainController {
	/*
	
	@Autowired
	private StudentSearchService studentseacrchservice;
	@Autowired
	private ResgiterSchools register;
	@Autowired
	private SearchFee searchfee;
	
	
	



    /*
    @RequestMapping(method=RequestMethod.POST,value="/topics")
    public void addstudent(@RequestBody String name) {
    	mainservice.addservice(name);
    	
    }
    
    */
   
    
    /*
     * 
     * 

    //@RequestBody and @RequestParam
    @RequestMapping(method=RequestMethod.POST,value="/admin")
    public String adminverify(@RequestParam("aname") String  aname,@RequestParam("apassword") String apassword,Model model) {
      if( verifypassword.verify(aname, apassword)) {
    	  model.addAttribute("aname",aname);
    	  model.addAttribute("apassword",apassword);
        	return "admin";
        	}
        else {
        	return "error";
        }
    	
    }
    
	 
	 
    @PostMapping("/studentverify")
    public String studentverify() {
        return "student-verify!";
    }
    
   
   
    
    
    /*this also works
     *@RequestMapping("/aboutus/{name}")
    public String name(@PathVariable String id) {
        return id+"!";
    }
    @RequestMapping("/aboutus/{foo}")
    public String foo(@PathVariable("foo") String id) {
        return id;
    }
    
    @RequestMapping("/contactus")
    public List<String> contactus() {
        return mainservice.getstudents();
    }
    */
    
    //this case foo is id
    
    
        


    
    
        


}
