package com.example.main.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.main.repository.SearchStudent;
import com.example.main.model.Student;

@Service
public class StudentSearchService<Student> {
	private SearchStudent searchstudent;
	
	public StudentSearchService(SearchStudent searchstudent) {
		this.searchstudent = searchstudent;
	}
	
	public List<com.example.main.model.Student> search(String id,String firstname, String lastname, String school) {
		
		
		
		if(firstname!="" && lastname=="" && school=="") {
			 List<com.example.main.model.Student> students =searchstudent.searchusingfirst(id,firstname);
			if(!students.isEmpty()) {
				return students;
			}
			else{
				com.example.main.model.Student s = new com.example.main.model.Student("empty","empty","empty","empty");
				com.example.main.model.Student[] emptystudent= {s};
				return Arrays.asList(emptystudent);
				
			}
			
		}
		else if(firstname=="" && lastname!="" && school=="") {
			 List<com.example.main.model.Student> students =searchstudent.searchusinglastname(id,lastname);
			
			
			if(!students.isEmpty()) {
				return  students;
			}
			else{
				com.example.main.model.Student s = new com.example.main.model.Student("empty","empty","empty","empty");
				com.example.main.model.Student[] emptystudent= {s};
				return Arrays.asList(emptystudent);
				
			}
			

			
		}
		else if(firstname=="" && lastname=="" && school!="") {
			List<com.example.main.model.Student> students =searchstudent.searchusingschool(id,school);
			
			if(!students.isEmpty()) {
				return  students;
			}
			else{
				com.example.main.model.Student s = new com.example.main.model.Student("empty","empty","empty","empty");
				com.example.main.model.Student[] emptystudent= {s};
				return Arrays.asList(emptystudent);
				
			}
			
			
		}
		
		else if(firstname=="" && lastname!="" && school!="") {
			List<com.example.main.model.Student> students =searchstudent.searchusinglastandschoolname(id,lastname,school);
		
			if(!students.isEmpty()) {
				return  students;
			}
			else{
				com.example.main.model.Student s = new com.example.main.model.Student("empty","empty","empty","empty");
				com.example.main.model.Student[] emptystudent= {s};
				return Arrays.asList(emptystudent);
				
			}
			
			
		}
		else if(firstname!="" && lastname!="" && school=="") {
			List<com.example.main.model.Student> students =searchstudent.searchusingfirstandlastname(id,firstname,lastname);
			if(!students.isEmpty()) {
				
				return  students;
			}
			else{
				com.example.main.model.Student s = new com.example.main.model.Student("empty","empty","empty","empty");
				com.example.main.model.Student[] emptystudent= {s};
				return Arrays.asList(emptystudent);
				
			}
			
			
		}
		else if(firstname!="" && lastname=="" && school!="") {
			List<com.example.main.model.Student> students =searchstudent.searchusingschoolandfirstname(id,firstname,school);
			if(!students.isEmpty()) {
				
				return  students;
			}
			else{
				com.example.main.model.Student s = new com.example.main.model.Student("empty","empty","empty","empty");
				com.example.main.model.Student[] emptystudent= {s};
				return Arrays.asList(emptystudent);
				
			}
			
			
		}
		else if(firstname!="" && lastname!="" && school!="") {
			List<com.example.main.model.Student> students =searchstudent.search(id,firstname,lastname,school);
			if(!students.isEmpty()) {
				return  students;
			}
			else{
				com.example.main.model.Student s = new com.example.main.model.Student("empty","empty","empty","empty");
				com.example.main.model.Student[] emptystudent= {s};
				return Arrays.asList(emptystudent);
				
			}
			
			
		}
		else {
			com.example.main.model.Student s = new com.example.main.model.Student("empty","empty","empty","empty");
			com.example.main.model.Student[] emptystudent= {s};
		    
		
			return Arrays.asList(emptystudent);
		}
		
		
	}

}
