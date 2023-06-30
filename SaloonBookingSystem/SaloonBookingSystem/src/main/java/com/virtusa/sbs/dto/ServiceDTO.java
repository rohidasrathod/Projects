package com.virtusa.sbs.dto;

import java.math.BigDecimal;

public class ServiceDTO {
    private int serviceId;
    private String name;
    private BigDecimal price;

    public ServiceDTO(int serviceId, String name, BigDecimal price) {
        this.serviceId = serviceId;
        this.name = name;
        this.price = price;
    }

    public ServiceDTO() {
		// Service model
	}

	public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

	@Override
	public String toString() {
		return "ServiceDTO [serviceId=" + serviceId + ", name=" + name + ", price=" + price + "]";
	}

   
}
