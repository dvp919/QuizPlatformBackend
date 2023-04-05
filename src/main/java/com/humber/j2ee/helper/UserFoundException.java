package com.humber.j2ee.helper;

public class UserFoundException extends Exception {
	
	public UserFoundException() {
		super("User already in database with same username !! try with different username");
	}
	
	public UserFoundException(String msg) {super(msg);}

}
