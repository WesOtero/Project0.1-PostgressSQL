package com.revature.dao;

import java.util.List;

import com.revature.pojo.Offer;

public interface OfferDAO {
	public void createOffer(Offer offer);

	public Offer readOffer(int id);

	public void updateOffer(Offer offer, int id);

	public void deleteOffer(Offer offer);

	public List<Offer> readAllOffers();

	public List<Offer> readOfferByType(String type);
}
