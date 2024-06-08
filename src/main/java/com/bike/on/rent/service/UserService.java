package com.bike.on.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.on.rent.model.User;
import com.bike.on.rent.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public User saveUser(User user) {
		
		user = userRepository.save(user);
		
		return user;
		
	}

}
