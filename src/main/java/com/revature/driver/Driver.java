package com.revature.driver;

import java.util.Scanner;

import com.revature.pojo.User;
import com.revature.services.AddCarService;
import com.revature.services.AuthenticationService;
import com.revature.services.CarRemovalService;
import com.revature.services.OfferService;
import com.revature.services.PaymentService;
import com.revature.services.SignupService;
import com.revature.services.ViewCarService;
import com.revature.util.LogUtil;

public class Driver {

	public static void main(String... args) {
//		init();
		mainMenu();

	}

	// Main Menu
	public static void mainMenu() {

		Boolean run = true;

		while (run) {

			Scanner scanner = new Scanner(System.in);

			String userInput;

			System.out.println("\n----Main Menu----");
			System.out.println("Please select one of our options:");

			System.out.println("|-1. Login \n|-2. Create Account \n|-3. Exit");

			userInput = scanner.nextLine();

			switch (userInput.toUpperCase()) {
			case "1":
				loginMenu();

				break;

			case "2":
				registrationMenu();
				break;
			case "3":
			case "EXIT":
				run = false;
				break;
			default:
				LogUtil.warn("Invalid choice, try again...");
				break;
			}
		}

		System.out.println("Goodbye!");
	}

	// LOGIN MENU
	public static void loginMenu() {
		AuthenticationService authServ = new AuthenticationService();

		String username, password, userInput;

		Scanner scanner = new Scanner(System.in);

		// CUSTOMER LOGIN

		System.out.println("\nUsername: ");
		userInput = scanner.nextLine();
		username = userInput;

		System.out.println("Password : ");
		userInput = scanner.nextLine();
		password = userInput;

		User tempUser = authServ.getUserByUsername(username);
		if (authServ.authenticate(tempUser.getUserid(), username, password)) {
			if (tempUser.isEmployee_role()) {
				employeeMenu(tempUser);
			} else {
				customerMenu(tempUser);
			}

		} else {
			LogUtil.info("Login failed");
			loginMenu();
		}

	}

	// Registration Menu
	public static void registrationMenu() {
		SignupService signUpServ = new SignupService();
		String userInput, username, password;
		Scanner scanner = new Scanner(System.in);

		System.out.println("--REGISTER USER--");
		System.out.println("Username: ");
		userInput = scanner.nextLine();
		username = userInput;

		System.out.println("Password : ");
		userInput = scanner.nextLine();
		password = userInput;

		signUpServ.signup(username, password);
		mainMenu();
	}

	// CustomerMenu
	// TODO: check your work
	public static void customerMenu(User user) {
		String userInput, carId;
		Double offer;
		Scanner scanner = new Scanner(System.in);

		ViewCarService viewCarServ = new ViewCarService();
		OfferService offerServ = new OfferService();
		PaymentService payServ = new PaymentService();

		System.out.println("\n----CUSTOMER MENU---- \n Hello " + user.getUsername());
		System.out.println(
				"|-1. Explore Cars: \n|-2. Make Offer: \n|-3. View Cars: \n|-4. Make Payment: \n|-5. Remaining Payments: \n|-6. Logout ");
		userInput = scanner.nextLine();

		switch (userInput) {
		case "1":
			viewCarServ.customerCarView();
			customerMenu(user);
			break;

		case "2":
			System.out.println("----MAKE OFFER----");
			System.out.println("Enter Vehicle ID): ");
			carId = scanner.nextLine();
			// Clear?
			System.out.println("Enter Amount: ");
			offer = scanner.nextDouble();
			// TODO: add an instance of the user id
			offerServ.addOffer(user.getUserid(), Integer.parseInt(carId), offer);
			customerMenu(user);
			break;
		case "3":
			System.out.println("----VIEW CARS----");
			System.out.println("Enter Vehicle ID): ");
			carId = scanner.nextLine();

			// TODO: Make sure to only show the cars needed
			viewCarServ.customerCarView();
			customerMenu(user);
			break;
		case "4":
			System.out.println("----Make Payment----");
			System.out.println("\"Enter Vehicle ID): ");

			// Not needed actually

			customerMenu(user);
		case "5":
			System.out.println("----VIEW Payment History----");
			System.out.println("\"Enter Vehicle ID): ");
			payServ.userRemaningBlance(user.getUserid());
			customerMenu(user);
		case "6":
			LogUtil.info("User " + user.getUsername() + " --logged out--");
			loginMenu();
			break;
		default:
			LogUtil.warn("Invalid choice, try again...");
			break;
		}
	}

	// EmployeeMenu
	public static void employeeMenu(User user) {
		AddCarService addCarServ = new AddCarService();
		ViewCarService viewCarServ = new ViewCarService();
		OfferService offerServ = new OfferService();
		CarRemovalService carRemvServ = new CarRemovalService();
		PaymentService payServ = new PaymentService();

		String userInput, offerId, carId, make, model, year, customer;
		Double price;
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n====EMPLOYEE MENU==== \n Hello " + user.getUsername() + "!");
		System.out.println(
				"|=1. Add Cars: \n|=2. View Lot: \n|=3. Accept Offers: \n|=4. Remove Car From Lot: \n|=5. View All Payments: \n|=6. Signout");
		userInput = scanner.nextLine();

		switch (userInput.toUpperCase()) {
		case "1":
			String exit = "Y";
			do {
				System.out.println("--ADD CARS--");
				System.out.println("Enter Make:");
				make = scanner.nextLine();
				System.out.println("Enter Model:");
				model = scanner.nextLine();
				// Format this
				System.out.println("Enter Year:");
				year = scanner.nextLine();
				System.out.println("Enter price:");
				price = Double.parseDouble(scanner.nextLine());

				addCarServ.addCar(make, model, year, price);

				make = "";
				model = "";
				year = "";
				price = 0D;
				System.out.println("Add Another Car? (Y)");
				exit = scanner.nextLine().toUpperCase();
			} while (exit.equals("Y"));
			employeeMenu(user);
			break;
		case "2":
			// Not needed
//			carViewServ.employeeCarView();
			employeeMenu(user);
			break;
		case "3":
			System.out.println("\n==ACCEPT OFFER==");
			System.out.println("Enter VIN: ");
			carId = scanner.nextLine();
			// TODO: FIX
			viewCarServ.customerCarView();

			System.out.println("Do you want to accept any offers?");
			userInput = scanner.nextLine();
			switch (userInput.toUpperCase()) {
			case "Y":
				System.out.println("Enter Offer ID: ");
				offerId = scanner.nextLine();
				offerServ.acceptOffer(Integer.parseInt(offerId));
				employeeMenu(user);
				break;
			case "N":
				employeeMenu(user);
			default:
				LogUtil.warn("Invalid Entry");
			}

			break;
		case "4":
			System.out.println("==REMOVE CARS==");
			viewCarServ.customerCarView();
			System.out.println("Enter Car VIN:");
			carId = scanner.nextLine();
			carRemvServ.removeCar(Integer.parseInt(carId));
			carId = "";
			employeeMenu(user);
			break;
		case "5":
			System.out.println("==VIEW ALL PAYMENTS==");
			payServ.viewAllPayments();
			employeeMenu(user);
			break;
		case "6":
			LogUtil.info("User " + user.getUsername() + " =logged out=");
			mainMenu();
			break;
		default:
			LogUtil.warn("Invalid choice, try again...");
			break;
		}
	}
}
