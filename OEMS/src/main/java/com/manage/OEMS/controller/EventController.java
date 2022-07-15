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

import com.manage.OEMS.model.Event;
import com.manage.OEMS.service.EventService;

@RestController
@RequestMapping("/event")
@CrossOrigin("*")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	// Get List of events by venueId
	@GetMapping("/getEvents/{venueId}")
    public List<Event> getEventsByVenueId(@PathVariable("venueId") int eventId) {
    	 return eventService.getEventsByVenueId(eventId);
    }
	
	// Add event
	@PostMapping("/add")
	public Event addEvent(@RequestBody Event event) {
		return this.eventService.addEvent(event);
	}
	
	// Get event by Name and VenueId 
	@GetMapping("/getOne/{eventName}/{venueId}")
	public Event getByNameAndVenueId(@PathVariable("eventName") String EName,@PathVariable("venueId") int VId) {
		return this.eventService.getByNameAndVenueId(EName,VId);
	}
	
	// Get event by Event Id
	@GetMapping("/getEvent/{eventId}")
    public Event getEvent(@PathVariable("eventId") int eventId) {
    	 return eventService.getEvent(eventId);
    }
    
    //Update event
    @PutMapping("/updateEvent")
    public int updateEvent(@RequestBody Event event) {
   	 return eventService.updateEvent(event);
   }
    
    //Delete event
    @DeleteMapping("/deleteEvent/{eventId}")
    public int deleteEvent(@PathVariable("eventId") int eventId) {
    	return eventService.deleteEvent(eventId);
      }


}
