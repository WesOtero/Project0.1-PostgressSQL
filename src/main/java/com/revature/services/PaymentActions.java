package com.revature.services;

public interface PaymentActions {

	// As an employee, I can view all payments.
	public void viewAllPayments();

	// As a customer, I can view my remaining payments for a car.
	public void remainingPayments();

	// As the system, I can calculate the monthly payment.
	// SideNote: the payments are calculated when created...
	public void createPayments(Integer userId, Integer carId, Integer offerId);
	
	//Does the calculation by diving the offer amount buy 24 months.
	public Double calculatePayment(Integer userId, Integer carId, Integer offetId);

}
