package com.manage.OEMS.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manage.OEMS.mappers.EventRowMapper;
import com.manage.OEMS.model.Event;

@Repository
public class EventDaoImpl implements EventDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	EventRowMapper rowMapper;

	// Add event
	@Override
	public Event addEvent(Event event) {
		Object[] args = { event.getEventName(), event.getEventCost(), event.getVenueId() };

		String query = "INSERT INTO event (event_name, event_cost, venue_id)" + "   VALUES (?,?,?)";

		this.jdbcTemplate.update(query, args);
		return event;
	}

	// Update Event
	@Override
	public int updateEvent(Event event) {
		String query = "update event set event_name=?, event_cost=? where event_id=? ";

		Object[] args = { event.getEventName(), event.getEventCost(), event.getEventId() };

		return this.jdbcTemplate.update(query, args);
	}

	// Get Event
	@Override
	public Event getEvent(int eventId) {
		String query = "select * from event where event_id=?";

		return this.jdbcTemplate.queryForObject(query, rowMapper, eventId);
	}

	// Delete Event
	@Override
	public int deleteEvent(int eventId) {
		String query = "delete from event where event_id=?";
		Object[] args = { eventId };
		return this.jdbcTemplate.update(query, args);
	}

	// Delete Event by Venue ID
	@Override
	public int deleteEventByVenueId(int venueId) {
		String query = "delete from event where venue_id=?";
		return this.jdbcTemplate.update(query, venueId);
	}

	// Get event list by venue Id
	@Override
	public List<Event> getEventsByVenueId(int venueId) {
		String query = "select * from event where venue_id=?";
		return this.jdbcTemplate.query(query, rowMapper, venueId);
	}

	// Get event list by Name and Venue Id
	@Override
	public Event getByNameAndVenueId(String eName, int vId) {
		String query = "select * from event where event_name=? and venue_id=?";
		return this.jdbcTemplate.queryForObject(query, rowMapper, eName, vId);

	}

}
