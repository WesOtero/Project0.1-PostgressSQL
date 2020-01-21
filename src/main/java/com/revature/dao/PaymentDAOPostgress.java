package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Payment;
import com.revature.util.ConnectionFactory;
import com.revature.util.LogUtil;

public class PaymentDAOPostgress implements PaymentDAO {

	//Happens last
	@Override
	public void createPayment(Integer userId, Integer carId, Double amount) {
		// TODO Auto-generated method stub
		
		String sql = "insert into offer(userid, carid) values('" + userId + "', '" + carId + "')";
		Connection conn = ConnectionFactory.getConnection();

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			LogUtil.info("Payment added.");
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
	public Payment readPayment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePayment(Payment offer, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePayment(Payment offer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Payment> readAllPayment() {
		String sql = "Select * from payment";

		Connection conn = ConnectionFactory.getConnection();

		List<Payment> payments = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				payments.add(new Payment(resultSet.getInt(1), resultSet.getNString(2), resultSet.getInt(3), resultSet.getInt(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return payments;
	}

	@Override
	public List<Payment> readUserPayment(Integer userId) {
		// TODO Auto-generated method stub
		String sql = "Select * from payment where userid =" + userId;

		Connection conn = ConnectionFactory.getConnection();

		List<Payment> payments = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				payments.add(new Payment(resultSet.getInt(1), resultSet.getNString(2), resultSet.getInt(3), resultSet.getInt(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return payments;
	}
	
	

}
