package com.virtusa.sbs.ui;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.virtusa.sbs.dao.CustomerDAO;
import com.virtusa.sbs.dao.CustomerDAOImpl;
import com.virtusa.sbs.dao.StylistDAO;
import com.virtusa.sbs.dao.StylistDAOImpl;
import com.virtusa.sbs.dto.CustomerDTO;
import com.virtusa.sbs.dto.StylistDTO;

public class LoginMenu {
    private static CustomerDAO customerDAO = new CustomerDAOImpl();
    private static StylistDAO stylistDAO = new StylistDAOImpl();
    private static CustomerMenu customerMenu = new CustomerMenu();
    private static StylistMenu stylistMenu = new StylistMenu();
    private static AdminMenu adminMenu = new AdminMenu();
    private static final Logger logger = LogManager.getLogger(LoginMenu.class);
    
    String email = null;
    String password = null;


    public void userInput(String userType) {
    	
        try (Scanner scanner = new Scanner(System.in)) {
			try {
				String str="Welcome to the  " + userType + "login menu!\n ";
			    logger.info(str);
			    logger.info("Please enter your email:");
			    email = scanner.next();

			    logger.info("Please enter your password:");
			    password = scanner.next();
			    
			    displayLoginMenu(userType);
			} catch (NoSuchElementException e) {
			    logger.info("Error: No input detected. Please try again.");
			}
		}
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static CustomerDTO customerLogin(String email, String password) {
        CustomerDTO customer = customerDAO.getCustomerByEmail(email);
        if (customer != null && customer.getPassword().equals(password)) {
            // Login successful
            return customer;
        }
        // Login failed
        return null;
    }

    public static StylistDTO stylistLogin(String email, String password) {
        StylistDTO stylist = stylistDAO.getStylistByEmail(email);
        if (stylist != null && stylist.getPassword().equals(password)) {
            // Login successful
            return stylist;
        }
        // Login failed
        return null;
    }

    public static StylistDTO adminLogin(String email, String password) {
    	StylistDTO admin = stylistDAO.getStylistByEmail(email);
        if (admin != null && admin.getPassword().equals(password) && admin.getStylistId()==1) {
            // Login successful
            return admin;
        }
        // Login failed
        return null;
    }

    public void displayLoginMenu(String userType) {
    	
        if (userType.equalsIgnoreCase("customer")) {
            CustomerDTO customer = customerLogin(email, password);
            if (customer != null) {
                logger.info("Login successful! Welcome %s !%n" , customer.getName());
                
                customerMenu.displayCustomerMenu(customer);
            } else {
                logger.info("Incorrect email or password. Please try again.%n");
                userInput(userType);
            }
        } else if (userType.equalsIgnoreCase("stylist")) {
            StylistDTO stylist = stylistLogin(email, password);
            if (stylist != null) {
                logger.info("Login successful! Welcome %s !%n" , stylist.getName());
                
                stylistMenu.displayStylistMenu(stylist);
            } else {
                logger.info("Incorrect email or password. Please try again.%n");
                userInput(userType);
            }
        } else if (userType.equalsIgnoreCase("admin")) {
        	StylistDTO admin = adminLogin(email, password);
            if (admin != null) {
                logger.info("Login successful! Welcome Admin!\n");
                adminMenu.displayAdminMenu();
            } else {
                logger.info("Incorrect email or password. Please try again.\n");
                userInput(userType);
            }
        } else {
            logger.info("Invalid user type. Please try again.");
            MainMenu.displayMainMenu();
        }
    }

 }
