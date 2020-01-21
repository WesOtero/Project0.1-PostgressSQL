package com.revature.services;

import com.revature.dao.CarDAOPostgres;
import com.revature.dao.OfferDAOPostgres;
import com.revature.dao.PaymentDAOPostgress;
import com.revature.dao.UserDAOPostgress;
import com.revature.pojo.Car;
import com.revature.pojo.Offer;
import com.revature.pojo.User;

public class PaymentService implements PaymentActions{

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
		paymentDAO.createPayment(userId, carId, amount);
	}

	//System calculates payment
	@Override
	public Double calculatePayment(Integer userId, Integer carId) {
		Double amount = 0D;
		
		UserDAOPostgress userDAO = new UserDAOPostgress();
		CarDAOPostgres carDAO = new CarDAOPostgres();
		OfferDAOPostgres offerDAO = new OfferDAOPostgres();
		Car car = carDAO.readCar(carId);
		User user = userDAO.readUser(userId);
		Offer offer = offerDAO.readOffer(userId, carId);
		amount = offer.getAmount() / 24;
		//Update User
		//Udate Car
		return amount;
	}

}
