package com.revature.services;

import java.util.List;

import com.revature.dao.CarDAOPostgres;
import com.revature.pojo.Car;

public class ViewCarService implements ViewCar {

	//If there is not owner then the car is on the lot
	@Override
	public List<Car> customerCarView() {
		CarDAOPostgres carDAO = new CarDAOPostgres();
		return carDAO.readAllCarsOnLot();
		
	}

	//If there is an owner then see who is it and show it
	@Override
	public List<Car> ownerView(Integer userId) {
		CarDAOPostgres carDAO = new CarDAOPostgres();
		return carDAO.readCarsOwned(userId);
	}

}
