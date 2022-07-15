package com.manage.OEMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manage.OEMS.dao.EquipmentDao;
import com.manage.OEMS.dao.EventDao;
import com.manage.OEMS.dao.FoodItemDao;
import com.manage.OEMS.dao.VenueDao;
import com.manage.OEMS.model.Venue;

@org.springframework.stereotype.Service
public class VenueServiceImpl implements VenueService {

	@Autowired
	VenueDao venueDao;
	
	@Autowired
	EquipmentDao equipmentDao;
	
	@Autowired
	FoodItemDao foodItemDao;
	
	@Autowired
	EventDao eventDao;

	@Override
	public List<Venue> getVenuesByOrganizerId(int orgId) {
		return venueDao.getVenueByOrganizerId(orgId);
	}

	// Get Distinct Places
	@Override
	public List<String> getAllDistinctPlaces() {
		return venueDao.getAllDistinctPlaces();
	}

	// Venues by Place
	@Override
	public List<Venue> getVenueOfPlace(String place) {
		return venueDao.getVenueOfPlace(place);
	}

	// Add Venue
	@Override
	public Venue addVenue(Venue venue) {
		return this.venueDao.addVenue(venue);
	}

	// Get Venue by Id
	@Override
	public Venue getVenue(int venueId) {
		return venueDao.getVenue(venueId);
	}

	// List all venues
	@Override
	public List<Venue> getVenues() {
		return venueDao.getVenues();
	}

	// Update..
	@Override
	public int updateVenue(Venue venue) {
		return venueDao.updateVenue(venue);
	}

	// Delete...
	@Override
	public int deleteVenue(int venueId) {
		foodItemDao.deleteFoodItemByVenueId(venueId);
		eventDao.deleteEventByVenueId(venueId);
		equipmentDao.deleteEquipmentByVenueId(venueId);
		return venueDao.deleteVenue(venueId);
	}
	
	
	

}
