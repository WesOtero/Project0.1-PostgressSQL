package com.revature.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.pojo.Car;
import com.revature.util.ConnectionFactory;

public class CarDAOPostgres implements CarDAO {

	@Override
	public void createCar(Car car) {
		String sql = "insert into car(make, model, year, price, owners) values('" + car.getMake() + "', '"  + car.getModel() + "', '" + car.getYear() + "', '" + car.getPrice() + "', '" + car.isOwned() + "')";
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Car readCar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCar(Car car, int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCar(Car car) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Car> readAllCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> readCarsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
