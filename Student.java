package com.greatlearning.springJDBC.entity;

public class Student {
	private String name;
	private String department;
	private String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
 @Override
public String toString() {
	  return "Student [name:- "+name+"\ndepartment:- "+department+"\ncountry:- "+country+"]";
 }
}

