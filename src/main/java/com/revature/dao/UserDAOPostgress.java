package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;
import com.revature.util.LogUtil;

public class UserDAOPostgress implements UserDAO {

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into users(usrname, passwd, employee_role) values('" + user.getUsername() + "', '"
				+ user.getPassword() + "', '" + user.isEmployee_role() + "')";

		Connection conn = ConnectionFactory.getConnection();

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			LogUtil.info("User added.");
		} catch (SQLException e) {
			LogUtil.trace(e.getMessage());
		} finally {
			try {
				conn.close();
				LogUtil.trace("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.trace(e.getMessage());
			}
		}

	}

	@Override
	public User readUser(Integer id) {
		String sql = "Select * from users where userid =" + id;

		Connection conn = ConnectionFactory.getConnection();

		User user;

		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			resultSet.next();
			user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
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

	//Return user
	@Override
	public User readUserByUserame(String username) {
		String sql = "Select * from users where usrname ='" + username + "'";

		Connection conn = ConnectionFactory.getConnection();

		User user;

		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			resultSet.next();
			System.out.println(resultSet.getString(2) + "<");
			user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
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
	// Updates user payment by using the business logic of a 2 year payment plan
	public void updateUserPayment(Double offer, Integer userId) {
		// TODO Auto-generated method stub
		String sql = "UPDATE car SET monthlypayment ='" + offer / 24 + "', SET remainingbalance ='" + offer
				+ "' WHERE userid =" + userId + "'";
		Connection conn = ConnectionFactory.getConnection();

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			LogUtil.info("User Record Updated.");
		} catch (SQLException e) {
			LogUtil.trace(e.getMessage());

		} finally {
			try {
				conn.close();
				LogUtil.trace("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.trace(e.getMessage());
			}
		}

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
	public void viewRemainingBalance(Integer userId) {
		// TODO Auto-generated method stub
	}

}
