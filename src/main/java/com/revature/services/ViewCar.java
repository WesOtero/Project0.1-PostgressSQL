package com.revature.services;

import java.util.List;

import com.revature.pojo.Car;

public interface ViewCar {
	
	// As a customer, I can view the cars on the lot.
	public List<Car> customerCarView();

	// As a customer, I can make an offer for a car.
	public List<Car> ownerView(Integer userId);
}
