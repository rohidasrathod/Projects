package com.virtusa.sbs.dto;

public class SlotDTO {
    private int slotId;
    private int stylistId;
    private String availabilityDate;
    private String availabilityTime;
    private boolean slotAvailable;

    public SlotDTO() {}

    public SlotDTO(int slotId, int stylistId, String availabilityDate, String availabilityTime, boolean slotAvailable) {
        this.slotId = slotId;
        this.stylistId = stylistId;
        this.availabilityDate = availabilityDate;
        this.availabilityTime = availabilityTime;
        this.slotAvailable = slotAvailable;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getStylistId() {
        return stylistId;
    }

    public void setStylistId(int stylistId) {
        this.stylistId = stylistId;
    }

    public String getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(String availabilityDate) {
        this.availabilityDate = availabilityDate;
    }

    public String getAvailabilityTime() {
        return availabilityTime;
    }

    public void setAvailabilityTime(String availabilityTime) {
        this.availabilityTime = availabilityTime;
    }

    public boolean isSlotAvailable() {
        return slotAvailable;
    }

    public void setSlotAvailable(boolean slotAvailable) {
        this.slotAvailable = slotAvailable;
    }

	@Override
	public String toString() {
		return "SlotDTO [slotId=" + slotId + ", stylistId=" + stylistId + ", availabilityDate=" + availabilityDate
				+ ", availabilityTime=" + availabilityTime + ", slotAvailable=" + slotAvailable + "]";
	}
    
    
}

