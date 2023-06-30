package com.virtusa.sbs.service;

import java.util.List;

import com.virtusa.sbs.dto.ServiceDTO;

public interface ServiceService {

    boolean addService(ServiceDTO service);

    boolean updateService(ServiceDTO service);

    boolean deleteService(int serviceId);

    ServiceDTO getServiceById(int serviceId);

    List<ServiceDTO> getAllServices();
}

