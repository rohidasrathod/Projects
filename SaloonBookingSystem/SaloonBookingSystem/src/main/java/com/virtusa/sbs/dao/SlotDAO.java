package com.virtusa.sbs.dao;

import java.util.List;

import com.virtusa.sbs.dto.SlotDTO;

public interface SlotDAO {

    boolean addSlot(SlotDTO slot);

    boolean updateSlot(SlotDTO slot);

    boolean deleteSlot(int slotId);

    SlotDTO getSlotById(int slotId);

    List<SlotDTO> getAllAvailableSlots();

    List<SlotDTO> getAvailableSlotsByStylist(int stylistId);


}

