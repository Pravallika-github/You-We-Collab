package com.manage.OEMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.manage.OEMS.dao.EventDao;
import com.manage.OEMS.model.Event;

@org.springframework.stereotype.Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventDao eventDao;

	// Get event list by venue Id
	@Override
	public List<Event> getEventsByVenueId(int venueId) {
		return eventDao.getEventsByVenueId(venueId);
	}

	// Add Event
	@Override
	public Event addEvent(Event event) {
		return this.eventDao.addEvent(event);
	}

	// Get event list by Name and Venue Id
	@Override
	public Event getByNameAndVenueId(String EName, int VId) {
		return this.eventDao.getByNameAndVenueId(EName, VId);

	}

	// Get event By Id
	@Override
	public Event getEvent(int eventId) {
		return eventDao.getEvent(eventId);
	}

	// Update Event
	@Override
	public int updateEvent(Event event) {
		return eventDao.updateEvent(event);
	}

	// Delete Event
	@Override
	public int deleteEvent(int eventId) {
		return eventDao.deleteEvent(eventId);
	}

}
