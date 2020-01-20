package com.revature.services;

public interface Authenticate {

	// As a user, I can login.
	public boolean authenticate(Integer id, String username, String password);
}
