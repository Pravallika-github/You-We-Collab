package com.manage.OEMS.dao;

import java.util.List;

import com.manage.OEMS.model.Event;

public interface EventDao {
	
    public Event addEvent(Event event);
	
	public int updateEvent(Event event);
	
	public Event getEvent(int eventId);
	
	public int deleteEvent(int eventId);

	public List<Event> getEventsByVenueId(int eventId);

	public Event getByNameAndVenueId(String eName, int vId);

	public int deleteEventByVenueId(int venueId);

}
