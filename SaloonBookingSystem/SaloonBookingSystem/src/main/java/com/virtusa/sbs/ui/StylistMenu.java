package com.virtusa.sbs.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.virtusa.sbs.controller.AppointmentController;
import com.virtusa.sbs.dto.StylistDTO;
public class StylistMenu{
	
	private Scanner scanner = new Scanner(System.in);
	private AppointmentController appointmentController = new AppointmentController();
    
    private static final Logger logger = LogManager.getLogger(StylistMenu.class);
    		
	public void displayStylistMenu(StylistDTO stylist) {
	    int choice = 0;
	    do {
	        logger.info("=============WELCOME TO THE STYLIST MENU====================");
	        logger.info("1. View my upcoming appointments");
	        logger.info("2. Mark an appointment as completed");
	        logger.info("3. View my completed appointments");
	        logger.info("0. Exit");
	        logger.info("Enter your choice: ");
	        choice = scanner.nextInt();
	        
	        switch(choice) {
	            case 1:
	                // View my upcoming appointments
	            	appointmentController.getAppointmentsByStylistId();
	                break;
	            case 2:
	                // Mark an appointment as completed
	                break;
	            case 3:
	                // View my completed appointments 	            	
	                break;
	            case 0:
			    	// exit the system
			        logger.info("Thank you for using the Salon Management System.");
			        System.exit(0);
			        break;
	            default:
	            	 logger.info("Invalid choice. Please try again.");
	                 displayStylistMenu(stylist);
	            	break;
	        }
	    }while(choice <= 3);
	}
}