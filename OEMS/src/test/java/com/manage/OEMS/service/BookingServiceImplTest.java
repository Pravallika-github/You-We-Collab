package com.manage.OEMS.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.manage.OEMS.dao.BookingDao;
import com.manage.OEMS.dao.EquipmentDao;
import com.manage.OEMS.dao.EventDao;
import com.manage.OEMS.dao.FoodItemDao;
import com.manage.OEMS.dao.VenueDao;
import com.manage.OEMS.model.Booking;
import com.manage.OEMS.model.BookingDetail;
import com.manage.OEMS.model.Equipment;
import com.manage.OEMS.model.Event;
import com.manage.OEMS.model.FoodItem;
import com.manage.OEMS.model.Venue;

class BookingServiceImplTest {

	@Mock
	BookingDao bookingDao;

	@Mock
	BookingDetail bookingDetail;

	@Mock
	Venue venue;

	@Mock
	Booking booking;

	@Mock
	FoodItemDao foodItemDao;

	@Mock
	EquipmentDao equipmentDao;

	@Mock
	EventDao eventDao;

	@Mock
	VenueDao venueDao;

	@Mock
	BookingServiceImpl bookingServiceImpl1;
	
	@InjectMocks
	BookingServiceImpl bookingServiceImpl;

	@BeforeEach
	public void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Test Method for rectifyBooking()
	@Test
	public void testRectifyBooking() {
		Date date = Date.valueOf("2021-07-01");
		Booking inputBooking = new Booking(0, date, 10, "Wedding", null, null, 0, 0, 0, 0, "Pending", 14, 1, "1", "1");
		Booking outPutBooking = new Booking(0, date, 10, "Wedding", " Rice", " Lightning", 18000, 2400, 400, 20800,
				"Pending", 14, 1, null, null);
		when(foodItemDao.getFoodItem(1)).thenReturn(new FoodItem(1, "Rice", 40, 1));
		when(equipmentDao.getEquipment(1)).thenReturn(new Equipment(1, "Lightning", 2400, 1));
		when(bookingServiceImpl.rectifyBooking(inputBooking)).thenReturn(outPutBooking);
		assertEquals(outPutBooking, bookingServiceImpl.rectifyBooking(inputBooking));
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Test Method for getBookingDetailByOrganizerId()
	@Test
	public void testGetBookingDetailByOrganizerId() {
		Date date = Date.valueOf("2021-07-01");
		List<BookingDetail> bList = new ArrayList<BookingDetail>();
		BookingDetail bookingDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
				12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
				"9864654654", 1);
		bList.add(bookingDetail);

		List<Venue> venueList = new ArrayList<Venue>();
		Venue venue1 = new Venue(1, "Sai", "Shirdi", "9464654545", 3);
		venueList.add(venue1);
		when(venueDao.getVenueByOrganizerId(15)).thenReturn(venueList);
		when(bookingServiceImpl.getBookingDetailByOrganizerId(15, "Future")).thenReturn(bList);
		assertEquals(bList, bookingServiceImpl.getBookingDetailByOrganizerId(15, "Future"));

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Test Method for sqlToLocalDateConverter()
	@Test
	public void testSqlToLocalDateConverter() {
		LocalDate lDate = LocalDate.of(2021, 07, 01);
		Date date = Date.valueOf("2021-07-01");
		assertEquals(lDate, bookingServiceImpl.sqlToLocalDateConverter(date));
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Test Method for getUpcomingBookedDates()
	@Test
	public void testGetUpcomingBookedDates() {
		List<Date> dates = new ArrayList<>();
		Date date1 = Date.valueOf("2021-07-01");
		Date date2 = Date.valueOf("2021-07-02");
		dates.add(date1);
		dates.add(date2);
		when(bookingServiceImpl.getUpcomingBookedDates(1)).thenReturn(dates);
		assertEquals(dates, bookingServiceImpl.getUpcomingBookedDates(1));
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Test Method for getBooking();
	@Test
	public void testGetBooking() {
		Date date = Date.valueOf("2021-07-01");
		Booking Booking = new Booking(1, date, 10, "Wedding", " Rice", " Lightning", 18000, 2400, 400, 20800, "Pending",
				14, 1, null, null);

		when(bookingServiceImpl.getBooking(1)).thenReturn(Booking);
		assertEquals(Booking, bookingServiceImpl.getBooking(1));
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Test Method for getBookings()
	@Test
	public void testGetBookings() {
		List<BookingDetail> bookingDetails = new ArrayList<BookingDetail>();
		Date date = Date.valueOf("2021-07-01");
		BookingDetail bookDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
				12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
				"9864654654", 1);
		bookingDetails.add(bookDetail);
		when(bookingServiceImpl.getBookings()).thenReturn(bookingDetails);
		assertEquals(bookingDetails, bookingServiceImpl.getBookings());
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Test Method for getBookingsByUserId()
	@Test
	public void testGetBookingsByUserId() {
		List<BookingDetail> bookingDetails = new ArrayList<BookingDetail>();
		Date date = Date.valueOf("2021-07-01");
		BookingDetail bookDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
				12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
				"9864654654", 1);
		bookingDetails.add(bookDetail);
		when(bookingServiceImpl.getBookingsByUserId(14)).thenReturn(bookingDetails);
		assertEquals(bookingDetails, bookingServiceImpl.getBookingsByUserId(14));
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Test Method for BookingDetail()
	@Test
	public void testBookingDetail() {

		Date date = Date.valueOf("2021-07-01");
		BookingDetail bookDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
				12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
				"9864654654", 1);

		when(bookingServiceImpl.bookingDetail(1)).thenReturn(bookDetail);
		assertEquals(bookDetail, bookingServiceImpl.bookingDetail(1));
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Test Method for DeleteBooking()
	@Test
	public void testDeleteBooking() {
		when(bookingServiceImpl.deleteBooking(1)).thenReturn(1);
		assertEquals(1, bookingServiceImpl.deleteBooking(1));
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Test Method for isAvailable()
		@Test
		public void testIsAvailable() {
			List<Date> dates = new ArrayList<>();
			Date date = Date.valueOf("2021-07-01");
			Booking booking = new Booking(1, date, 10, "Wedding", " Rice", " Lightning", 18000, 2400, 400, 20800, "Pending",
					14, 1, null, null);
			dates.add(date);
			//int venueId = 1;
			//when(bookingDao.getBookedDatesByVenueId(venueId)).thenReturn(dates);
			//when(bookingServiceImpl1.getUpcomingBookedDates(venueId)).thenReturn(dates);
			when(bookingServiceImpl1.isAvailable(booking)).thenReturn(true);
			assertEquals(true, bookingServiceImpl.isAvailable(booking));
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

		// Test Method for isAvailableForPayment()
				@Test
				public void testIsAvailableForPayment() {
					List<Date> dates = new ArrayList<>();
					Date date = Date.valueOf("2021-07-01");
					BookingDetail bookDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
							12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
							"9864654654", 1);
					dates.add(date);
					//int venueId = 1;
					when(bookingDao.getSingleBooking(1)).thenReturn(bookDetail);
					//when(bookingServiceImpl1.getUpcomingBookedDates(venueId)).thenReturn(dates);
					when(bookingServiceImpl1.isAvailableForPayment(1)).thenReturn(true);
					assertEquals(true, bookingServiceImpl.isAvailableForPayment(1));
				}
				
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				// Test Method for payment()
				@Test
				public void testPayment() {
					List<Date> dates = new ArrayList<>();
					Date date = Date.valueOf("2021-07-01");
					BookingDetail bookDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
							12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
							"9864654654", 1);
					dates.add(date);
					//int venueId = 1;
					when(bookingServiceImpl1.isAvailableForPayment(1)).thenReturn(true);
					when(bookingDao.getSingleBooking(1)).thenReturn(bookDetail);
					when(bookingServiceImpl.payment(1)).thenReturn(1);
					assertEquals(1,bookingServiceImpl.payment(1));
				}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				
				// Test Method for checkActiveBookings()
				@Test
				public void testCheckActiveBookings() {
					List<BookingDetail> bd = new ArrayList<>();
					Date date = Date.valueOf("2021-07-01");
					BookingDetail bookDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
							12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
							"9864654654", 1);
					bd.add(bookDetail);
					int venueId = 1;
					when(bookingDao.getBookingByVenueId(venueId)).thenReturn(bd);
	
					when(bookingServiceImpl1.checkActiveBookings(1)).thenReturn(1);
					assertEquals(1,bookingServiceImpl.checkActiveBookings(1));
				}
				
}