package com.revature.services;

import com.revature.dao.UserDAOPostgress;
import com.revature.pojo.User;
import com.revature.util.LogUtil;

public class AuthenticationService implements Authenticate {

	@Override
	public boolean authenticate(Integer id, String username, String password) {
		UserDAOPostgress userDAO = new UserDAOPostgress();
		User user = userDAO.readUser(id);
		if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			LogUtil.info("Success.");
			return true;
		} else {
			LogUtil.info("The User and Password combination is not valid.");
		}

		return false;
	}

	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		UserDAOPostgress userDAO = new UserDAOPostgress();
		return userDAO.readUserByUserame(username);
		
	}

}
