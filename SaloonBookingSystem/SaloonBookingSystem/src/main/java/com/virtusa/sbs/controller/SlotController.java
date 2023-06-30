package com.virtusa.sbs.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.virtusa.sbs.dto.SlotDTO;
import com.virtusa.sbs.service.SlotService;
import com.virtusa.sbs.util.AppContext;

public class SlotController {

	private SlotService slotService =  AppContext.getInstance().getObject("SlotService");
 
    private  Scanner scanner = new Scanner(System.in);
    String str="Enter stylist ID: ";
    String str1 ="Enter slot ID: ";
    private static final Logger logger = LogManager.getLogger(SlotController.class);

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }
    public SlotController() {
    	
    }

    public void addSlot() {
       
    	
        logger.info(str);
        int stylistId = scanner.nextInt();

        logger.info("Enter availability date (yyyy-MM-dd): ");
        String availabilityDate = scanner.next();

        logger.info("Enter availability time (hh:mm): ");
        String availabilityTime = scanner.next();

        SlotDTO slot = new SlotDTO();
        slot.setStylistId(stylistId);
        slot.setAvailabilityDate(availabilityDate);
        slot.setAvailabilityTime(availabilityTime);

        boolean success = slotService.addSlot(slot);

        if (success) {
            logger.info("Slot added successfully.");
        } else {
            logger.info("Slot could not be added.");
        }
    }

    public void updateSlot() {
        

        logger.info(str1);
        int slotId = scanner.nextInt();

        logger.info(str);
        int stylistId = scanner.nextInt();

        logger.info("Enter availability date (yyyy-MM-dd): ");
        String availabilityDate = scanner.next();

        logger.info("Enter availability time (hh:mm): ");
        String availabilityTime = scanner.next();
        
        logger.info("Enter available status (true or false): ");
        boolean slotAvailable = scanner.nextBoolean();
        SlotDTO slot = new SlotDTO();
        slot.setSlotId(slotId);
        slot.setStylistId(stylistId);
        slot.setAvailabilityDate(availabilityDate);
        slot.setAvailabilityTime(availabilityTime);
        slot.setSlotAvailable(slotAvailable);

        boolean success = slotService.updateSlot(slot);

        if (success) {
            logger.info("Slot updated successfully.");
        } else {
            logger.info("Slot could not be updated.");
        }
    }

    public void deleteSlot() {
        
        logger.info(str1);
        int slotId = scanner.nextInt();

        boolean success = slotService.deleteSlot(slotId);

        if (success) {
            logger.info("Slot deleted successfully.");
        } else {
            logger.info("Slot could not be deleted.");
        }
    }

    public void getSlotById() {
       

        logger.info(str1);
        int slotId = scanner.nextInt();

        SlotDTO slot = slotService.getSlotById(slotId);

        if (slot != null) {
            logger.info("Slot details:");
            String slotid="SlotID: " + slot.getSlotId();
            logger.info(slotid);
            String stylistid="Stylist ID: " + slot.getStylistId();
            logger.info(stylistid);
            String avDate="Availability date: " + slot.getAvailabilityDate();
            logger.info(avDate);
            String avTime="Availability time: " + slot.getAvailabilityTime();
            logger.info(avTime);
            String slotAvailability="Slot available: " + slot.isSlotAvailable();
            logger.info(slotAvailability);
        } else {
            logger.info("Slot not found.");
        }
    }


    public void getAllAvailableSlots() {
        List<SlotDTO> slots = slotService.getAllAvailableSlots();

        if (slots.isEmpty()) {
            logger.info("No available slots found");
        } else {
        	logger.info("=== All Available Slots details: ===");
            for (SlotDTO slot : slots) {
            	 String slotid1="SlotID: " + slot.getSlotId();
                 logger.info(slotid1);
                 String stylistid1="Stylist ID: " + slot.getStylistId();
                 logger.info(stylistid1);
                 String avDate1="Availability date: " + slot.getAvailabilityDate();
                 logger.info(avDate1);
                 String avTime1="Availability time: " + slot.getAvailabilityTime();
                 logger.info(avTime1);
                 String slotAvailability1="Slot available: " + slot.isSlotAvailable();
                 logger.info(slotAvailability1);
                logger.info("---------------------------");
            }
        }
    }
    
    public void getAvailableSlotsByStylist() {
        
        logger.info("Enter stylist ID: ");
        int stylistId = scanner.nextInt();

        List<SlotDTO> availableSlots = slotService.getAvailableSlotsByStylist(stylistId);

        if (availableSlots.isEmpty()) {
            logger.info("No available slots found for stylist with ID {}" , stylistId);
        } else {
            logger.info("Available slots for stylist with ID {} :" , stylistId);
            for (SlotDTO slot : availableSlots) {
            	
            	String str2="Slot ID: " + slot.getSlotId() + " | Date: " + slot.getAvailabilityDate()
                + " | Time: " + slot.getAvailabilityTime();
                logger.info(str2);
            }
        }
    }
    

}
