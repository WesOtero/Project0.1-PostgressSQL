package com.revature.services;

import com.revature.dao.CarDAOPostgres;

public class CarRemovalService implements RemoveCar{

	@Override
	public void removeCar(Integer carId) {
		// TODO Auto-generated method stub
		CarDAOPostgres carDAO = new CarDAOPostgres();
		carDAO.deleteCar(carId);
	}

}
