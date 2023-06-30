package com.virtusa.sbs.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.virtusa.sbs.controller.AppointmentController;
import com.virtusa.sbs.controller.CustomerController;
import com.virtusa.sbs.controller.ServiceController;
import com.virtusa.sbs.controller.SlotController;
import com.virtusa.sbs.dto.CustomerDTO;

public class CustomerMenu {
	
	private Scanner scanner = new Scanner(System.in);
	private CustomerController customerController = new CustomerController();
    private ServiceController serviceController = new ServiceController();
    private SlotController slotController = new SlotController();
    private AppointmentController appointmentController = new AppointmentController();
    
    private static final Logger logger = LogManager.getLogger(CustomerMenu.class);
    		
	
	public void displayCustomerMenu(CustomerDTO customer) {
        int choice = 0;
        
        do {
            logger.info("WELCOME TO THE CUSTOMER MENU!");
            logger.info("1. Update your Profile");
            logger.info("2. Book an appointment");
            logger.info("3. View my appointments");
            logger.info("4. Cancel an appointment");
            logger.info("5. View available services");
            logger.info("6. View available slots");
            logger.info("0. Exit");
            logger.info("Enter your choice: ");
            choice = scanner.nextInt();
         
            switch(choice) {
                case 1:
                    customerController.updateCustomer();
                    displayCustomerMenu(customer);
                    break;
                case 2:
                    // Book an appointment
                	appointmentController.bookAppointment(customer);
                	 displayCustomerMenu(customer);
                    break;
                case 3:
                    // View my appointments
                	appointmentController.getAppointmentsByCustomerId();
                	 displayCustomerMenu(customer);
                    break;
                case 4:
                    // Cancel an appointment
                	appointmentController.deleteAppointment();
                	 displayCustomerMenu(customer);
                    break;
                    
                case 5:
                    // View available services
                	serviceController.getAllServices();
                	 displayCustomerMenu(customer);
                    break;
                case 6:
                    // View available slots
                	slotController.getAllAvailableSlots();
                	 displayCustomerMenu(customer);
                    break;
                case 0:
                    logger.info("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
                    displayCustomerMenu(customer);
                    break;
            }
        } while (choice != 6);
    }

    
}