package com.virtusa.sbs.ui;



import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.virtusa.sbs.controller.AppointmentController;
import com.virtusa.sbs.controller.CustomerController;
import com.virtusa.sbs.controller.ServiceController;
import com.virtusa.sbs.controller.SlotController;
import com.virtusa.sbs.controller.StylistController;



public class AdminMenu {
    
    private Scanner scanner = new Scanner(System.in);
    private CustomerController customerController = new CustomerController();
    private StylistController stylistController = new StylistController();
    private ServiceController serviceController = new ServiceController();
    private SlotController slotController = new SlotController();
    private AppointmentController appointmentController = new AppointmentController();
    
    private static final Logger logger = LogManager.getLogger(AdminMenu.class);
    		
    
    public void displayAdminMenu() {
        int choice = 0;
        do {
            logger.info("=============WELCOME TO THE ADMIN MENU=======");
            logger.info("1. Add a new stylist");
            logger.info("2. Update stylist information");
            logger.info("3. Delete a stylist");
            logger.info("4. View all stylists");
            logger.info("5. Add a new customer");
            logger.info("6. Update customer information");
            logger.info("7. Delete a customer");
            logger.info("8. View all customers");
            logger.info("9. Add a new service");
            logger.info("10. Update service information");
            logger.info("11. Delete a service");
            logger.info("12. View all services");
            logger.info("13. To get Appointment by appointmentID");
            logger.info("14. To get Appointments by customerID");
            logger.info("15. To get Appointments by stylistID");
            logger.info("16. View all Appointments");
            logger.info("17. Update Appointment information");
            logger.info("18. Delete an appointment");
            logger.info("19. Add a new slot");
            logger.info("20. Update slot information");
            logger.info("21. Delete slot");
            logger.info("22. View all slots");
            
            
            logger.info("0. Exit");
            logger.info("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch(choice) {
                case 1:
                    // Add new stylish
                	stylistController.addStylist();
                	displayAdminMenu();
                    break;
                case 2:
                    // Update stylish information
                	stylistController.updateStylist();
                	displayAdminMenu();
                    break;
                case 3:
                    // Delete a stylish
                	stylistController.deleteStylist();
                	displayAdminMenu();
                    break;
                case 4:
                    // View all stylish
                	stylistController.getAllStylists();
                	displayAdminMenu();
                    break;
                case 5:
                    // Add new customer
                	customerController.addCustomer();
                	displayAdminMenu();
                    break;
                case 6:
                    // Update customer information
                	customerController.updateCustomer();
                	displayAdminMenu();
                    break;
                case 7:
                    // Delete a customer
                	customerController.deleteCustomer();
                	displayAdminMenu();
                    break;
                case 8:
                    // View all customers
                	customerController.getAllCustomers();
                	displayAdminMenu();
                    break;
                case 9:
                    // Add new Service
                	serviceController.addService();
                	displayAdminMenu();
                    break;
                case 10:
                    // Update Service information
                	serviceController.updateService();
                	displayAdminMenu();
                    break;
                case 11:
                    // Delete a Service
                	serviceController.deleteService();
                	displayAdminMenu();
                    break;
                case 12:
                    // View all Services
                	serviceController.getAllServices();
                	displayAdminMenu();
                    break;
                case 13:
                    // get appointment by appointmentID
                	appointmentController.getAppointmentById();
                	displayAdminMenu();
                    break;
                case 14:
                    // get appointments by customerID
                	appointmentController.getAppointmentsByCustomerId();
                	displayAdminMenu();
                    break;
                case 15:
                    // get appointments by stylistID
                	appointmentController.getAppointmentsByStylistId();
                	displayAdminMenu();
                    break;
                case 16:
                    // View All Appointments
                	appointmentController.getAllAppointments();
                	displayAdminMenu();
                    break;    
                case 17:
                    // update appointment information
                	appointmentController.updateAppointment();
                	displayAdminMenu();
                    break;
                case 18:
                    // delete appointment
                	appointmentController.deleteAppointment();
                	displayAdminMenu();
                    break;    
                case 19:
                    // Add a new slot
                	slotController.addSlot();
                	displayAdminMenu();
                    break;    
                case 20:
                    // update slot information
                	slotController.updateSlot();
                	displayAdminMenu();
                    break;
                case 21:
                    // delete slot
                	slotController.deleteSlot();
                	displayAdminMenu();
                    break;  
                case 22:
                    // View all slots
                	slotController.getAllAvailableSlots();
                	displayAdminMenu();
                    break;    
                case 0:
                    logger.info("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    logger.info("Invalid choice. Please try again.");
                    displayAdminMenu();
                    break;
            }
        } while (choice != 22);
    }
    
    
    
    

}