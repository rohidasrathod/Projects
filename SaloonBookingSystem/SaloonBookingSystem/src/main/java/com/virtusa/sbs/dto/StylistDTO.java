package com.virtusa.sbs.dto;

public class StylistDTO {
    private int stylistId;
    private String name;
    private String email;
    private String password;

    public StylistDTO(int stylistId, String name, String email, String password) {
        this.stylistId = stylistId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public StylistDTO() {
	}

	public int getStylistId() {
        return stylistId;
    }

    public void setStylistId(int stylistId) {
        this.stylistId = stylistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	@Override
	public String toString() {
		return "StylistDTO [stylistId=" + stylistId + ", name=" + name + ", email=" + email + ", password=" + password
				+ "]";
	}
    
    
}

