package com.revature.services;

public interface OfferActions {
	// As a customer, I can make an offer for a car.
	public void addOffer(Integer userid, Integer carid, Double amount);
	
	// As an employee, I can accept or reject an offer for a car.
	public void acceptOffer();
	
	// As an employee, I can accept or reject an offer for a car.
	public void rejectOffer();
	
	// As the system, I reject all other pending offers for a car when an offer is accepted.
	public void rejectAllOffer();
}
