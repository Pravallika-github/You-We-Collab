package com.manage.OEMS.model;

public class Equipment {
	
	private int equipmentId;
	private String equipmentName;
	private int equipmentCost;
	private int venueId;
	
	
	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Equipment(int equipmentId, String equipmentName, int equipmentCost, int venueId) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.equipmentCost = equipmentCost;
		this.venueId = venueId;
	}
	public int getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public int getEquipmentCost() {
		return equipmentCost;
	}
	public void setEquipmentCost(int equipmentCost) {
		this.equipmentCost = equipmentCost;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	
	
	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", equipmentName=" + equipmentName + ", equipmentCost="
				+ equipmentCost + ", venueId=" + venueId + "]";
	}
	
	
	

}
