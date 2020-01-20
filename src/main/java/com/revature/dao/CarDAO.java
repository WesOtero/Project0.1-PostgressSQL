package com.revature.dao;

import java.util.List;

import com.revature.pojo.Car;

public interface CarDAO {

	public void createCar(Car pet);

	public Car readCar(int id);

	public void updateCar(Car car, int id);

	public void deleteCar(Car car);

	public List<Car> readAllCars();

	public List<Car> readCarsByType(String type);
}
