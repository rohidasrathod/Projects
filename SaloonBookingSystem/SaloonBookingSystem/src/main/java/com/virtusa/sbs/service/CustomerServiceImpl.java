package com.virtusa.sbs.service;
import java.util.List;

import com.virtusa.sbs.dao.CustomerDAO;
import com.virtusa.sbs.dto.CustomerDTO;
import com.virtusa.sbs.util.AppContext;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO  customerDAO = AppContext.getInstance().getObject("CustomerDAO");

    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public CustomerServiceImpl() {
		// customer implementation
	}

	@Override
    public boolean addCustomer(CustomerDTO customer) {
        return customerDAO.addCustomer(customer);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {
        return customerDAO.updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        return customerDAO.deleteCustomer(customerId);
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        return customerDAO.getCustomerByEmail(email);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

	@Override
	public CustomerDTO getCustomerById(int customerId) {
		
		return customerDAO.getCustomerById(customerId);
	}

}
