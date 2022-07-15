package com.manage.OEMS.controller;

import java.sql.Date;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.OEMS.model.Booking;
import com.manage.OEMS.model.BookingDetail;
import com.manage.OEMS.service.BookingService;
import com.manage.OEMS.service.NotificationService;

@RestController
@RequestMapping("/booking")
@CrossOrigin("*")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@Autowired
	NotificationService notificationService;
	
	
	//Handler to add booking 
	@PostMapping("/add")
	public int addBooking(@RequestBody Booking booking) {
		// Check if booking is available or not , 
		// if available then convert raw data into good format and store to database and return 1
		// otherwise return zero
		// After adding booking data , generate notification
		if (this.bookingService.isAvailable(booking)) {
			this.bookingService.rectifyBooking(booking);
			this.notificationService.notifyOnBooking(booking);
			return 1;
		} else {
			return 0;
		}
	}

	// Handler to get Booking data by booking ID
	@GetMapping("/getBooking/{bookingId}")
	public Booking getBooking(@PathVariable("bookingId") int bookingId) {
		return bookingService.getBooking(bookingId);
	}

	// Handler to get list of all bookings
	@GetMapping("/getAllBookings")
	public List<BookingDetail> getBookings() {
		return bookingService.getBookings();
	}

	// Handler to get list of bookings for USER
	@GetMapping("/bookingsByUserId/{userId}")
	public List<BookingDetail> getBookingsByUserId(@PathVariable("userId") int userId) {
		return bookingService.getBookingsByUserId(userId);
	}

	// Handler to get Booking Detail by Booking ID 
	@GetMapping("/bookingDetail/{bookingId}")
	public BookingDetail bookingDetail(@PathVariable("bookingId") int bookingId) {
		return bookingService.bookingDetail(bookingId);
	}

	// Handler to Make payment request
	@GetMapping("/doPayment/{bookingId}")
	public int payment(@PathVariable("bookingId") int bookingId) {
		
		// Check if the booking for which payment is being made is already booked by any other user
		// If that booking is available for payment then transfer request to add payment data and return 1
		// Generate notification for the Payment.
		if (this.bookingService.isAvailableForPayment(bookingId)) {
			this.bookingService.payment(bookingId);
			this.notificationService.notifyOnPayment(bookingId);
			return 1;
		} else {
			return 0;
		}
	}

	// Request handler to delete Booking
	@DeleteMapping("/deleteBooking/{bookingId}")
	public int deleteBooking(@PathVariable("bookingId") int bookingId) {
		return bookingService.deleteBooking(bookingId);
	}

	// Request handler to get List of Upcoming Bookings only
	@GetMapping("/upcomingBookings/{orgId}")
	public List<BookingDetail> getBookingsByOrgId(@PathVariable("orgId") int orgId) {
		return bookingService.getBookingDetailByOrganizerId(orgId,"Future");
	}

	// Request handler to get Previous bookings only
	@GetMapping("/previousBookings/{orgId}")
	public List<BookingDetail> getPreviousBookingsByOrgId(@PathVariable("orgId") int orgId) {
		return bookingService.getBookingDetailByOrganizerId(orgId,"Past");
	}

	// Request handler to get dates of bookings for the particular venue 
	@GetMapping("/getDates/{venueId}")
	public List<Date> getDates(@PathVariable("venueId") int venueId) {
		return bookingService.getUpcomingBookedDates(venueId);
	}
	
	// Check for Active Bookings On Venue
	@GetMapping("/checkActiveBookings/{venueId}")
	public int checkActiveBookings(@PathVariable("venueId") int venueId) {
		return bookingService.checkActiveBookings(venueId);
	}



}
