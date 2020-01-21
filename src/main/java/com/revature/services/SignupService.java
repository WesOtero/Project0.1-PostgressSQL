package com.revature.services;

import com.revature.dao.UserDAOPostgress;
import com.revature.pojo.User;

public class SignupService implements Signup{

	@Override
	public void signup(String username, String password) {
		UserDAOPostgress userDAO = new UserDAOPostgress();
		userDAO.createUser(new User(username, password));
	}

}
