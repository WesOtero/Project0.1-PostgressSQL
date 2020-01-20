package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Car;
import com.revature.util.ConnectionFactory;
import com.revature.util.LogUtil;

public class CarDAOPostgres implements CarDAO {

	@Override
	public void createCar(Car car) {
		//Creates a car
		String sql = "insert into car(make, model, year, price, owners) values('" + car.getMake() + "', '"  + car.getModel() + "', '" + car.getYear() + "', '" + car.getPrice() + "', '" + car.isOwned() + "')";
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			LogUtil.info("Vehicle added.");
		} catch (SQLException e) {
			LogUtil.trace(e.getMessage());
			
		} finally {
			try {
				conn.close();
				LogUtil.trace("Connection Closed");
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.trace(e.getMessage());
			}
		}
	}

	@Override
	public Car readCar(int id) {
		
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
		String sql = "Select * from car";
		
		Connection conn = ConnectionFactory.getConnection();
		
		List<Car> carList= new ArrayList<>();
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			
			while(resultSet.next()) {
				carList.add(new Car(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDouble(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return carList;
	}

	@Override
	public List<Car> readCarsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}
		
	public String readLastCar() {
		//Returns a string with the last car inserted for unit testing
		String result = "", sql = "Select make from car where carid = 10";
		Statement stmt = null;
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			System.out.println(result + "<<");
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			
			while(resultSet.next()) {
//				open
//				result = resultSet.getCursorName()
			}
			System.out.println("***");
			LogUtil.info("Last car was return.");
		} catch (SQLException e) {
			LogUtil.trace(e.getMessage());
			
		} finally {
			try {
				conn.close();
				LogUtil.trace("Connection Closed.");
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.trace(e.getMessage());
			}
		}
		return result;
	}
}
