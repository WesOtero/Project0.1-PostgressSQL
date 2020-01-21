package com.revature.dao;

import java.util.List;

import com.revature.pojo.Payment;

public interface PaymentDAO {
	
	//Creates and calculates Payment
	public void createPayment(Integer userId, Integer carId, Double amount);

	public Payment readPayment(int id);

	public void updatePayment(Payment offer, int id);

	public void deletePayment(Payment offer);

	public List<Payment> readAllPayment();

	public List<Payment> readPaymentByType(String type);
}
