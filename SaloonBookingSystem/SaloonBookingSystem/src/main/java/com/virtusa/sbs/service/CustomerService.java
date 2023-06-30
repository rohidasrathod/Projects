package com.virtusa.sbs.service;

import java.util.List;

import com.virtusa.sbs.dto.CustomerDTO;

public interface CustomerService {

   
    boolean addCustomer(CustomerDTO customer);

   
    boolean updateCustomer(CustomerDTO customer);

    
    boolean deleteCustomer(int customerId);
    

	CustomerDTO getCustomerById(int customerId);

    CustomerDTO getCustomerByEmail(String email);

    
    List<CustomerDTO> getAllCustomers();
}

