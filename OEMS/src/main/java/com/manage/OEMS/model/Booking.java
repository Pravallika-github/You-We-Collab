package com.manage.OEMS.model;

import java.sql.Date;


public class Booking {
	
	private int bookingId;
	private Date date;
	private int guestCount;
	private String eventName;
	private String equipmentName;
	private String foodItemName;
	private int eventCost;
	private int equipmentCost;
	private int foodItemCost;
	private int totalCost;
	private String paymentStatus;
	private int memberId;
	private int venueId;
	private String selectedFoodItems;
	private String selectedEquipments;
	private int delStatus ;
	
	
	public Booking() {
		super();
	}

	public Booking(int bookingId, Date date, int guestCount, String eventName, String equipmentName,
			String foodItemName, int eventCost, int equipmentCost, int foodItemCost, int totalCost,
			String paymentStatus, int memberId, int venueId, String selectedFoodItems, String selectedEquipments) {
		super();
		this.bookingId = bookingId;
		this.date = date;
		this.guestCount = guestCount;
		this.eventName = eventName;
		this.equipmentName = equipmentName;
		this.foodItemName = foodItemName;
		this.eventCost = eventCost;
		this.equipmentCost = equipmentCost;
		this.foodItemCost = foodItemCost;
		this.totalCost = totalCost;
		this.paymentStatus = paymentStatus;
		this.memberId = memberId;
		this.venueId = venueId;
		this.selectedFoodItems = selectedFoodItems;
		this.selectedEquipments = selectedEquipments;
	}
	
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getBookingId(){
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getGuestCount() {
		return guestCount;
	}
	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getFoodItemName() {
		return foodItemName;
	}
	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}
	public int getEventCost() {
		return eventCost;
	}
	public void setEventCost(int eventCost) {
		this.eventCost = eventCost;
	}
	public int getEquipmentCost() {
		return equipmentCost;
	}
	public void setEquipmentCost(int equipmentCost) {
		this.equipmentCost = equipmentCost;
	}
	public int getFoodItemCost() {
		return foodItemCost;
	}
	public void setFoodItemCost(int foodItemCost) {
		this.foodItemCost = foodItemCost;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public String getSelectedFoodItems() {
		return selectedFoodItems;
	}
	public void setSelectedFoodItems(String selectedFoodItems) {
		this.selectedFoodItems = selectedFoodItems;
	}
	public String getSelectedEquipments() {
		return selectedEquipments;
	}
	public void setSelectedEquipments(String selectedEquipments) {
		this.selectedEquipments = selectedEquipments;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", date=" + date + ", guestCount=" + guestCount + ", eventName="
				+ eventName + ", equipmentName=" + equipmentName + ", foodItemName=" + foodItemName + ", eventCost="
				+ eventCost + ", equipmentCost=" + equipmentCost + ", foodItemCost=" + foodItemCost + ", totalCost=" + totalCost
				+ ", paymentStatus=" + paymentStatus + ", memberId=" + memberId + ", venueId=" + venueId
				+ ", selectedFoodItems=" + selectedFoodItems + ", selectedEquipments=" + selectedEquipments + "]";
	}
	
	
	
	
}
