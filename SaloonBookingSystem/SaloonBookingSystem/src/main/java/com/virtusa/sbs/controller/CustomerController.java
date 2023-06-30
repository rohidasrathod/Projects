package com.virtusa.sbs.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.virtusa.sbs.dto.CustomerDTO;
import com.virtusa.sbs.service.CustomerService;
import com.virtusa.sbs.service.CustomerServiceImpl;

public class CustomerController {
    
    private CustomerService customerService = new CustomerServiceImpl();
    private Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LogManager.getLogger(CustomerController.class);

    
    
    public void addCustomer() {
        logger.info("Enter customer details:");
        logger.info("CustomerName: ");
        String name = scanner.nextLine();
        logger.info("CustomerEmail: ");
        String email = scanner.nextLine();
        logger.info("Password: ");
        String password = scanner.nextLine();
        
        CustomerDTO customer = new CustomerDTO();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        boolean result = customerService.addCustomer(customer);
        if (result) {
            logger.info("Customer added successfully");
        } else {
            logger.info("Failed to add customer");
        }
    }
    
    public void updateCustomer() {
    	logger.info("Enter ID of customer to update: ");
        int id = scanner.nextInt();
        
        logger.info("Enter new name: ");
        String name = scanner.next();
        logger.info("Enter new email: ");
        String email = scanner.next();
        logger.info("Enter new password: ");
        String password = scanner.next();
        
        CustomerDTO customer = new CustomerDTO();
        customer.setCustomerId(id);
        if (!name.isEmpty()) {
            customer.setName(name);
        }
        if (!email.isEmpty()) {
            customer.setEmail(email);
        }
        if (!password.isEmpty()) {
            customer.setPassword(password);
        }
        
        boolean result = customerService.updateCustomer(customer);
        if (result) {
            logger.info("customer updated successfully");
        } else {
            logger.info("Failed to update customer");
        }
    }
    
    public void deleteCustomer() {
        logger.info("Enter customer ID: ");
        int customerId = scanner.nextInt();
        boolean result = customerService.deleteCustomer(customerId);
        if (result) {
            logger.info("Customer deleted successfully");
        } else {
            logger.info("Failed to delete customer");
        }
    }
    
    public void getCustomerByEmail() {
        logger.info("Enter customer email: ");
        String email = scanner.nextLine();
        CustomerDTO customer = customerService.getCustomerByEmail(email);
        if (customer != null) {
            logger.info("Customer details:");
            String cid="ID: " + customer.getCustomerId();
            logger.info(cid);
            String cName="Name: " + customer.getName();
            logger.info(cName);
            String cEmail="Email: " + customer.getEmail();
            logger.info(cEmail);           
        } else {
            logger.info("Customer not found");
        }
    }
    
    public void getAllCustomers() {
        List<CustomerDTO> customers = customerService.getAllCustomers();
        if (customers != null && !customers.isEmpty()) {
            logger.info("Customer details:");
            for (CustomerDTO customer : customers) {
            	String cid="ID: " + customer.getCustomerId();
                logger.info(cid);
                String cName="Name: " + customer.getName();
                logger.info(cName);
                String cEmail="Email: " + customer.getEmail();
                logger.info(cEmail);
                
            }
        } else {
            logger.info("No customers found");
        }
    }
}
