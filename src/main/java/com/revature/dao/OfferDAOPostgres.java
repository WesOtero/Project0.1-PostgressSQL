package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.pojo.Offer;
import com.revature.util.ConnectionFactory;
import com.revature.util.LogUtil;

public class OfferDAOPostgres implements OfferDAO {

	@Override
	public void createOffer(Offer offer) {
		// TODO Auto-generated method stub
		// Creates a car
		String sql = "insert into offer(amount, accepted, removed, userid, carid) values('" + offer.getAmount() + "', '"
				+ offer.isAccepted() + "', '" + offer.isRemoved() + "', '" + offer.getUserId() + "', '"
				+ offer.getCarId() + "')";
		Connection conn = ConnectionFactory.getConnection();

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			LogUtil.info("Offer added.");
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
	public Offer readOffer(Integer userId, Integer carId) {
		String sql = "Select * from user where userid = '" + userId + "AND carid ='" + carId + "'";

		Connection conn = ConnectionFactory.getConnection();

		Offer offer;

		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			offer = new Offer(resultSet.getInt(1), resultSet.getDouble(2), resultSet.getBoolean(3),
					resultSet.getBoolean(4), resultSet.getInt(5), resultSet.getInt(6));
			return offer;
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
	public void updateOffer(Offer offer, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOffer(Integer offerId) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM offer WHERE offerid ='" + offerId + "'";
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
	public List<Offer> readAllOffers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Offer> readOfferByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acceptOffer(Integer offerId) {
		// TODO Auto-generated method stub
		String sql = "UPDATE offer SET accepted = true WHERE offerId =" + offerId;
		Connection conn = ConnectionFactory.getConnection();

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			LogUtil.info("Offer Updated.");
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

//	@Override
//	public void rejectOffer(Integer offerId) {
//		// TODO Auto-generated method stub
//		
//	}
}
