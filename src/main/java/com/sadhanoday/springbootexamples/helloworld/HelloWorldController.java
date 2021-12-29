package com.sadhanoday.springbootexamples.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sadhanoday.springbootexamples.beans.EmployeeDetails;

@RestController
public class HelloWorldController {

	@RequestMapping(method=RequestMethod.GET, path="/getHelloWorldRM")
	public String getHelloWorldRM() {
		return "Hello World with Request Mapping";
	}

	@GetMapping(path="/getHelloWorldGM")
	public String getHelloWorldGM() {
		return "Hello World with Get Mapping";
	}

	@GetMapping(path="/getEployeeBean")
	public EmployeeDetails getEmployeeBean() {
		return new EmployeeDetails("Amey", "Deshmukh", "Jabalpur");
	}
	
}
