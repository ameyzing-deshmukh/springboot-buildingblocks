package com.sadhanoday.springbootexamples.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadhanoday.springbootexamples.entities.User;
import com.sadhanoday.springbootexamples.repositories.UserRepository;

@Service
public class UserServiceClass {

	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers(){
		return userRepo.findAll();
	}

	public User createUser(User user) {
		return userRepo.save(user);
	}

	public Optional<User> getUserById(Long id) {
		Optional<User> user = userRepo.findById(id);
		return user;
	}

	public User updateUserById(User user, Long id) {
		user.setId(id);
		return userRepo.save(user);
	}
	
	public void deleteUserById(Long id) {
		if(userRepo.findById(id).isPresent()) {
			userRepo.deleteById(id);
		}
	}
	
	public User getUserByUsername(String username) {
		return userRepo.getUserByUserName(username);
	}

}
