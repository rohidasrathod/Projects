package com.virtusa.sbs.dao;

import java.util.List;

import com.virtusa.sbs.dto.AppointmentDTO;

public interface AppointmentDAO {
    
    boolean bookAppointment(AppointmentDTO appointment);

    boolean updateAppointment(AppointmentDTO appointment);

    boolean deleteAppointment(int appointmentId);

    AppointmentDTO getAppointmentById(int appointmentId);

    List<AppointmentDTO> getAppointmentsByCustomerId(int customerId);

    List<AppointmentDTO> getAppointmentsByStylistId(int stylistId);

    List<AppointmentDTO> getAppointmentsOfToday();
    
    List<AppointmentDTO> getAppointmentsOfTomorrow();

    List<AppointmentDTO> getAllAppointments();
    

}

