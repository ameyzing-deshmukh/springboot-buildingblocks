package com.sadhanoday.springbootexamples.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sadhanoday.springbootexamples.customexceptions.UserExistsException;
import com.sadhanoday.springbootexamples.customexceptions.UserNotFoundException;
import com.sadhanoday.springbootexamples.entities.User;
import com.sadhanoday.springbootexamples.repositories.UserRepository;

@Service
public class UserServiceClass {

	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers(){
		return userRepo.findAll();
	}

	public User createUser(User user) throws UserExistsException{
		User existingUser = userRepo.getUserByUserName(user.getUserName());
		if(null != existingUser) {
			throw new UserExistsException("User already exists in repository. Please provide details for new User.");
		}
		return userRepo.save(user);
	}

	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found in repository");
		}
		return user;
	}

	public User updateUserById(User user, Long id) throws UserNotFoundException{
		Optional<User> optionalUser = userRepo.findById(id);
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found in repository, please provide correct user id.");
		}
		user.setId(id);
		return userRepo.save(user);
	}

	public void deleteUserById(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		if(!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found in repository, please provide correct user id.");
		}
			userRepo.deleteById(id);
	}

	public User getUserByUsername(String username) {
		return userRepo.getUserByUserName(username);
	}

}
