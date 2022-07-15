package com.manage.OEMS.dao;

import java.sql.Date;
import java.util.List;

import com.manage.OEMS.model.Booking;
import com.manage.OEMS.model.BookingDetail;

public interface BookingDao {
	
    public Booking addBooking(Booking booking);
	
	public Booking getBooking(int bookingId);
	
	public List<Booking> getBookings();
	
	public int deleteBooking(int bookingId);

	public List<BookingDetail> getBookingDetail();
	
	public BookingDetail getSingleBooking(int bookingId);

	public List<BookingDetail> getBookingsByUserId(int userId);

	public int doPayment(int bookingId);

	public List<BookingDetail> getBookingByVenueId(int venueId);

	public List<Date> getBookedDatesByVenueId(int venueId);

}
