package com.manage.OEMS.model;

public class Event {
	
	private int eventId;
	private String eventName;
	private int eventCost;
	private int venueId;
	
	
	
	public Event(int eventId, String eventName, int eventCost, int venueId) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventCost = eventCost;
		this.venueId = venueId;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public int getEventCost() {
		return eventCost;
	}
	public void setEventCost(int eventCost) {
		this.eventCost = eventCost;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	
	
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventCost=" + eventCost + ", venueId="
				+ venueId + "]";
	}
	
	
	
	

}
