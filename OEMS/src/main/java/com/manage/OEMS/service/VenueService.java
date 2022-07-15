package com.manage.OEMS.service;

import java.util.List;

import com.manage.OEMS.model.Venue;

public interface VenueService {

	public List<Venue> getVenuesByOrganizerId(int orgId);

	public List<String> getAllDistinctPlaces();

	public List<Venue> getVenueOfPlace(String place);

	public Venue addVenue(Venue venue);

	public Venue getVenue(int venueId);

	public List<Venue> getVenues();

	public int updateVenue(Venue venue);

	public int deleteVenue(int venueId);

}
