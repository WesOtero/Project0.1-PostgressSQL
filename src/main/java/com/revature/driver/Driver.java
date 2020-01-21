package com.revature.driver;

import java.util.Scanner;

import com.revature.pojo.User;
import com.revature.services.AddCarService;
import com.revature.services.AuthenticationService;
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
//TODO: Remove Init if not needed
	// Init No longer needed
//	public static void init() {
//		File[] files = { new File("customerUserBase.dat"), new File("employeeUserBase.dat"), new File("carLot.dat") };
//
//		if (files[0].exists() && files[1].exists() && files[2].exists()) {
//			UserDAO userDAO = new UserDAO();
//			userDAO.readCustomers();
//			userDAO.readEmployees();
//			CarDAO carDAO = new CarDAO();
//			carDAO.readCarDB();
//			LoggerUtil.info("Application ran successfully");
//		} else {
//			for (File file : files) {
//				try {
//					LoggerUtil.info("File created.");
//					file.createNewFile();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}

	// Main Menu
	public static void mainMenu() {

		Boolean run = true;
		Scanner scanner = new Scanner(System.in);

		while (run) {
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

		// Prompt
		System.out.println("\n----LOGIN MENU----");
		System.out.println("|-1. Login: \n|-2. Main Menu: ");
		userInput = scanner.nextLine();

		switch (userInput) {
		case "1":
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

			break;

		case "2":
			// GO BACK
			mainMenu();

			break;

		default:
			break;
		}

	}

	// Registration Menu
	public static void registrationMenu() {
		SignupService signUpServ = new SignupService();
		String userInput, username, password;
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n----REGISTRATION MENU----");
		System.out.println("|-1. Customer Registration: \n|-2. Main Menu: ");

		userInput = scanner.nextLine();

		switch (userInput) {
		case "1":

			System.out.println("--REGISTER USER--");
			System.out.println("Username: ");
			userInput = scanner.nextLine();
			username = userInput;

			System.out.println("Password : ");
			userInput = scanner.nextLine();
			password = userInput;

			signUpServ.signup(username, password);
			loginMenu();
			break;

		case "2":
			// GO BACK
			mainMenu();
			break;

		default:
			System.out.println("Invalid choice, try again...");
			break;
		}
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
	public static void employeeMenu(User username) {
		AddCarService addCarServ = new AddCarService();
		
		String userInput, carId, make, model, year, customer;
		Double price;
		Scanner scanner = new Scanner(System.in);

		System.out.println("\n====EMPLOYEE MENU==== \n Hello " + username + "!");
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
				//Format this
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
			employeeMenu(username);
			break;
		case "2":
			carViewServ.employeeCarView();
			employeeMenu(username);
			break;
		case "3":
			System.out.println("\n==ACCEPT OFFER==");
			System.out.println("Enter VIN: ");
			vinNumber = scanner.nextLine();
			carBidServ.getCurentOffers(vinNumber);
			System.out.println("Do you want to accept any offers?");
			userInput = scanner.nextLine();
			switch (userInput) {
			case "Y":
				System.out.println("Enter Customer: ");
				customer = scanner.nextLine();
				carBidServ.acceptOffer(customer, vinNumber);
				customer = "";
				vinNumber = "";
				employeeMenu(username);
				break;
			case "N":
				employeeMenu(username);
			default:
				LoggerUtil.warn("Invalid Entry");
			}

			break;
		case "4":
			System.out.println("==REMOVE CARS==");
			carViewServ.employeeCarView();
			System.out.println("Enter Car VIN:");
			vinNumber = scanner.nextLine();
			carRemvServ.removeCar(vinNumber);
			vinNumber = "";
			employeeMenu(username);
			break;
		case "5":
			System.out.println("==VIEW ALL PAYMENTS==");
			custPayServ.employeePaymentView();
			employeeMenu(username);
			break;
		case "6":
			LoggerUtil.info("User " + username + " =logged out=");
			mainMenu();
			break;
		default:
			LoggerUtil.warn("Invalid choice, try again...");
			break;
		}
	}
}
