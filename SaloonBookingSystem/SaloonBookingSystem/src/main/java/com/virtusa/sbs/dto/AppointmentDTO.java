package com.virtusa.sbs.dto;

public class AppointmentDTO {
    private int appointmentId;
    private int customerId;
    private int stylistId;
    private int serviceId;
    private String customerName;
    private String stylistName;
    private String serviceName;
    private String appointmentDate;
    private String appointmentTime;
    
    
    public AppointmentDTO() {
    	
    }
    
    // constructor
    public AppointmentDTO(int appointmentId, int customerId, int stylistId, int serviceId, String customerName,
                           String stylistName, String serviceName) {
        this.appointmentId = appointmentId;
        this.customerId = customerId;
        this.stylistId = stylistId;
        this.serviceId = serviceId;
        this.customerName = customerName;
        this.stylistName = stylistName;
        this.serviceName = serviceName;
         
    }
    
    // getters and setters
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStylistId() {
        return stylistId;
    }

    public void setStylistId(int stylistId) {
        this.stylistId = stylistId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStylistName() {
        return stylistName;
    }

    public void setStylistName(String stylistName) {
        this.stylistName = stylistName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

	@Override
	public String toString() {
		return "AppointmentDTO [appointmentId=" + appointmentId + ", customerId=" + customerId + ", stylistId="
				+ stylistId + ", serviceId=" + serviceId + ", customerName=" + customerName + ", stylistName="
				+ stylistName + ", serviceName=" + serviceName + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + "]";
	}
    
    
}
