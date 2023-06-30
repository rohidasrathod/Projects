package com.virtusa.sbs.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.virtusa.sbs.dto.ServiceDTO;
import com.virtusa.sbs.service.ServiceService;
import com.virtusa.sbs.util.AppContext;

public class ServiceController {
    
	private ServiceService serviceService = AppContext.getInstance().getObject("ServiceService");
    
    private Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(ServiceController.class);

    public void addService() {
        
        logger.info("Enter service name:");
        String name = scanner.next();
        logger.info("Enter service price:");
        BigDecimal price = scanner.nextBigDecimal();
        
        ServiceDTO service = new ServiceDTO();
        service.setName(name);
        service.setPrice(price);
        
        boolean result = serviceService.addService(service);
        if (result) {
            logger.info("Service added successfully");
        } else {
            logger.info("Failed to add service");
        }
    }
    
    public void updateService() {
        
        logger.info("Enter service ID to update:");
        int serviceId = scanner.nextInt();
        
        
        ServiceDTO service = serviceService.getServiceById(serviceId);
        if (service != null) {
            logger.info("Enter new service name:");
            String name = scanner.next();
            logger.info("Enter new service price:");
            BigDecimal price = scanner.nextBigDecimal();
            
            service.setName(name);
            service.setPrice(price);
            
            boolean result = serviceService.updateService(service);
            if (result) {
                logger.info("Service updated successfully");
            } else {
                logger.info("Failed to update service");
            }
        } else {
            logger.info("Service not found");
        }
    }
    
    public void deleteService() {
        
        logger.info("Enter service ID to delete:");
        int serviceId = scanner.nextInt();
        
        boolean result = serviceService.deleteService(serviceId);
        if (result) {
            logger.info("Service deleted successfully");
        } else {
            logger.info("Failed to delete service");
        }
    }
    
    public void getServiceById() {
        
        logger.info("Enter service ID:");
        int serviceId = scanner.nextInt();
        
        ServiceDTO service = serviceService.getServiceById(serviceId);
        if (service != null) {
            logger.info("Service details:");
            String sid="ID: " + service.getServiceId();
            logger.info(sid);
            String sName="Name: " + service.getName();
            logger.info(sName);
            String sPrice="Price: " + service.getPrice();
            logger.info(sPrice);
            
        } else {
            logger.info("Service not found");
        }
    }
    
    public void getAllServices() {
        List<ServiceDTO> services = serviceService.getAllServices();
        if (services != null && !services.isEmpty()) {
            logger.info("Service details:");
            for (ServiceDTO service : services) {
            	String sid="ID: " + service.getServiceId();
                logger.info(sid);
                String sName="Name: " + service.getName();
                logger.info(sName);
                String sPrice="Price: " + service.getPrice();
                logger.info(sPrice);
                
            }
        } else {
            logger.info("No services found");
        }
    }
}
