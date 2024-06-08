package com.bike.on.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bike.on.rent.model.User;
import com.bike.on.rent.service.UserService;

//@Controller

@RestController // it is combination of @Controller and @ResponseBody
@RequestMapping("/BikeRentalApplication/users")
public class UserController {
	
	@Autowired
	private UserService userService;
//	@RequestMapping(value = "/", method=RequestMethod.GET)
	@GetMapping("/")  //replacement of above code
//	@ResponseBody
	public User home() {
		
		User user = new User("Ravi","ravi@gmail.com","45436263", "ravi","USER");
		return user;
	}
	
	
	
//	@RequestMapping(value = "/about", method=RequestMethod.POST)
//	@ResponseBody
	@PostMapping("")
	public User registerUser(@RequestBody User user) {
		
		user = userService.saveUser(user);
		return user;
		
	}

}
