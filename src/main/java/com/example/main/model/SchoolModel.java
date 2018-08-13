package com.example.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolModel {
	private String schooolname;
	private String schooladdress;
	public String getSchooolname() {
		return schooolname;
	}
	
	public void setSchooolname(String schooolname) {
		this.schooolname = schooolname;
	}
	public String getSchooladdress() {
		return schooladdress;
	}
	public void setSchooladdress(String schooladdress) {
		this.schooladdress = schooladdress;
	}
	@Override
	public String toString() {
		return "SchoolModel [schooolname=" + schooolname + ", schooladdress=" + schooladdress + "]";
	}
	public SchoolModel(String schooolname, String schooladdress) {
		super();
		this.schooolname = schooolname;
		this.schooladdress = schooladdress;
	}
	

}
