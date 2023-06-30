package com.virtusa.sbs.service;

import java.util.List;

import com.virtusa.sbs.dto.StylistDTO;

public interface StylistService {
	   
    boolean addStylist(StylistDTO stylist);

    boolean updateStylist(StylistDTO stylist);

    boolean deleteStylist(int stylistId);
    
    StylistDTO getStylistById(int stylistId);
    
    StylistDTO getStylistByEmail(String email);

    List<StylistDTO> getAllStylists();
}
