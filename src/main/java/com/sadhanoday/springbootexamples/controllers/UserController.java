package com.sadhanoday.springbootexamples.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sadhanoday.springbootexamples.entities.User;
import com.sadhanoday.springbootexamples.services.UserServiceClass;

@RestController
public class UserController {

	@Autowired
	private UserServiceClass userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
//	@GetMapping(path="/getAllUsers")
//	public String getAllUsers(){
//		return "userService.getAllUsers()";
//	}
	
	//createUser
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id){
		return userService.getUserById(id);
	}
	
	@PutMapping("/users/{id}")
	public User updateUserById(@RequestBody User user, @PathVariable("id") Long id) {
		return userService.updateUserById(user, id);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
	
	@GetMapping("/users/byusername/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserByUsername(username); 
	}
	
}
