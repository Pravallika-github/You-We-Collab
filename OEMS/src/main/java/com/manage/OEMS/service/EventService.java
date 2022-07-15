package com.manage.OEMS.service;

import java.util.List;

import com.manage.OEMS.model.Event;

public interface EventService {

	public List<Event> getEventsByVenueId(int eventId);

	public Event addEvent(Event event);

	public Event getByNameAndVenueId(String EName, int VId);

	public Event getEvent(int eventId);

	public int updateEvent(Event event);

	public int deleteEvent(int eventId);
	
}
