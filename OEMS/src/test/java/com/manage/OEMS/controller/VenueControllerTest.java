package com.manage.OEMS.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.manage.OEMS.model.Venue;
import com.manage.OEMS.service.NotificationService;
import com.manage.OEMS.service.VenueService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class VenueControllerTest {

	@Mock
	private VenueService service;

	@Mock
	private NotificationService notiService;

	@InjectMocks
	private VenueController controller;

	// Testing... getVenuesByOrganizerId Handler
	@Test
	public void testGetVenuesByOrganizerId() {

		List<Venue> venues = new ArrayList<>();
		venues.add(new Venue(100, "Sai", "Shirdi", "987654", 1000));

		when(service.getVenuesByOrganizerId(2)).thenReturn(venues);
		assertEquals(controller.getVenuesByOrganizerId(2), venues);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... getAllDistinctPlaces Handler
	@Test
	public void testGetAllDistinctPlaces() {

		List<String> places = new ArrayList<>();
		places.add("Pune");
		places.add("Mumbai");

		when(service.getAllDistinctPlaces()).thenReturn(places);
		assertEquals(places, controller.getAllDistinctPlaces());
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... getVenueOfPlace Handler
	@Test
	public void testGetVenueOfPlace() {

		List<Venue> venues = new ArrayList<>();
		venues.add(new Venue(100, "Sai", "Shirdi", "987654", 1000));

		when(service.getVenueOfPlace("Shirdi")).thenReturn(venues);
		assertEquals(venues, controller.getVenueOfPlace("Shirdi"));
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... addVenue Handler
	@Test
	public void testAddVenue() {

		Venue venue = new Venue(100, "Sai", "Shirdi", "987654", 1000);

		when(service.addVenue(venue)).thenReturn(venue);
		assertEquals(venue, controller.addVenue(venue));
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... getVenue Handler
	@Test
	public void testGetVenue() {
		Venue venue = new Venue(100, "Sai", "Shirdi", "987654", 1000);
		when(service.getVenue(100)).thenReturn(venue);
		assertEquals(venue, controller.getVenue(100));
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... getVenues Handler
	@Test
	public void testGetVenues() {
		List<Venue> venues = new ArrayList<>();
		venues.add(new Venue(100, "Sai", "Shirdi", "987654", 1000));
		when(service.getVenues()).thenReturn(venues);
		assertEquals(venues, controller.getVenues());
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... updateVenue Handler
	@Test
	public void testUpdateVenue() {
		Venue venue = new Venue(100, "Sai", "Shirdi", "987654", 1000);
		when(service.updateVenue(venue)).thenReturn(1);
		assertEquals(1, controller.updateVenue(venue));
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Testing... deleteVenue Handler
	@Test
	public void testDeleteVenue() {
		when(service.deleteVenue(100)).thenReturn(1);
		assertEquals(1, controller.deleteVenue(100));
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
