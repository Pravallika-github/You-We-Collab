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

import com.manage.OEMS.dao.EventDao;
import com.manage.OEMS.model.Event;

class EventServiceImplTest {

	@Mock
	EventDao eventDao;

	@InjectMocks
	EventServiceImpl eventServiceImpl;

	@BeforeEach
	public void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	// Method to Test updateEvent
	@Test
	public void testUpdateEvent() {
		Event event = new Event(1, "party", 1500, 2);
		when(eventServiceImpl.updateEvent(event)).thenReturn(1);
		int event1 = eventServiceImpl.updateEvent(event);
		assertEquals(event1, 1);
	}

	// Method to Test AddEvent
	@Test
	public void testAddEvent() {
		Event event = new Event(1, "party", 1500, 2);
		when(eventServiceImpl.addEvent(event)).thenReturn(event);
		Event event2 = eventServiceImpl.addEvent(event);
		assertEquals(event2.getEventName(), "party");
	}

	// Method to Test deleteEvent
	@Test
	public void testDeleteEvent() {
		when(eventServiceImpl.deleteEvent(1)).thenReturn(1);
		int event8 = eventServiceImpl.deleteEvent(1);
		assertEquals(event8, 1);

	}

	// Method to Test GetEventsByVenueId
	@Test
	public void testGetEventsByVenueId() {
		List<Event> event = new ArrayList<>();
		event.add(new Event(1, "party", 1500, 2));
		when(eventServiceImpl.getEventsByVenueId(2)).thenReturn(event);
		assertEquals(eventServiceImpl.getEventsByVenueId(2).size(), 1);

	}

	// Method to Test GetByNameAndVenueId
	@Test
	public void testGetByNameAndVenueId() {
		Event event = new Event(1, "party", 1500, 2);
		when(eventServiceImpl.getByNameAndVenueId("party", 2)).thenReturn(event);
		Event event5 = eventServiceImpl.getByNameAndVenueId("party", 2);
		assertEquals(event5.getEventCost(), 1500);

	}

	// Method to Test GetEvent
	@Test
	public void testGetEvent() {
		Event event = new Event(1, "party", 1500, 2);
		when(eventServiceImpl.getEvent(1)).thenReturn(event);
		Event event6 = eventServiceImpl.getEvent(1);
		assertEquals(event6.getEventName(), "party");
	}
}
