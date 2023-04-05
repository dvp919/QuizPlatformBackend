package com.humber.j2ee;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.humber.j2ee.model.Role;
import com.humber.j2ee.model.User;
import com.humber.j2ee.model.UserRole;
import com.humber.j2ee.service.UserService;

@SpringBootApplication
public class QuizPlatformApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncorder;
	
	public static void main(String[] args) {
		
		SpringApplication.run(QuizPlatformApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Starting connection...");
		
//
//
//		User user = new User();
//
//
//		user.setFirstName("Dhruv");
//		user.setLastName("patel");
//		user.setUsername("dhruvpatel");
//		user.setPassword(this.bCryptPasswordEncorder.encode("dhruvpatel"));
//		user.setPhone("4167684552");
//		user.setEmail("dhruvpatel22021998@gmail.com");
//		user.setProfile("default.png");
//
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//
//		UserRole userRole = new UserRole();
//
//		userRole.setRole(role1);
//
//		userRole.setUser(user);
//
//		userRoleSet.add(userRole);
//
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());
		
	}

}
