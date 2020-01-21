package com.revature.dao;

import java.util.List;

import com.revature.pojo.Offer;

public interface OfferDAO {
	public void createOffer(Offer offer);

	public Offer readOffer(Integer userId, Integer carId);

	public void updateOffer(Offer offer, int id);
	
	public void acceptOffer(Integer offerId);

	public void deleteOffer(Integer offerId);

	public List<Offer> readAllOffers();

	public List<Offer> readOfferByType(String type);
}
