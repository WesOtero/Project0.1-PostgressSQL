package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public interface UserDAO {

	public void createUser(User pet);

	public User readUser(Integer id);

	public User readUserByUserame(String username);
	
	public void updateUserPayment(Double offer, Integer userId);

	public void deleteUser(User user);
	
	public void viewRemainingBalance(Integer userId);

	public List<User> readAllUsers();


}
