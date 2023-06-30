package com.virtusa.sbs.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.virtusa.sbs.dto.StylistDTO;
import com.virtusa.sbs.util.DBUtil;

public class StylistDAOImpl implements StylistDAO {   
	private static final Logger logger = LogManager.getLogger(StylistDAOImpl.class);
	String stid="stylist_id";
	String name="name";
	String semail="email";
	String password="password";
    public StylistDAOImpl() {
      //Stylish implementation
    }

    @Override
    public boolean addStylist(StylistDTO stylist) {
    	int rowsInserted =0;
    	String query = "INSERT INTO stylist (name, email, password) VALUES (?, ?, ?)";
        try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(query);){
           

            statement.setString(1, stylist.getName());
            statement.setString(2, stylist.getEmail());
            statement.setString(3, stylist.getPassword());
            rowsInserted = statement.executeUpdate();
            
        } catch (SQLException ex) {
            // handle exception
        	logger.info(ex.toString());
            return false;
        }
        

        return (rowsInserted == 1);
    }
    
    public int getEmpId(String email)
    {
    	String query = "select stylist_id from stylist where email=?";
    	try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(query);){
       	

            statement.setString(1, email);
          ResultSet rts = statement.executeQuery();
          while(rts.next())
          {
        	  return rts.getInt(1);
          }
            
        } catch (SQLException ex) {
            // handle exception
        	logger.info(ex.toString());
            
        }
    	return 0;
    }
     

    @Override
    public boolean updateStylist(StylistDTO stylist) {
    	String query = "UPDATE stylist SET name=?, email=?, password=? WHERE stylist_id=?";
        try (PreparedStatement statement = DBUtil.getConnection().prepareStatement(query);){
            
            
            statement.setString(1, stylist.getName());
            statement.setString(2, stylist.getEmail());
            statement.setString(3, stylist.getPassword());
            statement.setInt(4, stylist.getStylistId());
            int rowsUpdated = statement.executeUpdate();
            return (rowsUpdated == 1);
        } catch (SQLException ex) {
            // handle exception
        	logger.info(ex.toString());
            return false;
        }
    }

    @Override
    public boolean deleteStylist(int stylistId) {
    	String query = "DELETE FROM stylist WHERE stylist_id=?";
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(query);) {
            
            
            statement.setInt(1, stylistId);
            int rowsDeleted = statement.executeUpdate();
            return (rowsDeleted == 1);
        } catch (SQLException ex) {
            // handle exception
        	logger.info(ex.toString());
            return false;
        }
    }
    
    @Override
    public StylistDTO getStylistById(int stylistId) {
    	String query = "SELECT * FROM stylist WHERE stylist_id = ?";
    	try (PreparedStatement stmt = DBUtil.getConnection().prepareStatement(query);){
	        
	        
	        stmt.setInt(1, stylistId);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	
	            StylistDTO stylist = new StylistDTO();
	            stylist.setStylistId(rs.getInt(stid));
	            stylist.setName(rs.getString(name));
	            stylist.setEmail(rs.getString(semail));
	            stylist.setPassword(rs.getString(password));
	            return stylist;
	        }
    	}catch(SQLException ex) {
    		logger.info(ex.toString());
    	}
        return null;
    }

    @Override
    public StylistDTO getStylistByEmail(String email) {
    	StylistDTO stylist = null;
    	String query = "SELECT * FROM stylist WHERE email=?";
        try(PreparedStatement statement = DBUtil.getConnection().prepareStatement(query);) {
            
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                stylist = new StylistDTO(
                		rs.getInt(stid), 
                		rs.getString(name), 
                		rs.getString(semail),
                		rs.getString(password));
            } 
        } catch (SQLException ex) {
           
        	logger.info(ex.toString());
        }
        return stylist;
    }

    @Override
    public List<StylistDTO> getAllStylists() {
    	String query = "SELECT * FROM stylist";
        try(Statement statement = DBUtil.getConnection().createStatement();) {
            
            
            ResultSet resultSet = statement.executeQuery(query);
            List<StylistDTO> stylists = new ArrayList<>();
            while (resultSet.next()) {
                StylistDTO stylist = new StylistDTO();
                stylist.setStylistId(resultSet.getInt(stid));
                stylist.setName(resultSet.getString(name));
                stylist.setEmail(resultSet.getString(semail));
                stylist.setPassword(resultSet.getString(password));
                stylists.add(stylist);
            }
            return stylists;
        } catch (SQLException ex) {
            // handle exception
        	logger.info(ex.toString());
            return Collections.emptyList();
        }
    }
    
    
    public String getStylistDetailsForAppointment(int stylistId) {
    	try(PreparedStatement stmt = DBUtil.getConnection().prepareStatement("SELECT name FROM stylist WHERE stylist_id = ?")) {
			stmt.setInt(1, stylistId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception ex) {
			logger.info(ex.toString());
		}
    	return null;
    }
}


