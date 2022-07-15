package com.manage.OEMS.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.manage.OEMS.model.Venue;

@Service
public class VenueRowMapper implements RowMapper<Venue> {

	@Override
	public Venue mapRow(ResultSet rs, int rowNum) throws SQLException {
		
Venue venue = new Venue();
		
		venue.setVenueId(rs.getInt("venue_id"));
		venue.setVenueName(rs.getString("venue_name"));
		venue.setVenuePlace(rs.getString("venue_place"));
		venue.setVenueContact(rs.getString("venue_contact"));
		venue.setMemberId(rs.getInt("member_id"));
			
		return venue;
	}

}
