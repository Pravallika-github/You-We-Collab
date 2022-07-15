package com.manage.OEMS.model;

import java.sql.Date;

public class BookingDetail {
	
	private int venueId;
	
	private int memberId;
	
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
    	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	private String venueName;
	private String venuePlace;
	private String venueContact;
	private int delStatus;
	
	
	
	
	
	public BookingDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingDetail(int venueId, int memberId, int bookingId, Date date, int guestCount, String eventName,
			String equipmentName, String foodItemName, int eventCost, int equipmentCost, int foodItemCost,
			int totalCost, String paymentStatus, String firstName, String lastName, String phoneNumber, String email,
			String venueName, String venuePlace, String venueContact, int delStatus) {
		super();
		this.venueId = venueId;
		this.memberId = memberId;
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
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.venueName = venueName;
		this.venuePlace = venuePlace;
		this.venueContact = venueContact;
		this.delStatus = delStatus;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getBookingId() {
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getVenuePlace() {
		return venuePlace;
	}
	public void setVenuePlace(String venuePlace) {
		this.venuePlace = venuePlace;
	}
	public String getVenueContact() {
		return venueContact;
	}
	public void setVenueContact(String venueContact) {
		this.venueContact = venueContact;
	}
	@Override
	public String toString() {
		return "BookingDetail [venueId=" + venueId + ", memberId=" + memberId + ", bookingId=" + bookingId + ", date="
				+ date + ", guestCount=" + guestCount + ", eventName=" + eventName + ", equipmentName=" + equipmentName
				+ ", foodItemName=" + foodItemName + ", eventCost=" + eventCost + ", equipmentCost=" + equipmentCost
				+ ", foodItemCost=" + foodItemCost + ", totalCost=" + totalCost + ", paymentStatus=" + paymentStatus
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", venueName=" + venueName + ", venuePlace=" + venuePlace + ", venueContact=" + venueContact
				+ "]";
	}
	
	
	
	

	

}
