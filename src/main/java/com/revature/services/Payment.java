package com.revature.services;

public interface Payment {

	// As an employee, I can view all payments.
	public void viewAllPayments();

	// As a customer, I can view my remaining payments for a car.
	public void remainingPayments();

	// As the system, I can calculate the monthly payment.
	public void calculatePayment();

}
