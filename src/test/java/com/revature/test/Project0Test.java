package com.revature.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.revature.dao.CarDAOPostgres;
import com.revature.dao.OfferDAOPostgres;
import com.revature.pojo.Car;
import com.revature.services.AuthenticationService;
import com.revature.services.CarRemovalService;
import com.revature.services.OfferService;
import com.revature.services.PaymentService;
import com.revature.services.SignupService;
import com.revature.services.ViewCarService;

public class Project0Test {
	// -As a user, I can login.
	@Test
	public void testUserLogin() {
		AuthenticationService authServ = new AuthenticationService();
		assertTrue(authServ.authenticate(1, "Unit", "Testing"));
	}

	// -As a user, I can register for a customer account.
	@Test
	public void testUserRegistration() {
		SignupService signUpServ = new SignupService();
		String username = "Unit", password = "Testing";
		signUpServ.signup(username, password);
		assertTrue(false);
	}

	// -As a customer, I can view the cars on the lot.
	@Test
	public void testCustomerCarView() {
		// TODO: Replace action that returns the carID
		CarDAOPostgres carDAO = new CarDAOPostgres();
		List<Car> cars = carDAO.readAllCarsOnLot();
		assertEquals(cars.get(0).getCarId(), carDAO.readAllCars().get(0).getCarId());
	}

	// -As a customer, I can make an offer for a car.
	@Test
	public void testCustomerOffer() {
		OfferService offerServ = new OfferService();
		offerServ.addOffer(1, 1, 20000D);
		assertTrue(false);
	}

	// -As a customer, I can view the cars that I own.
	@Test
	public void testCustomerCarsOwnedView() {
		ViewCarService viewCarServ = new ViewCarService();
		viewCarServ.customerCarView();
		assertTrue(false);
	}

	// As a customer, I can view my remaining payments for a car.
	@Test
	public void testRemainingPayments() {
		assertTrue(false);
	}

	// -As an employee, I can remove a car from the lot.
	@Test
	public void testRemoveCar() {
		CarRemovalService carRemvServ = new CarRemovalService();
		carRemvServ.removeCar(100);
		assertTrue(false);
	}

	// As an employee, I can view all payments.
	@Test
	public void testViewAllPayments() {
		assertTrue(false);
	}

	// -As an employee, I can add a car to the lot.
	@Test
	public void testAddCar() {
		// Test Variables
		String make = "Unit", model = "Test", year = "2020-01-01";
		Double price = 20000D;
		CarDAOPostgres carDAO = new CarDAOPostgres();
		carDAO.createCar(new Car(make, model, year, price));
		assertEquals("Unit", carDAO.readLastCar());
	}

	// -As an employee, I can accept or reject an offer for a car.
	@Test
	public void testAcceptOffer() {
		OfferService offerServ = new OfferService();
		offerServ.rejectOffer(100);
		assertTrue(false);
	}
	//-
	@Test
	public void testRejectOffer() {
		OfferService offerServ = new OfferService();
		offerServ.rejectOffer(100);
		assertTrue(false);
	}

	// -As the system, I can calculate the monthly payment.
	@Test
	public void testCalculatePayment() {
		PaymentService payServ = new PaymentService();
		payServ.calculatePayment(100, 100);
		assertTrue(false);
	}

	// As the system, I reject all other pending offers for a car when an offer is
	// accepted.
	@Test
	public void testRejectAllPending() {

		assertTrue(false);
	}
}
