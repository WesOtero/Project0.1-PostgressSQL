package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;

public class UserDAOPostgress implements UserDAO {

	@Override
	public void createUser(User pet) {
		// TODO Auto-generated method stub

	}

	@Override
	public User readUser(int id) {
		String sql = "Select * from user where userid = '" + id + "'";

		Connection conn = ConnectionFactory.getConnection();

		User user;

		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			user = new User(resultSet.getInt(1), resultSet.getNString(2), resultSet.getNString(3),
					resultSet.getNString(4), resultSet.getNString(5), resultSet.getBoolean(6));
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void updateUser(User pet, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> readAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readUsersByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
