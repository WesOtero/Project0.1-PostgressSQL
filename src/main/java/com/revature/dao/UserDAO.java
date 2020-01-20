package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public interface UserDAO {

	public void createUser(User pet);

	public User readUser(int id);

	public void updateUser(User pet, int id);

	public void deleteUser(User user);

	public List<User> readAllUsers();

	public List<User> readUsersByType(String type);

}
