package com.revature.services;

import com.revature.dao.OfferDAOPostgres;
import com.revature.pojo.Offer;

public class OfferService implements OfferActions{

	@Override
	public void addOffer(Integer userid, Integer carid, Double amount) {
		// TODO Auto-generated method stub
		OfferDAOPostgres offerDAO = new OfferDAOPostgres();
		offerDAO.createOffer(new Offer(userid, carid, amount));
	}

	@Override
	public void acceptOffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectOffer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectAllOffer() {
		// TODO Auto-generated method stub
		
	}

}
