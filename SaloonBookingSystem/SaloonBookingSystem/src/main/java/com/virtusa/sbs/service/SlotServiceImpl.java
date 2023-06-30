package com.virtusa.sbs.service;

import java.util.List;

import com.virtusa.sbs.dao.SlotDAO;
import com.virtusa.sbs.dao.SlotDAOImpl;
import com.virtusa.sbs.dto.SlotDTO;


public class SlotServiceImpl implements SlotService {
    
	private SlotDAO slotDAO = new SlotDAOImpl();

    public SlotServiceImpl(SlotDAO slotDAO) {
        this.slotDAO = slotDAO;
    }
    
    public SlotServiceImpl() {
    	//Slot implementation
    }

    @Override
    public boolean addSlot(SlotDTO slot) {
        return slotDAO.addSlot(slot);
    }

    @Override
    public boolean updateSlot(SlotDTO slot) {
        return slotDAO.updateSlot(slot);
    }

    @Override
    public boolean deleteSlot(int slotId) {
        return slotDAO.deleteSlot(slotId);
    }

    @Override
    public SlotDTO getSlotById(int slotId) {
        return slotDAO.getSlotById(slotId);
    }

    @Override
    public List<SlotDTO> getAllAvailableSlots() {
        return slotDAO.getAllAvailableSlots();
    }

    @Override
    public List<SlotDTO> getAvailableSlotsByStylist(int stylistId) {
        return slotDAO.getAvailableSlotsByStylist(stylistId);
    }
}
