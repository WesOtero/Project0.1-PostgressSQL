package com.revature.driver;

import java.util.List;

import com.revature.dao.CarDAOPostgres;
import com.revature.pojo.Car;

public class Driver {

	public static void main(String[] args) {
		CarDAOPostgres carDAO = new CarDAOPostgres();
		List<Car> cars = carDAO.readAllCars();
		
		for (Car car : cars) {
			System.out.println(car.getMake());
		}
	}

}
