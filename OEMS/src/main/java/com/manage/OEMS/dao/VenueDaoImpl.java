package com.manage.OEMS.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.manage.OEMS.mappers.VenueRowMapper;
import com.manage.OEMS.model.Venue;

@Repository
public class VenueDaoImpl implements VenueDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	VenueRowMapper rowMapper;

	// Method to get List of Venue By OrganizerId
	@Override
	public List<Venue> getVenueByOrganizerId(int orgId) {
		String query = "select * from venue where member_id = ?";
		return this.jdbcTemplate.query(query, rowMapper, orgId);
	}

	// Method to get distinct places
	public List<String> getAllDistinctPlaces() {
		String query = "select distinct venue_place from venue";
		return this.jdbcTemplate.query(query, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("venue_place");
			}
		});
	}

	// Method to get venue for selected place
	public List<Venue> getVenueOfPlace(String place) {
		String query = "select * from venue where venue_place =?";
		return this.jdbcTemplate.query(query, rowMapper, place);
	}

	// Method to add Venue in database
	@Override
	public Venue addVenue(Venue venue) {
		Object[] args = { venue.getVenueName(), venue.getVenuePlace(), venue.getVenueContact(), venue.getMemberId() };
		String query = "INSERT INTO venue (venue_name,venue_place, venue_contact,member_id)" + "   VALUES (?,?,?,?)";
		this.jdbcTemplate.update(query, args);
		return venue;
	}

	// Method to Update Venue Details
	@Override
	public int updateVenue(Venue venue) {
		String query = "update venue set venue_name=?, venue_place=?, venue_contact=? where venue_id=?";
		Object[] args = { venue.getVenueName(), venue.getVenuePlace(), venue.getVenueContact(), venue.getVenueId() };
		return this.jdbcTemplate.update(query, args);
	}

	// Method to get single venue
	@Override
	public Venue getVenue(int venueId) {
		String query = "select * from venue where venue_id=?";
		return this.jdbcTemplate.queryForObject(query, rowMapper, venueId);
	}

	// List of All Venues
	@Override
	public List<Venue> getVenues() {
		String query = "select * from venue";
		return this.jdbcTemplate.query(query, rowMapper);
	}

	// Delete Venue.
	@Override
	public int deleteVenue(int venueId) {
		String query = "delete from venue where venue_id=?";
		Object[] args = { venueId };
		return this.jdbcTemplate.update(query, args);

	}

}
