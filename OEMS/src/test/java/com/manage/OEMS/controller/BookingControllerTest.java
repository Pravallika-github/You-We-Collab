package com.manage.OEMS.controller;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manage.OEMS.dao.TablesDao;
import com.manage.OEMS.model.Booking;
import com.manage.OEMS.model.BookingDetail;
import com.manage.OEMS.service.BookingService;
import com.manage.OEMS.service.NotificationService;

@WebMvcTest(BookingController.class)
@AutoConfigureMockMvc
class BookingControllerTest {

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	private BookingService bookingService;

	@MockBean
	Booking booking;

	@MockBean
	TablesDao tableDao;

	@MockBean
	private NotificationService notificationService;

	@Autowired
	private MockMvc mvc;

	// Testing .. getBookings Method
	@Test
	public void testGetBookings() throws Exception {
		List<BookingDetail> bookingDetails = new ArrayList<>();

		Date date = Date.valueOf("2021-07-01");
		BookingDetail bookingDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
				12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
				"9864654654", 1);
		bookingDetails.add(bookingDetail);

		when(bookingService.getBookings()).thenReturn(bookingDetails);

		String url = "/booking/getAllBookings";
		mvc.perform(get(url)).andExpect(status().isOk());

	}
////////////////////////////////////////////////////////////////////////////////////////////////////////

	//// Testing .. addBooking Method
	@Test
	public void testAddBooking() throws Exception {
		Date date = Date.valueOf("2021-07-01");
		Booking booking = new Booking(0, date, 10, "Wedding", null, null, 0, 0, 0, 0, "Pending", 14, 1, "1", "1");

		when(bookingService.isAvailable(booking)).thenReturn(true);

		String url = "/booking/add";
		mvc.perform(post(url).contentType("application/json").content(objectMapper.writeValueAsString(booking)))
				.andExpect(status().isOk());
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////

	//// Testing .. getBooking Method
	@Test
	public void testGetBooking() throws Exception {
		Date date = Date.valueOf("2021-07-01");
		Booking outPutBooking = new Booking(1, date, 10, "Wedding", " Rice", " Lightning", 18000, 2400, 400, 20800,
				"Pending", 14, 1, null, null);
		when(bookingService.getBooking(1)).thenReturn(outPutBooking);

		String url = "/booking/getBooking/1";
		mvc.perform(get(url)).andExpect(status().isOk());
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

////Testing .. getBookingsByUserId Method
	@Test
	public void testGetBookingsByUserId() throws Exception {
		List<BookingDetail> bookings = new ArrayList<>();
		Date date = Date.valueOf("2021-07-01");
		BookingDetail bookingDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
				12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
				"9864654654", 1);
		bookings.add(bookingDetail);
		when(bookingService.getBookingsByUserId(14)).thenReturn(bookings);

		String url = "/booking/bookingsByUserId/14";
		mvc.perform(get(url)).andExpect(status().isOk());
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//// Testing .. bookingDetail Method
	@Test
	public void testBookingDetail() throws Exception {
		Date date = Date.valueOf("2021-07-01");
		BookingDetail bookingDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
				12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
				"9864654654", 1);
		when(bookingService.bookingDetail(1)).thenReturn(bookingDetail);

		String url = "/booking/bookingDetail/1";
		mvc.perform(get(url)).andExpect(status().isOk());
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//// Testing .. payment Method
	@Test
	public void testPayment() throws Exception {
		when(bookingService.isAvailableForPayment(1)).thenReturn(true);

		String url = "/booking/doPayment/1";
		mvc.perform(get(url)).andExpect(status().isOk());
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

	//// Testing .. deleteBooking Method
	@Test
	public void testDeleteBooking() throws Exception {
		when(bookingService.deleteBooking(1)).thenReturn(1);
		String url = "/booking/deleteBooking/1";
		mvc.perform(delete(url)).andExpect(status().isOk());
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//// Testing .. getBookingsByOrgId Method
	@Test
	public void testGetBookingsByOrgId() throws Exception {

		List<BookingDetail> bookings = new ArrayList<>();
		Date date = Date.valueOf("2021-07-01");
		BookingDetail bookingDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
				12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
				"9864654654", 1);
		bookings.add(bookingDetail);
		when(bookingService.getBookingDetailByOrganizerId(15, "Future")).thenReturn(bookings);
		String url = "/booking/upcomingBookings/15";
		mvc.perform(get(url)).andExpect(status().isOk());
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//// Testing .. getPreviousBookingsByOrgId Method
	@Test
	public void testGetPreviousBookingsByOrgId() throws Exception {

		List<BookingDetail> bookings = new ArrayList<>();
		Date date = Date.valueOf("2021-06-25");
		BookingDetail bookingDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
				12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
				"9864654654", 1);
		bookings.add(bookingDetail);
		when(bookingService.getBookingDetailByOrganizerId(15, "Past")).thenReturn(bookings);
		String url = "/booking/previousBookings/15";
		mvc.perform(get(url)).andExpect(status().isOk());
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//// Testing .. getUpcomingBookedDates Method
	@Test
	public void testGetUpcomingBookedDates() throws Exception {

		List<Date> dates = new ArrayList<>();
		Date date1 = Date.valueOf("2021-07-25");
		Date date2 = Date.valueOf("2021-07-26");
		dates.add(date1);
		dates.add(date2);

		when(bookingService.getUpcomingBookedDates(1)).thenReturn(dates);
		String url = "/booking/getDates/1";
		mvc.perform(get(url)).andExpect(status().isOk());
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	//// Testing .. checkActiveBookings Method
	@Test
	public void testCheckActiveBookings() throws Exception {

		when(bookingService.checkActiveBookings(1)).thenReturn(1);
		String url = "/booking/checkActiveBookings/1";
		mvc.perform(get(url)).andExpect(status().isOk());
	}
}
