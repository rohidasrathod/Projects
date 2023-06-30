package com.virtusa.sbs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.virtusa.sbs.dto.CustomerDTO;
import com.virtusa.sbs.util.DBUtil;


public class CustomerDAOImpl implements CustomerDAO {

	 private static final Logger logger = Logger.getLogger(CustomerDAOImpl.class.getName());
	String cid="customer_id";
	String name="name";
	String email="email";
	String password="password";
    public CustomerDAOImpl() {
        //Customer Implementation
    }

    @Override
    public boolean addCustomer(CustomerDTO customer) {
        boolean success = false;
        String query = "INSERT INTO customer (customer_id, name, email, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(query);){
            
            
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPassword());
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                success = true;
            }
        } catch (SQLException ex) {
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return success;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {
        boolean success = false;
        String query = "UPDATE customer SET name = ?, email = ?, password = ? WHERE customer_id = ?";
        try(PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(query);) {
            
            
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.setInt(4, customer.getCustomerId());
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                success = true;
            }
        } catch (SQLException ex) {
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return success;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        boolean success = false;
        String query = "DELETE FROM customer WHERE customer_id = ?";
        try (PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(query);){
            
            
            preparedStatement.setInt(1, customerId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                success = true;
            }
        } catch (SQLException ex) {
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return success;
    }
    
    @Override
    public CustomerDTO getCustomerById(int customerId) {
    	String query = "SELECT * FROM customer WHERE customer_id = ?";
    	try (PreparedStatement stmt = DBUtil.getConnection().prepareStatement(query);){
	        
	        
	        stmt.setInt(1, customerId);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	
	            CustomerDTO customer = new CustomerDTO();
	            customer.setCustomerId(rs.getInt(cid));
	            customer.setName(rs.getString(name));
	            customer.setEmail(rs.getString(email));
	            customer.setPassword(rs.getString(password));
	            return customer;
	        }
    	}catch(SQLException ex) {
    		logger.log(Level.SEVERE, ex.getMessage(), ex);
    	}
        return null;
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        CustomerDTO customer = null;
        String query = "SELECT * FROM customer WHERE email = ?";
        try (PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(query);){
            
            
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                customer = new CustomerDTO(resultSet.getInt(cid), resultSet.getString(name),
                        resultSet.getString(email), resultSet.getString(password));
            }
        } catch (SQLException ex) {
        	logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return customer;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try(PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(query);) {
           
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CustomerDTO customer = new CustomerDTO(resultSet.getInt(cid), resultSet.getString(name),
                        resultSet.getString(email), resultSet.getString(password));
                customers.add(customer);
            }
        } catch (SQLException ex) {
        	 logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return customers;
    }

	

}
