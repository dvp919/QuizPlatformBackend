package com.humber.j2ee.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humber.j2ee.helper.UserFoundException;
import com.humber.j2ee.model.User;
import com.humber.j2ee.model.UserRole;
import com.humber.j2ee.repository.RoleRepository;
import com.humber.j2ee.repository.UserRepository;

@Service
public class UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	//Creating User
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {

		
		User local = this.userRepository.findByUsername(user.getUsername());
		
		//Check if user is available in database or not
		if(local!=null)
		{
			 System.out.println("User is already available in database...");
			 throw new UserFoundException();
		}
		else
		{
			//If user is not available in database then create User
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
				
			
		}
		
		return local;
	}

	//Get all Users
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}
	
	//Get User by username
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}


	//Delete User by id
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}
	
}
