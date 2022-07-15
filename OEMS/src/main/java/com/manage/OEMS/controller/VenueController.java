package com.manage.OEMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.OEMS.model.Venue;
import com.manage.OEMS.service.NotificationService;
import com.manage.OEMS.service.VenueService;

@RestController
@RequestMapping("/venue")
@CrossOrigin("*")
public class VenueController {

	@Autowired
	VenueService venueService;

	@Autowired
	NotificationService notificationService;

	/// handler to get All venues by organizer Id
	@GetMapping("/organizer/{orgId}")
	public List<Venue> getVenuesByOrganizerId(@PathVariable("orgId") int orgId) {
		return venueService.getVenuesByOrganizerId(orgId);
	}

	/// handler to get All distinct places
	@GetMapping("/places")
	public List<String> getAllDistinctPlaces() {
		return venueService.getAllDistinctPlaces();
	}

	// handler to get venue for selected place
	@GetMapping("/getVenues/{place}")
	List<Venue> getVenueOfPlace(@PathVariable("place") String place) {
		return venueService.getVenueOfPlace(place);
	}

	// Add Venue Request Handler
	@PostMapping("/add")
	public Venue addVenue(@RequestBody Venue venue) {
		this.notificationService.notifyOnVenueAdd(venue);
		return this.venueService.addVenue(venue);
	}

	// Get venue by venue Id
	@GetMapping("/getVenue/{venueId}")
	public Venue getVenue(@PathVariable("venueId") int venueId) {
		return venueService.getVenue(venueId);
	}

	// List of venues
	@GetMapping("/getVenues")
	public List<Venue> getVenues() {
		return venueService.getVenues();
	}

	// Update Venue
	@PutMapping("/updateVenue")
	public int updateVenue(@RequestBody Venue venue) {
		return venueService.updateVenue(venue);
	}

	// Delete Venue
	@DeleteMapping("/deleteVenue/{venueId}")
	public int deleteVenue(@PathVariable("venueId") int venueId) {
		
		return venueService.deleteVenue(venueId);
	}
	

}
