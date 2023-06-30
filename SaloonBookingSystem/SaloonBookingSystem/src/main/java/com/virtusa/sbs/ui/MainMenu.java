package com.virtusa.sbs.ui;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.virtusa.sbs.controller.CustomerController;
import com.virtusa.sbs.controller.StylistController;

public class MainMenu {
	
	private static CustomerController customerController = new CustomerController();
	private static StylistController stylistController = new StylistController();
	private static LoginMenu loginMenu = new LoginMenu();
	private static final Logger log = LogManager.getLogger(MainMenu.class);
	private MainMenu(){
  
 }
    public static void displayMainMenu() {
        log.info("Welcome to the Salon Management System!\n");
        log.info("Please select an option:");
        log.info("1. Login as Admin");
        log.info("2. Registration for Customer");
        log.info("3. Login as Customer");
        log.info("4. Registration for Stylist");
        log.info("5. Login as Stylist");
       
        log.info("0. Exit");

        try (Scanner sc = new Scanner(System.in)) {
			int choice = sc.nextInt();
      
			switch (choice) {
			    case 1:
			    	// login admin
			        loginMenu.userInput("admin");
			        break;
			    case 2:
			    	// register customer
			    	customerController.addCustomer();
			    	displayMainMenu();
			    	break;
			    case 3:
			    	//login customer
			    	loginMenu.userInput("customer");
			    	break;
			    case 4:
			    	// register stylish
			        stylistController.addStylist();
			        displayMainMenu();
			        break;
			    case 5:
			    	// login stylish
			        loginMenu.userInput("stylist");
			        break;
			    case 0:
			    	// exit the system
			        log.info("Thank you for using the Salon Management System.");
			        System.exit(0);
			        break;
			    default:
			        log.info("Invalid choice. Please try again.");
			        displayMainMenu();
			        break;
			}
		}
    }
    

	
}
