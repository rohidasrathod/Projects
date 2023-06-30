package com.virtusa.sbs.service;

import java.util.List;

import com.virtusa.sbs.dao.StylistDAO;
import com.virtusa.sbs.dao.StylistDAOImpl;
import com.virtusa.sbs.dto.StylistDTO;

public class StylistServiceImpl implements StylistService {

    private StylistDAO stylistDAO = new StylistDAOImpl();

    public StylistServiceImpl(StylistDAO stylistDAO) {
        this.stylistDAO = stylistDAO;
    }

    public StylistServiceImpl() {
		// Stylish implementation
	}

	@Override
    public boolean addStylist(StylistDTO stylist) {
        return stylistDAO.addStylist(stylist);
    }

    @Override
    public boolean updateStylist(StylistDTO stylist) {
        return stylistDAO.updateStylist(stylist);
    }

    @Override
    public boolean deleteStylist(int stylistId) {
        return stylistDAO.deleteStylist(stylistId);
    }

    @Override
    public StylistDTO getStylistByEmail(String email) {
        return stylistDAO.getStylistByEmail(email);
    }

    @Override
    public List<StylistDTO> getAllStylists() {
        return stylistDAO.getAllStylists();
    }

	@Override
	public StylistDTO getStylistById(int stylistId) {
		return stylistDAO.getStylistById(stylistId);
	}
}
