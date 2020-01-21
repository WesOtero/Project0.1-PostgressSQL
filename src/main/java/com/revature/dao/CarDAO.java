package com.revature.dao;

import java.util.List;

import com.revature.pojo.Car;

public interface CarDAO {

	public void createCar(Car pet);

	public Car readCar(int id);

	public void updateCar(Car car, int id);

	public void deleteCar(Integer carId);

	public List<Car> readAllCars();
	
	public List<Car> readAllCarsOnLot();

	public List<Car> readCarsOwned(Integer customerId);
}
