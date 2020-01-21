package com.revature.services;

import com.revature.dao.CarDAOPostgres;
import com.revature.pojo.Car;

public class AddCarService implements AddCar{

	@Override
	public void addCar(String make, String model, String year, Double price) {
		CarDAOPostgres carDAO = new CarDAOPostgres();
		carDAO.createCar(new Car(make, model, year, price));	
	}

}
