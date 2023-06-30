package com.virtusa.sbs.dao;

import java.util.List;

import com.virtusa.sbs.dto.ServiceDTO;

public interface ServiceDAO {

    boolean addService(ServiceDTO service);

    boolean updateService(ServiceDTO service);

    boolean deleteService(int serviceId);

    ServiceDTO getServiceById(int serviceId);

    List<ServiceDTO> getAllServices();
}

