package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Car;
import com.revature.pojo.User;
import com.revature.util.ConnectionFactory;
import com.revature.util.LogUtil;

public class CarDAOPostgres implements CarDAO {

	@Override
	public void createCar(Car car) {
		// Creates a car
		String sql = "insert into car(make, model, year, price, owners) values('" + car.getMake() + "', '"
				+ car.getModel() + "', '" + car.getYear() + "', '" + car.getPrice() + "', '" + car.isOwned() + "')";
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
		String sql = "Select * from user where userid = '" + id + "'";

		Connection conn = ConnectionFactory.getConnection();

		Car car;

		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);
			car = new Car(resultSet.getInt(1), resultSet.getNString(2), resultSet.getNString(3),
					resultSet.getNString(4), resultSet.getDouble(5), resultSet.getBoolean(6), resultSet.getInt(7));
			return car;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void updateCar(Car car, int id) {
		// TODO Auto-generated method stub

	}

	// After car is deleted the next time the user request to view the lot it should
	// query the table again.
	@Override
	public void deleteCar(Integer carId) {
		// TODO Auto-generated method stub
		String sql = "Delete from car where carid = ;'" + carId + "'";

		Connection conn = ConnectionFactory.getConnection();

		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			LogUtil.info("Car Deleted.");
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
	public List<Car> readAllCars() {
		String sql = "Select * from car";

		Connection conn = ConnectionFactory.getConnection();

		List<Car> carList = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				carList.add(new Car(resultSet.getInt(1), resultSet.getNString(2), resultSet.getNString(3),
						resultSet.getNString(4), resultSet.getDouble(5), resultSet.getBoolean(6), resultSet.getInt(7)));
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

	public List<Car> readAllCarsOnLot() {
		String sql = "Select * from car where owners = false";

		Connection conn = ConnectionFactory.getConnection();

		List<Car> carList = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				carList.add(new Car(resultSet.getInt(1), resultSet.getNString(2), resultSet.getNString(3),
						resultSet.getNString(4), resultSet.getDouble(5), resultSet.getBoolean(6), resultSet.getInt(7)));
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

	// Returns the cars owned by user
	@Override
	public List<Car> readCarsOwned(Integer customerId) {
		// TODO Auto-generated method stub
		String sql = "Select * from car where userid ='" + customerId + "'";

		Connection conn = ConnectionFactory.getConnection();

		List<Car> carOwnedList = new ArrayList<>();

		try {
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
				carOwnedList.add(new Car(resultSet.getInt(1), resultSet.getNString(2), resultSet.getNString(3),
						resultSet.getNString(4), resultSet.getDouble(5), resultSet.getBoolean(6), resultSet.getInt(7)));
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
		return carOwnedList;
	}

	public String readLastCar() {
		// Returns a string with the last car inserted for unit testing
		String result = "", sql = "Select make from car where carid = 10";
		Statement stmt = null;
		Connection conn = ConnectionFactory.getConnection();

		try {
			System.out.println(result + "<<");
			stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery(sql);

			while (resultSet.next()) {
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
