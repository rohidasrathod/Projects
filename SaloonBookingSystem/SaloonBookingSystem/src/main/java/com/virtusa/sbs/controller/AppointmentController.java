package com.virtusa.sbs.controller;



import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.virtusa.sbs.dao.ServiceDAOImpl;
import com.virtusa.sbs.dao.SlotDAOImpl;
import com.virtusa.sbs.dao.StylistDAOImpl;
import com.virtusa.sbs.dto.AppointmentDTO;
import com.virtusa.sbs.dto.CustomerDTO;
import com.virtusa.sbs.dto.SlotDTO;
import com.virtusa.sbs.service.AppointmentService;
import com.virtusa.sbs.util.AppContext;



public class AppointmentController {

	private AppointmentService appointmentService = AppContext.getInstance().getObject("AppointmentService");
 
    private SlotController slotController = new SlotController(); 
    private StylistDAOImpl stylistDAOImpl = new StylistDAOImpl();
    private SlotDAOImpl slotDAOImpl = new SlotDAOImpl();
    private ServiceDAOImpl serviceDAOImpl = new ServiceDAOImpl();
    private ServiceController serviceController = new ServiceController();
   
    private Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(AppointmentController.class);



    public void bookAppointment(CustomerDTO customer) {
    	
    	logger.info("List of Available Services : ");
      	
    	serviceController.getAllServices();
        logger.info("Choose Service id: ");
        int serviceID = scanner.nextInt();

    	logger.info("List of Available Slots : ");
    	slotController.getAllAvailableSlots();
        logger.info("Choose Slot id: ");
        int slotID = scanner.nextInt();
        
      
        SlotDTO slotdto = slotDAOImpl.getSlotDetailsForAppointment(slotID);
        int stylistID = slotdto.getStylistId();
       
        int customerID = customer.getCustomerId();
        String customerName = customer.getName();
        String stylistName = stylistDAOImpl.getStylistDetailsForAppointment(stylistID)  ;
        String serviceName = serviceDAOImpl.getServiceDetailsForAppointment(serviceID);
        String appointmentDate = slotdto.getAvailabilityDate();
        String appointmentTime = slotdto.getAvailabilityTime();

        AppointmentDTO appointment = new AppointmentDTO();
        appointment.setCustomerId(customerID);
        appointment.setCustomerName(customerName);
        appointment.setStylistId(stylistID);
        appointment.setStylistName(stylistName);
        appointment.setServiceId(serviceID);
        appointment.setServiceName(serviceName);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);
       

        boolean added = appointmentService.bookAppointment(appointment);
        if (added) {
            logger.info("Appointment added successfully.");
        } else {
            logger.info("Failed to add appointment.");
        }
    }

    public void updateAppointment() {
        scanner = new Scanner(System.in);

        logger.info("Enter appointment id: ");
        int appointmentId = scanner.nextInt();

        AppointmentDTO appointment = appointmentService.getAppointmentById(appointmentId);
        if (appointment == null) {
        	String str="Appointment with id" + appointmentId +"not found. \n";
            logger.info(str);
            return;
        }

        logger.info("Enter customer id: ");
        int customerId = scanner.nextInt();
        if (customerId != 0) {
            appointment.setCustomerId(customerId);
        }

        logger.info("Enter stylist id: ");
        int stylistId = scanner.nextInt();
        if (stylistId != 0) {
            appointment.setStylistId(stylistId);
        }

        logger.info("Enter service id: ");
        int serviceId = scanner.nextInt();
        if (serviceId != 0) {
            appointment.setServiceId(serviceId);
        }
        
        logger.info("Enter customer name: ");
        String customerName = scanner.next();
        if (customerName != null) {
            appointment.setCustomerId(customerId);
        }

        logger.info("Enter stylist name: ");
        String stylistName = scanner.next();
        if (stylistName!= null) {
            appointment.setStylistName(stylistName);
        }

        logger.info("Enter service id: ");
        String serviceName = scanner.next();
        if (serviceName != null) {
            appointment.setServiceName(serviceName);
        }

        logger.info("Enter appointment date (yyyy-mm-dd): ");
        String appointmentDateStr = scanner.next();
        if (!appointmentDateStr.isEmpty()) {
            String appointmentDate = appointmentDateStr;
            appointment.setAppointmentDate(appointmentDate);
        }

        logger.info("Enter appointment time (hh:mm:ss): ");
        String appointmentTimeStr = scanner.next();
        if (!appointmentTimeStr.isEmpty()) {
            String appointmentTime = appointmentTimeStr;
            appointment.setAppointmentTime(appointmentTime);
        }


        boolean updated = appointmentService.updateAppointment(appointment);
        if (updated) {
            logger.info("Appointment updated successfully.");
        } else {
            logger.info("Failed to update appointment.");
        }
    }

    public void deleteAppointment() {
        logger.info("Enter the ID of the appointment to delete: ");
        int appointmentId = scanner.nextInt();

        boolean isDeleted = appointmentService.deleteAppointment(appointmentId);

        if (isDeleted) {
        	String str ="Appointment with ID " + appointmentId + " has been deleted.";
            logger.info(str);
        } else {
        	String str="Appointment with ID " + appointmentId + " was not found.";
            logger.info(str);
        }
    }
    
    public void getAppointmentById() {
        scanner = new Scanner(System.in);
        logger.info("Enter appointment ID: ");
        int appointmentId = scanner.nextInt();
        AppointmentDTO appointment = appointmentService.getAppointmentById(appointmentId);
        if (appointment != null) {
            
            logger.info(appointment);
            
        } else {
            logger.info("Appointment not found.");
        }
    }

    public void getAppointmentsByCustomerId() {
        scanner = new Scanner(System.in);
        logger.info("Enter customer ID: ");
        int customerId = scanner.nextInt();
        List<AppointmentDTO> appointments = appointmentService.getAppointmentsByCustomerId(customerId);
        if (appointments != null && !appointments.isEmpty()) {
        	String str="Appointments for customer ID " + customerId;
            logger.info(str);
            for (AppointmentDTO appointment : appointments) {
                logger.info(appointment);
                
                
            }
        } else {
        	String str="No appointments found for customer ID" + customerId +".";
            logger.info(str);
        }
    }
    public void getAppointmentsByStylistId() {
        scanner = new Scanner(System.in);

        logger.info("Enter stylist ID: ");
        int stylistId = scanner.nextInt();

        List<AppointmentDTO> appointments = appointmentService.getAppointmentsByStylistId(stylistId);
        if (appointments != null && !appointments.isEmpty()) {
        	String str="Appointments for stylist" +stylistId +":";
            logger.info(str);
            for (AppointmentDTO appointment : appointments) {
               logger.info(appointment);
                
            }
        } else {
        	String str="No appointments found for stylist " + stylistId;
            logger.info(str);
        }
    }
    
    public void getAllAppointments() {
        List<AppointmentDTO> appointments = appointmentService.getAllAppointments();
        if (appointments.isEmpty()) {
            logger.info("No appointments found.");
        } else {
            logger.info("All appointments:");
            for (AppointmentDTO appointment : appointments) {
                logger.info(appointment);
            }
        }
    }
    
    



}