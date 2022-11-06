package com.ty.BirthdayApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.BirthdayApp.dto.ResponseStructure;
import com.ty.BirthdayApp.dto.User;
import com.ty.BirthdayApp.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/users")
	public ResponseStructure<List<User>> getAllUsers() {
		return userService.getAllUserData();
	}

	@GetMapping("/users/{id}")
	public ResponseStructure<User> getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@DeleteMapping("/users/{id}")
	public ResponseStructure<String> deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);

	}

	@PutMapping("/users/{id}")
	public ResponseStructure<User> updateUser(@RequestBody User user,@PathVariable int id) {
		return userService.updateUser(user,id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<User>> login(@RequestBody User user){
		System.out.println(user.getEmail());
		
		return userService.login(user);
		
	}
	
//	@GetMapping("/userstaff")
//	public ResponseStructure<List<User>> getUserById() {
//		return userService.getUserByrole("staff");
//	}

	

}
