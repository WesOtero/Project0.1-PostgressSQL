package com.revature.services;

import com.revature.pojo.User;

public interface Authenticate {

	// As a user, I can login.
	public boolean authenticate(Integer id, String username, String password);
	
	//Gets User ID
	public User getUserByUsername(String username);
}
