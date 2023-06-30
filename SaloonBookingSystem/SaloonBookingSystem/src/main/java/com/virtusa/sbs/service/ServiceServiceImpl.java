package com.virtusa.sbs.service;

import java.util.List;
import com.virtusa.sbs.dao.ServiceDAO;
import com.virtusa.sbs.dto.ServiceDTO;
import com.virtusa.sbs.util.AppContext;

public class ServiceServiceImpl implements ServiceService {

	private ServiceDAO  serviceDAO = AppContext.getInstance().getObject("ServiceDAO");

    public ServiceServiceImpl(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    public ServiceServiceImpl() {
		// Service implementation
	}

	@Override
    public boolean addService(ServiceDTO service) {
        return serviceDAO.addService(service);
    }

    @Override
    public boolean updateService(ServiceDTO service) {
        return serviceDAO.updateService(service);
    }

    @Override
    public boolean deleteService(int serviceId) {
        return serviceDAO.deleteService(serviceId);
    }

    @Override
    public ServiceDTO getServiceById(int serviceId) {
        return serviceDAO.getServiceById(serviceId);
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        return serviceDAO.getAllServices();
    }
}
