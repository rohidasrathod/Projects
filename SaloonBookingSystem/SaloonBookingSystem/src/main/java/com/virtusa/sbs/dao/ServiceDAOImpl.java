package com.virtusa.sbs.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.virtusa.sbs.dto.ServiceDTO;
import com.virtusa.sbs.util.DBUtil;

public class ServiceDAOImpl implements ServiceDAO {

    private static final Logger logger = Logger.getLogger(ServiceDAOImpl.class.getName());
    

    public ServiceDAOImpl() {
    	//Service implementation
    }

    @Override
    public boolean addService(ServiceDTO service) {
        boolean result = false;
        String sql = "INSERT INTO services(service_id, name, price) VALUES (?, ?, ?)";

        try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(sql)) {
            statement.setInt(1, service.getServiceId());
            statement.setString(2, service.getName());
            statement.setBigDecimal(3, service.getPrice());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return result;
    }

    @Override
    public boolean updateService(ServiceDTO service) {
        boolean result = false;
        String sql = "UPDATE services SET name = ?, price = ? WHERE service_id = ?";

        try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(sql)) {
            statement.setString(1, service.getName());
            statement.setBigDecimal(2, service.getPrice());
            statement.setInt(3, service.getServiceId());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return result;
    }

    @Override
    public boolean deleteService(int serviceId) {
        boolean result = false;
        String sql = "DELETE FROM services WHERE service_id = ?";

        try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(sql)) {
            statement.setInt(1, serviceId);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return result;
    }

    @Override
    public ServiceDTO getServiceById(int serviceId) {
        ServiceDTO service = null;
        String sql = "SELECT * FROM services WHERE service_id = ?";

        try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(sql)) {
            statement.setInt(1, serviceId);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                service = new ServiceDTO(
                        resultSet.getInt("service_id"),
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("price")
                );
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return service;
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        List<ServiceDTO> services = new ArrayList<>();
        String sql = "SELECT * FROM services";

        try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ServiceDTO service = new ServiceDTO(
                        resultSet.getInt("service_id"),
                        resultSet.getString("name"),
                        resultSet.getBigDecimal("price")
                );
                services.add(service);
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }

        return services;
    }
    
    public String getServiceDetailsForAppointment(int serviceId) {
    	try(PreparedStatement stmt = DBUtil.getConnection().prepareStatement("SELECT name FROM services WHERE service_id = ?")) {
			stmt.setInt(1, serviceId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception ex) {
			 logger.log(Level.SEVERE, ex.getMessage(), ex);		}
    	return null;
    }
}
