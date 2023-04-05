package com.humber.j2ee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humber.j2ee.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

	public User findByUsername(String name);
	
}
