package com.revature.services;

import com.revature.dao.PaymentDAOPostgress;

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
		paymentDAO.createPayment(userId, carId, offerId);
	}

}
