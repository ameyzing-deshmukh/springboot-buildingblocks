package com.sadhanoday.springbootexamples.beans;

public class EmployeeDetails {

	private String firstName;
	private String lastName;
	private String city;
	
	//Created Constructor
	public EmployeeDetails(String firstName, String lastName, String city) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	
	//Generated Getters and Setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	//Created toString
	@Override
	public String toString() {
		return "EmployeeDetails [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + "]";
	}
	
	
	
}
