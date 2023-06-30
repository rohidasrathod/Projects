package com.virtusa.sbs.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.virtusa.sbs.dto.StylistDTO;
import com.virtusa.sbs.service.StylistService;
import com.virtusa.sbs.service.StylistServiceImpl;

public class StylistController {
    
    private StylistService stylistService = new StylistServiceImpl();
    
    private Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(StylistController.class);

 
    public void addStylist() {
        logger.info("Enter name: ");
        String name = scanner.next();
        logger.info("Enter email: ");
        String email = scanner.next();
        logger.info("Enter password: ");
        String password = scanner.next();
        
        StylistDTO stylist = new StylistDTO();
        stylist.setName(name);
        stylist.setEmail(email);
        stylist.setPassword(password);
        
        boolean result = stylistService.addStylist(stylist);
        if (result) {
            logger.info("Stylist added successfully");
        } else {
            logger.info("Failed to add stylist");
        }
    }
    
    public void updateStylist() {
        logger.info("Enter ID of stylist to update: ");
        int id = scanner.nextInt();
        
        logger.info("Enter new name: ");
        String name = scanner.next();
        logger.info("Enter new email: ");
        String email = scanner.next();
        logger.info("Enter new password: ");
        String password = scanner.next();
        
        StylistDTO stylist = new StylistDTO();
        stylist.setStylistId(id);
        if (!name.isEmpty()) {
            stylist.setName(name);
        }
        if (!email.isEmpty()) {
            stylist.setEmail(email);
        }
        if (!password.isEmpty()) {
            stylist.setPassword(password);
        }
        
        boolean result = stylistService.updateStylist(stylist);
        if (result) {
            logger.info("Stylist updated successfully");
        } else {
            logger.info("Failed to update stylist");
        }
    }
    
    public void deleteStylist() {
        logger.info("Enter ID of stylist to delete: ");
        int id = scanner.nextInt();
        
        boolean result = stylistService.deleteStylist(id);
        if (result) {
            logger.info("Stylist deleted successfully");
        } else {
            logger.info("Failed to delete stylist");
        }
    }
    
    public void getStylistByEmail() {
        logger.info("Enter email of stylist to retrieve: ");
        String email = scanner.next();
        
        StylistDTO stylist = stylistService.getStylistByEmail(email);
        if (stylist != null) {
            logger.info("Stylist  details:");
            String stylistid="ID: " + stylist.getStylistId();
            logger.info(stylistid);
            String stylistName="Name: "  + stylist.getName();
            logger.info(stylistName);
            String stylistEmail="Email: " + stylist.getEmail();
            logger.info(stylistEmail);
        	
           
        } else {
            logger.info("Stylist not found");
        }
    }
    
    public void getAllStylists() {
        List<StylistDTO> stylists = stylistService.getAllStylists();
        if (stylists != null && !stylists.isEmpty()) {
            logger.info("Stylist details:");
            for (StylistDTO stylist : stylists) {
               
            	logger.info(stylist);
                logger.info("-------------");
            }
        } else {
            logger.info("No stylists found");
        }
    }
}
