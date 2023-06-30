package com.virtusa.sbs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.virtusa.sbs.dto.SlotDTO;
import com.virtusa.sbs.util.DBUtil;


public class SlotDAOImpl implements SlotDAO {

	String slotid="slot_id";
	String stid="stylist_id";
	String avDate="availability_date";
	String avTime="availability_time";
	String slotAvailable="slot_available";
	
	private static final Logger logger = LogManager.getLogger(SlotDAOImpl.class);
    public SlotDAOImpl() {
        // Slot constructor
    }

    @Override
    public boolean addSlot(SlotDTO slot) {
        try( PreparedStatement stmt = DBUtil.getConnection().prepareStatement(
                "INSERT INTO slots (stylist_id, availability_date, availability_time) " +
                "VALUES (?, ?, ?)"
        )) {
           
            stmt.setInt(1, slot.getStylistId());
            stmt.setString(2, slot.getAvailabilityDate());
            stmt.setString(3, slot.getAvailabilityTime());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateSlot(SlotDTO slot) {
        try (PreparedStatement stmt = DBUtil.getConnection().prepareStatement(
                "UPDATE slots SET stylist_id = ?, availability_date = ?, availability_time = ?, slot_available = ? " +
                "WHERE slot_id = ?"
        );){
            
            stmt.setInt(1, slot.getStylistId());
            stmt.setString(2, slot.getAvailabilityDate());
            stmt.setString(3, slot.getAvailabilityTime());
            stmt.setBoolean(4, slot.isSlotAvailable());
            stmt.setInt(5, slot.getSlotId());
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
           logger.info(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteSlot(int slotId) {
        try (PreparedStatement stmt = DBUtil.getConnection().prepareStatement(
                "DELETE FROM slots WHERE slot_id = ?"
        )){
            
            stmt.setInt(1, slotId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
            return false;
        }
    }

    @Override
    public SlotDTO getSlotById(int slotId) {
        try(PreparedStatement stmt = DBUtil.getConnection().prepareStatement(
                    "SELECT * FROM slots WHERE slot_id = ?"
            )) {
            
            stmt.setInt(1, slotId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                SlotDTO slot = new SlotDTO();
                slot.setSlotId(rs.getInt(slotid));
                slot.setStylistId(rs.getInt(stid));
                slot.setAvailabilityDate(rs.getString(avDate));
                slot.setAvailabilityTime(rs.getString(avTime));
                slot.setSlotAvailable(rs.getBoolean(slotAvailable));
                return slot;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
            return null;
        }
    }
    
    @Override
    public List<SlotDTO> getAllAvailableSlots() {
        List<SlotDTO> slots = new ArrayList<>();
        String query = "SELECT * FROM slots WHERE slot_available = true";
        try(PreparedStatement stmt = DBUtil.getConnection().prepareStatement(query)) {
            
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SlotDTO slot = new SlotDTO(
                        rs.getInt(slotid),
                        rs.getInt(stid),
                        rs.getString(avDate),
                        rs.getString(avTime),
                        rs.getBoolean(slotAvailable)
                );
                slots.add(slot);
            }
        } catch (SQLException ex) {
        	logger.info(ex.toString());
        }
        return slots;
    }

    @Override
    public List<SlotDTO> getAvailableSlotsByStylist(int stylistId) {
        List<SlotDTO> slots = new ArrayList<>();
        String query = "SELECT * FROM slots WHERE stylist_id = ? AND slot_available = true";
        try( PreparedStatement stmt = DBUtil.getConnection().prepareStatement(query)) {
            
           
            stmt.setInt(1, stylistId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                SlotDTO slot = new SlotDTO(
                        rs.getInt(slotid),
                        rs.getInt(stid),
                        rs.getString(avDate),
                        rs.getString(avTime),
                        rs.getBoolean(slotAvailable)
                );
                slots.add(slot);
            }
        } catch (SQLException ex) {
        	logger.info(ex.toString());
        }
        return slots;
    }
    
    public SlotDTO getSlotDetailsForAppointment(int slotId) {
    	SlotDTO slotdto = new SlotDTO();
        try(
            PreparedStatement stmt = DBUtil.getConnection().prepareStatement("SELECT * FROM slots WHERE slot_id = ?")) {

            stmt.setInt(1, slotId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	slotdto.setStylistId(rs.getInt(2));
            	slotdto.setAvailabilityDate(rs.getString(3));
            	slotdto.setAvailabilityTime(rs.getString(4));
            }
            return slotdto;          

        } catch (SQLException ex) {
            // handle exceptions
        	logger.info(ex.toString());
        }
		return null;
    }

}


