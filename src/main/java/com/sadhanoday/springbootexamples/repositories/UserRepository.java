package com.sadhanoday.springbootexamples.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sadhanoday.springbootexamples.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User getUserByUserName(String userName);

}
