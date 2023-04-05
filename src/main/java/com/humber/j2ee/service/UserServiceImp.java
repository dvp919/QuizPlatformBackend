package com.humber.j2ee.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.humber.j2ee.model.User;
import com.humber.j2ee.model.UserRole;


@Service
public interface UserServiceImp {

	//Creating User
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
	
}
