package com.virtusa.sbs.service;


import java.util.List;

import com.virtusa.sbs.dao.AppointmentDAO;
import com.virtusa.sbs.dao.AppointmentDAOImpl;
import com.virtusa.sbs.dto.AppointmentDTO;

public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    public AppointmentServiceImpl(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }
    public AppointmentServiceImpl() {
    	
    }

    @Override
    public boolean bookAppointment(AppointmentDTO appointment) {
        return appointmentDAO.bookAppointment(appointment);
    }

    @Override
    public boolean updateAppointment(AppointmentDTO appointment) {
        return appointmentDAO.updateAppointment(appointment);
    }

    @Override
    public boolean deleteAppointment(int appointmentId) {
        return appointmentDAO.deleteAppointment(appointmentId);
    }

    @Override
    public AppointmentDTO getAppointmentById(int appointmentId) {
        return appointmentDAO.getAppointmentById(appointmentId);
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByCustomerId(int customerId) {
        return appointmentDAO.getAppointmentsByCustomerId(customerId);
    }

    @Override
    public List<AppointmentDTO> getAppointmentsByStylistId(int stylistId) {
        return appointmentDAO.getAppointmentsByStylistId(stylistId);
    }

    @Override
    public List<AppointmentDTO> getAppointmentsOfToday() {
        return appointmentDAO.getAppointmentsOfToday();
    }

    @Override
    public List<AppointmentDTO> getAppointmentsOfTomorrow() {
        return appointmentDAO.getAppointmentsOfTomorrow();
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentDAO.getAllAppointments();
    }
}
