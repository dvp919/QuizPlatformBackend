package com.humber.j2ee.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humber.j2ee.model.Role;
import com.humber.j2ee.model.User;
import com.humber.j2ee.model.UserRole;
import com.humber.j2ee.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/test")
	public String test() {
		return "Welcome to backend API of QuizPortal";
	}
	
	//Creating User
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception
	{
		
		user.setProfile("default.png");	
		//encoding password with BCryptpasswordEncoder
		
		
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		
		Set<UserRole> roles = new HashSet<>();
		
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("NORMAL");
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
		
	}
	
	
	//Getting All Users
	@GetMapping("/")
	public List<User> getAllUser()
	{
		return this.userService.getAllUser();
	}
	
	
	//Getting Users by username
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username)
	{
		return this.userService.getUser(username);
	}
	
	
	//Deleting User by userId
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId)
	{
		this.userService.deleteUser(userId);
	}

	
	
	
}
