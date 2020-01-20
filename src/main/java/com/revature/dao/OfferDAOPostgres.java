package com.revature.dao;

import java.sql.Connection;
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
	public Offer readOffer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateOffer(Offer offer, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOffer(Offer offer) {
		// TODO Auto-generated method stub

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

}
