package com.manage.OEMS.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.manage.OEMS.dao.EquipmentDao;
import com.manage.OEMS.dao.EventDao;
import com.manage.OEMS.dao.FoodItemDao;
import com.manage.OEMS.dao.VenueDao;
import com.manage.OEMS.model.Venue;

class VenueServiceImplTest {

	@Mock
	VenueDao venueDao;

	@Mock
	EventDao eventDao;;

	@Mock
	FoodItemDao foodItemDao;

	@Mock
	EquipmentDao equipmentDao;

	@InjectMocks
	VenueServiceImpl service;

	@BeforeEach
	public void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	// Method to Test getVenuesByOrganizerId
	@Test
	public void testGetVenuesByOrganizerId() {

		int orgId = 100;
		List<Venue> venues = new ArrayList<>();
		venues.add(new Venue(100, "Sai", "Shirdi", "987654", 1000));

		when(service.getVenuesByOrganizerId(orgId)).thenReturn(venues);
		assertEquals(service.getVenuesByOrganizerId(orgId).size(), 1);
	}

	// Method to Test getgetVenueOfPlace
	@Test
	public void testGetVenueOfPlace() {

		String place = "Shirdi";
		List<Venue> venues = new ArrayList<>();
		venues.add(new Venue(107, "Sai", "Shirdi", "987654", 1015));

		when(service.getVenueOfPlace(place)).thenReturn(venues);
		assertEquals(service.getVenueOfPlace(place).size(), 1);
	}

	// Method to Test AddVenue
	@Test
	public void testAddVenue() {

		Venue venue = new Venue(101, "Sai", "Shirdi", "987654", 1010);
		when(service.addVenue(venue)).thenReturn(venue);
		Venue a = service.addVenue(venue);
		assertEquals(a.getVenueName(), "Sai");
	}

	// Method to Test GetVenuebyId
	@Test
	public void testGetVenuebyId() {

		int VenueId = 106;
		Venue venue = new Venue(106, "Sai", "Shirdi", "987654", 1015);
		when(service.getVenue(VenueId)).thenReturn(venue);
		assertEquals(service.getVenue(VenueId), venue);
	}

	// Method to Test GetVenues
	@Test
	public void testGetVenues() {

		List<Venue> venues = new ArrayList<>();
		venues.add(new Venue(102, "Sai", "Shirdi", "987654", 1011));
		venues.add(new Venue(103, "Balaji", "Nagpur", "987654", 1012));

		when(service.getVenues()).thenReturn(venues);
		assertEquals(service.getVenues().size(), 2);
	}

	// Method to Test UpdateVenue
	@Test
	public void testUpdateVenue() {

		Venue venue1 = new Venue(104, "Sai", "Shirdi", "987654", 1013);
		when(service.updateVenue(venue1)).thenReturn(1);
		assertEquals(service.updateVenue(venue1), 1);
	}

	// Method to Test DeleteVenue
	@Test
	public void testDeleteVenue() {

		when(foodItemDao.deleteFoodItemByVenueId(1)).thenReturn(1);
		when(eventDao.deleteEventByVenueId(1)).thenReturn(1);
		when(equipmentDao.deleteEquipmentByVenueId(1)).thenReturn(1);

		int venueId = 105;
		when(service.deleteVenue(venueId)).thenReturn(1);
		assertEquals(service.deleteVenue(venueId), 1);

	}
}