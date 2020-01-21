package com.revature.services;

import com.revature.dao.CarDAOPostgres;
import com.revature.dao.OfferDAOPostgres;
import com.revature.dao.PaymentDAOPostgress;
import com.revature.dao.UserDAOPostgress;
import com.revature.pojo.Offer;
import com.revature.pojo.User;

public class PaymentService implements PaymentActions {

	@Override
	public void viewAllPayments() {
		// TODO Auto-generated method stub

	}

	@Override
	public void remainingPayments() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPayments(Integer userId, Integer carId, Integer offerId) {
		// TODO Auto-generated method stub
		PaymentDAOPostgress paymentDAO = new PaymentDAOPostgress();
		Double amount = calculatePayment(userId, carId);

		UserDAOPostgress userDAO = new UserDAOPostgress();
		CarDAOPostgres carDAO = new CarDAOPostgres();

		OfferDAOPostgres offerDAO = new OfferDAOPostgres();
		Offer offer = offerDAO.readOffer(userId, carId);
		
		// Car gets an owner and a new price for future reference
		carDAO.updateCarOwner(userId, carId, offer.getAmount());
		// Updates the payment based on offer
		userDAO.updateUserPayment(offer.getAmount(), userId);

		paymentDAO.createPayment(userId, carId, amount);

	}

	// System calculates payment
	@Override
	public Double calculatePayment(Integer userId, Integer carId) {
		Double amount = 0D;

		OfferDAOPostgres offerDAO = new OfferDAOPostgres();
		Offer offer = offerDAO.readOffer(userId, carId);
		// System calculates the rate of the payment
		amount = offer.getAmount() / 24;
		return amount;
	}

	@Override
	public void userRemaningBlance(Integer userId) {
		UserDAOPostgress userDAO = new UserDAOPostgress();
		User user = userDAO.readUser(userId);
		System.out.println(user.getRemainingBalance());
	}

}
