package com.virtusa.sbs.dto;

public class CustomerDTO {
    private int customerId;
    private String custName;
    private String custEmail;
    private String custPassword;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String custName, String custEmail, String custPassword) {
        this.customerId = customerId;
        this.custName = custName;
        this.custEmail = custEmail;
        this.custPassword = custPassword;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return custName;
    }

    public void setName(String name) {
        this.custName = name;
    }

    public String getEmail() {
        return custEmail;
    }

    public void setEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getPassword() {
        return custPassword;
    }

    public void setPassword(String custPassword) {
        this.custPassword = custPassword;
    }

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + custName + ", email=" + custEmail + ", password="
				+ custPassword + "]";
	}
    
    
}

