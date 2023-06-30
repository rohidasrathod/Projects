package com.virtusa.sbs.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.virtusa.sbs.dto.AppointmentDTO;
import com.virtusa.sbs.util.DBUtil;




public class AppointmentDAOImpl implements AppointmentDAO {

   
    private static final Logger logger = LogManager.getLogger(AppointmentDAOImpl.class);
    
    public AppointmentDAOImpl() {
    	//constructor
    }

    @Override
    public boolean bookAppointment(AppointmentDTO appointment) {
        String sql = "INSERT INTO appointment (customer_id, stylist_id, service_id, customer_name, stylist_name, service_name, appointment_date, appointment_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(sql)) {
            statement.setInt(1, appointment.getCustomerId());
            statement.setInt(2, appointment.getStylistId());
            statement.setInt(3, appointment.getServiceId());
            statement.setString(4, appointment.getCustomerName());
            statement.setString(5, appointment.getStylistName());
            statement.setString(6, appointment.getServiceName());
            statement.setString(7, appointment.getAppointmentDate());
            statement.setString(8, appointment.getAppointmentTime());
            
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
        	String str="Error inserting appointment: " + e.getMessage();
            logger.error(str);
            return false;
        }
    }
    

    @Override
    public boolean updateAppointment(AppointmentDTO appointment) {
        String sql = "UPDATE appointment SET customer_id = ?, stylist_id = ?, service_id = ?,customer_name = ?, stylist_name = ?, service_name = ?, appointment_date = ?, appointment_time = ? WHERE appointment_id = ?";
        try (PreparedStatement statement1 = DBUtil.getConnection().prepareStatement(sql)) {
        	statement1.setInt(1, appointment.getCustomerId());
            statement1.setInt(2, appointment.getStylistId());
            statement1.setInt(3, appointment.getServiceId());
            statement1.setString(4, appointment.getCustomerName());
            statement1.setString(5, appointment.getStylistName());
            statement1.setString(6, appointment.getServiceName());
            statement1.setString(7, appointment.getAppointmentDate());
            statement1.setString(8, appointment.getAppointmentTime());
            statement1.setInt(9,appointment.getAppointmentId());
            
            int rowsUpdated = statement1.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
        	String strr="Error updating appointment: " + e.getMessage();
            logger.error(strr);
            return false;
        }
    }

    @Override
    public boolean deleteAppointment(int appointmentId) {
        String sql = "DELETE FROM appointment WHERE appointment_id = ?";
        try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(sql)) {
            statement.setInt(1, appointmentId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
        	String str1="Error deleting appointment: " + e.getMessage();
            logger.error(str1);
            return false;
        }
    }

	    @Override
	    public AppointmentDTO getAppointmentById(int appointmentId) {
	    	AppointmentDTO appointment = null;
	        String sql = "SELECT * FROM appointment WHERE appointment_id = ?";
	        try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(sql)) {
	            statement.setInt(1, appointmentId);
	            ResultSet rs1 = statement.executeQuery();
	            while(rs1.next()) {
                    appointment = new AppointmentDTO(
                    		rs1.getInt(1),
                    		rs1.getInt(2),
                    		rs1.getInt(3),
                    		rs1.getInt(4),
                    		rs1.getString(5),
                    		rs1.getString(6),
                    		rs1.getString(7));
                    appointment.setAppointmentDate(rs1.getString(8));
                    appointment.setAppointmentTime(rs1.getString(9));               
                }
	            return appointment;
	        } catch (SQLException e) {
	        	String str2="Error getting appointment with id: " + appointmentId + e.getMessage();
	            logger.error(str2);
	        }
			return null;
	    }


        @Override
        public List<AppointmentDTO> getAppointmentsByCustomerId(int customerId) {
        	AppointmentDTO appointment = null;
            List<AppointmentDTO> appointments = new ArrayList<>();
            try(
                PreparedStatement stmt = DBUtil.getConnection().prepareStatement("SELECT * FROM appointment WHERE customer_id = ?");){
                stmt.setInt(1, customerId);
                ResultSet rs2 = stmt.executeQuery();
                while(rs2.next()) {
                    appointment = new AppointmentDTO(
                    		rs2.getInt(1),
                    		rs2.getInt(2),
                    		rs2.getInt(3),
                    		rs2.getInt(4),
                    		rs2.getString(5),
                    		rs2.getString(6),
                    		rs2.getString(7));
                            appointment.setAppointmentDate(rs2.getString(8));
                            appointment.setAppointmentTime(rs2.getString(9));              
                    appointments.add(appointment);
                }
            } catch(SQLException ex) {
            	String str3="Error retrieving appointments for customer with id " + customerId + " from database: " + ex.getMessage();
                logger.error(str3);
            }
            return appointments;
        }

        @Override
        public List<AppointmentDTO> getAppointmentsByStylistId(int stylistId) {
            List<AppointmentDTO> appointments = new ArrayList<>();
            AppointmentDTO appointment = null;
            try(
                PreparedStatement stmt = DBUtil.getConnection().prepareStatement("SELECT * FROM appointment WHERE stylist_id = ?");){
                stmt.setInt(1, stylistId);
                ResultSet rs3 = stmt.executeQuery();
                while(rs3.next()) {
                    appointment = new AppointmentDTO(
                    		rs3.getInt(1),
                    		rs3.getInt(2),
                    		rs3.getInt(3),
                    		rs3.getInt(4),
                    		rs3.getString(5),
                    		rs3.getString(6),
                    		rs3.getString(7));
                    appointment.setAppointmentDate(rs3.getString(8));
                    appointment.setAppointmentTime(rs3.getString(9)); 
                    		 
                    		
                                  
                    appointments.add(appointment);
                }
               
            } catch(SQLException ex) {
            	String str4="Error retrieving appointments for stylist with id " + stylistId + " from database: " + ex.getMessage();
                logger.error(str4);
            }
            return appointments;
        }
      

        @Override
        public List<AppointmentDTO> getAllAppointments() {
            List<AppointmentDTO> appointments = new ArrayList<>();
            AppointmentDTO appointment = null;

            try (
                 PreparedStatement statement = DBUtil.getConnection().prepareStatement("SELECT * FROM appointment");
                 ResultSet rs4 = statement.executeQuery()) {

            	while(rs4.next()) {
                     appointment = new AppointmentDTO(
                    		rs4.getInt(1),
                    		rs4.getInt(2),
                    		rs4.getInt(3),
                    		rs4.getInt(4),
                    		rs4.getString(5),
                    		rs4.getString(6),
                    		rs4.getString(7));
                     appointment.setAppointmentDate(rs4.getString(8));
                     appointment.setAppointmentTime(rs4.getString(9)); 
                     	 
                    appointments.add(appointment);
            	}
            } catch (SQLException e) {
                logger.error("Error getting all appointments", e);
            }

            return appointments;
        }

		@Override
		public List<AppointmentDTO> getAppointmentsOfToday() {
			
			return Collections.emptyList();
		}

		@Override
		public List<AppointmentDTO> getAppointmentsOfTomorrow() {
			
			return Collections.emptyList();
		}       
}