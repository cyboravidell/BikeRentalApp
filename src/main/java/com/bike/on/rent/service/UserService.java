package com.bike.on.rent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bike.on.rent.dto.UserLoginDTO;
import com.bike.on.rent.dto.UserUpdateDTO;
import com.bike.on.rent.model.User;
import com.bike.on.rent.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		
		
		if(!userRepository.existsByEmail(user.getEmail())) {
			
			user = userRepository.save(user);
			return user;
			
		}
		
		return null;
		
	}

	public User userLogin(UserLoginDTO userLoginDTO) {
		
		return userRepository.findByEmailAndPassword(userLoginDTO.getEmail(),userLoginDTO.getPassword());
		
	}

	public User updateUser(UserUpdateDTO userUpdateDTO) {
		User user = userRepository.findByEmail(userUpdateDTO.getEmail());
		System.out.println(user);
		System.out.println(userUpdateDTO);
		if(user != null) {
			System.out.println("Inside cond.");
			if(userUpdateDTO.getNewName() != null && !userUpdateDTO.getNewName().isEmpty()) {
				user.setName(userUpdateDTO.getNewName());
			}
			if(userUpdateDTO.getNewPhoneNo() != null && !userUpdateDTO.getNewPhoneNo().isEmpty()) {
				user.setPhoneNo(userUpdateDTO.getNewPhoneNo());
			}
			if(userUpdateDTO.getNewPassword() != null && !userUpdateDTO.getNewPassword().isEmpty()) {
				user.setPassword(userUpdateDTO.getNewPassword());
			}
			
			return userRepository.save(user);
		}
		return null;
	}

	public User deleteUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		if(user != null) {
			userRepository.delete(user);
			
		}
		return user;
	}

	

}
