package com.manage.OEMS.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.manage.OEMS.model.Event;
import com.manage.OEMS.service.EventService;

@RunWith(JUnitPlatform.class)
class EventControllerTest {

	@Mock
	private EventService eventService;

	@InjectMocks
	private EventController eventController;

	@BeforeEach
	public void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddEvent() throws Exception {
		Event event = new Event(1, "party", 1500, 2);
		when(eventService.addEvent(event)).thenReturn(event);
		Event event2 = eventController.addEvent(event);
		assertEquals(event2.getEventName(), "party");

	}

	// Testing.. deleteEvent Method
	@Test
	public void testDeleteEvent() throws Exception {
		when(eventService.deleteEvent(1)).thenReturn(1);
		int event8 = eventController.deleteEvent(1);
		assertEquals(event8, 1);
	}

	// Testing.. updateEvent Method
	@Test
	public void testUpdateEvent() {
		Event event = new Event(1, "party", 1500, 2);
		when(eventService.updateEvent(event)).thenReturn(1);
		int event1 = eventController.updateEvent(event);
		assertEquals(event1, 1);
	}

	// Testing.. getEventsByVenueId Method
	@Test
	public void testgetEventsByVenueId() {
		List<Event> event = new ArrayList<>();
		event.add(new Event(1, "party", 1500, 2));
		when(eventService.getEventsByVenueId(2)).thenReturn(event);
		assertEquals(eventController.getEventsByVenueId(2).size(), 1);

	}

	// Testing.. getByNameAndVenueId Method
	@Test
	public void testgetByNameAndVenueId() {
		Event event = new Event(1, "party", 1500, 2);
		when(eventService.getByNameAndVenueId("party", 2)).thenReturn(event);
		Event event5 = eventController.getByNameAndVenueId("party", 2);
		assertEquals(event5.getEventCost(), 1500);

	}

	// Testing.. getEvent Method
	@Test
	public void testgetEvent() {
		Event event = new Event(1, "party", 1500, 2);
		when(eventService.getEvent(1)).thenReturn(event);
		Event event6 = eventController.getEvent(1);
		assertEquals(event6.getEventName(), "party");
	}

}