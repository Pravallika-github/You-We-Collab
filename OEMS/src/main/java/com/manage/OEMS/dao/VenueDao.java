package com.manage.OEMS.dao;

import java.util.List;

import com.manage.OEMS.model.Venue;

public interface VenueDao {

	public List<Venue> getVenueByOrganizerId(int orgId);
	
    public Venue addVenue(Venue venue);
	
	public int updateVenue(Venue venue);
	
	public Venue getVenue(int venueId);
	
	public List<Venue> getVenues();
	
	public int deleteVenue(int venueId);

	public List<String> getAllDistinctPlaces();
	
	public List<Venue> getVenueOfPlace(String place);
	
	

}
