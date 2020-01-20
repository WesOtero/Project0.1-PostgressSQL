package com.revature.driver;

import com.revature.dao.CarDAOPostgres;
import com.revature.pojo.Car;

public class Driver {

	public static void main(String[] args) {
		CarDAOPostgres carDAO = new CarDAOPostgres();
		carDAO.createCar(new Car("Nissan", "Altima", "2016-01-01", 20000D));
	}

}
