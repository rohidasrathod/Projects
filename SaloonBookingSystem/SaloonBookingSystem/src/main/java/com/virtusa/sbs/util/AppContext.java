package com.virtusa.sbs.util;

import com.virtusa.sbs.dao.CustomerDAOImpl;
import com.virtusa.sbs.dao.ServiceDAOImpl;
import com.virtusa.sbs.service.AppointmentServiceImpl;
import com.virtusa.sbs.service.CustomerServiceImpl;
import com.virtusa.sbs.service.ServiceServiceImpl;
import com.virtusa.sbs.service.SlotServiceImpl;
import com.virtusa.sbs.service.StylistServiceImpl;

public class AppContext {
	private static AppContext appContext;
	private AppContext() {}


	public static AppContext getInstance() {
		if(appContext == null) {
			appContext = new AppContext();
		}
	return appContext;
	}


	@SuppressWarnings("unchecked")

	public <T> T getObject(String beanName) {

		if(beanName.equalsIgnoreCase("customerDAO")) {

		return(T) new CustomerDAOImpl();
		}

		if(beanName.equalsIgnoreCase("serviceDAO")) {

			return (T) new ServiceDAOImpl();
		}

		if(beanName.equalsIgnoreCase("StylistService")) {

			return (T) new StylistServiceImpl();

		}

		if(beanName.equalsIgnoreCase("SlotService")) {

			return (T) new SlotServiceImpl();

		}

		if(beanName.equalsIgnoreCase("ServiceService")) {

			return (T) new ServiceServiceImpl();

		}

		if(beanName.equalsIgnoreCase("AppointmentService")) {

			return (T) new AppointmentServiceImpl();

		}

		if(beanName.equalsIgnoreCase("CustomerService")) {

			return (T) new CustomerServiceImpl();

		}
		
		return null;
	}

}




