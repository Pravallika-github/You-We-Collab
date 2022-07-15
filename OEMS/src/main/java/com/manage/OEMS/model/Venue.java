package com.manage.OEMS.model;

public class Venue {
	
	private int venueId;
	private String venueName;
	private String venuePlace;
	private String venueContact;
	private int memberId;
	
	
	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Venue(int venueId, String venueName, String venuePlace, String venueContact, int memberId) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.venuePlace = venuePlace;
		this.venueContact = venueContact;
		this.memberId = memberId;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
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
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	
	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", venueName=" + venueName + ", venuePlace=" + venuePlace
				+ ", venueContact=" + venueContact + ", memberId=" + memberId + "]";
	}
	
	
	
	

}
