package com.virtusa.sbs.dao;

import java.util.List;

import com.virtusa.sbs.dto.CustomerDTO;

public interface CustomerDAO {

   
    boolean addCustomer(CustomerDTO customer);

   
    boolean updateCustomer(CustomerDTO customer);

    
    boolean deleteCustomer(int customerId);

    CustomerDTO getCustomerByEmail(String email);

    
    List<CustomerDTO> getAllCustomers();


	CustomerDTO getCustomerById(int customerId);
}

