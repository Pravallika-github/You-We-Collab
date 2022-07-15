package com.manage.OEMS.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.manage.OEMS.model.Event;

@Service
public class EventRowMapper implements RowMapper<Event> {

	@Override
	public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
		
       Event event = new Event();
		
       event.setEventId(rs.getInt("event_id"));
       event.setEventName(rs.getString("event_name"));
       event.setEventCost(rs.getInt("event_cost"));
       event.setVenueId(rs.getInt("venue_id"));
		
		
		return event;
		
	}

}
