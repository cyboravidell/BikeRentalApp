package com.bike.on.rent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bike.on.rent.dto.UserLoginDTO;
import com.bike.on.rent.dto.UserUpdateDTO;
import com.bike.on.rent.model.User;
import com.bike.on.rent.service.UserService;

//@Controller

@RestController // it is combination of @Controller and @ResponseBody
@RequestMapping("/BikeRentalApplication/users")
public class UserController {

	@Autowired
	private UserService userService;

//	@RequestMapping(value = "/", method=RequestMethod.GET)
	@GetMapping("/") // replacement of above code
//	@ResponseBody
	public ResponseEntity<String> userLogin(@RequestBody UserLoginDTO userLoginDTO) {

		if (userService.userLogin(userLoginDTO) != null) {
			return ResponseEntity.status(HttpStatus.OK).body("User Succusfully Logged-In !!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Credential provided !!");
	}

//	@RequestMapping(value = "/about", method=RequestMethod.POST)
//	@ResponseBody
	@PostMapping("/")
	public ResponseEntity<String> registerUser(@RequestBody User user) {

		if (userService.saveUser(user) != null) {

			return ResponseEntity.status(HttpStatus.CREATED)
					.body("User with email = " + user.getEmail() + " registered Successfully.");

		}
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body("User with email = " + user.getEmail() + " already Exist.");

	}

	@PutMapping("/")
	public ResponseEntity<String> updateUser(@RequestBody UserUpdateDTO userUpdateDTO) {
		User user = userService.updateUser(userUpdateDTO);
		if (user != null) {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body("User Details updated Succesfully = " + user.toString());
		}
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body("User Not existed with given email = " + userUpdateDTO.getEmail());
	}

	@DeleteMapping("/")
	public ResponseEntity<String> deleteUser(@RequestParam(name = "email") String email) {
		User user = userService.deleteUserByEmail(email);

		if (user != null) {
			return ResponseEntity.status(HttpStatus.OK).body("User details deleted successfully with email = "+email);
			
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User details Not existed  with email = "+email);
	}

}
