package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.pojo.Payment;
import com.revature.util.ConnectionFactory;
import com.revature.util.LogUtil;

public class PaymentDAOPostgress implements PaymentDAO {

	@Override
	public void createPayment(Integer userId, Integer carId, Integer offerId) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> readPaymentByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}