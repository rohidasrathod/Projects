package com.virtusa.sbs.service;

import java.util.List;

import com.virtusa.sbs.dto.AppointmentDTO;

public interface AppointmentService {
    
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

