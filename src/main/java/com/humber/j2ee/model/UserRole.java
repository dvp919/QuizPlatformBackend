package com.humber.j2ee.model;

import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserRole {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;

	
	//User
	@ManyToOne(fetch = FetchType.EAGER)
	private User user;
	
	
	//Role
	@ManyToOne
	private Role role;
	
	
	// UserRole class
	@Override
	public int hashCode() {
	    return Objects.hash(userRoleId);
	}
}
