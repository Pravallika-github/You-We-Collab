package com.manage.OEMS.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.manage.OEMS.mappers.BookingDetailRowMapper;
import com.manage.OEMS.mappers.BookingRowMapper;
import com.manage.OEMS.model.Booking;
import com.manage.OEMS.model.BookingDetail;

@Repository
public class BookingDaoImpl implements BookingDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	BookingRowMapper rowMapper;

	// Add booking
	@Override
	public Booking addBooking(Booking booking) {
		Object[] args = { booking.getBookingId(), booking.getDate(), booking.getGuestCount(), booking.getEventName(),
				booking.getEquipmentName(), booking.getFoodItemName(), booking.getEventCost(),
				booking.getEquipmentCost(), booking.getFoodItemCost(), booking.getTotalCost(),
				booking.getPaymentStatus(), booking.getMemberId(), booking.getVenueId(), booking.getDelStatus() };

		String query = "INSERT INTO booking (booking_id, date, guest_count, event_name, equipment_name, food_item_name,"
				+ " event_cost, equipment_cost, food_item_cost, total_cost, payment_status, member_id, venue_id, del_status)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		this.jdbcTemplate.update(query, args);
		return booking;
	}

	// Get booking
	@Override
	public Booking getBooking(int bookingId) {
		String query = "select * from booking WHERE booking_id=?";
		System.out.println(bookingId);
		return this.jdbcTemplate.queryForObject(query, new BookingRowMapper(), bookingId);
	}

	// Get Booking Detail
	@Override
	public BookingDetail getSingleBooking(int bookingId) {
		String query = "select booking.member_id,booking.venue_id,booking.booking_id,booking.date,booking.guest_count,booking.event_name,booking.equipment_name,"
				+ "booking.food_item_name,booking.event_cost,booking.equipment_cost,booking.food_item_cost,booking.total_cost,booking.payment_status,"
				+ "member.first_name,member.last_name,member.email,member.phone_number,"
				+ "venue.venue_name,venue.venue_place,venue.venue_contact,booking.del_status"
				+ " FROM booking INNER JOIN member ON member.member_id=booking.member_id"
				+ " INNER JOIN venue ON venue.venue_id=booking.venue_id" + " WHERE booking.booking_id=?";

		return this.jdbcTemplate.queryForObject(query, new BookingDetailRowMapper(), bookingId);
	}

	// Get List of Booking
	@Override
	public List<Booking> getBookings() {
		String query = "select * from booking";
		return this.jdbcTemplate.query(query, rowMapper);
	}

	// Get List of Booking DetailS
	@Override
	public List<BookingDetail> getBookingDetail() {
		String query = "select booking.member_id,booking.venue_id,booking.booking_id,booking.date,booking.guest_count,booking.event_name,booking.equipment_name,"
				+ "booking.food_item_name,booking.event_cost,booking.equipment_cost,booking.food_item_cost,booking.total_cost,booking.payment_status,"
				+ "member.first_name,member.last_name,member.email,member.phone_number,"
				+ "venue.venue_name,venue.venue_place,venue.venue_contact,booking.del_status"
				+ " FROM booking INNER JOIN member ON member.member_id=booking.member_id"
				+ " INNER JOIN venue ON venue.venue_id=booking.venue_id";

		return this.jdbcTemplate.query(query, new BookingDetailRowMapper());

	}

	// Delete Booking
	@Override
	public int deleteBooking(int bookingId) {
		String query = "delete from booking where booking_id=?";
		return this.jdbcTemplate.update(query, bookingId);

	}

	// Get List of Booking Detail by User Id
	@Override
	public List<BookingDetail> getBookingsByUserId(int userId) {
		String query = "select booking.member_id,booking.venue_id,booking.booking_id,booking.date,booking.guest_count,booking.event_name,booking.equipment_name,"
				+ "booking.food_item_name,booking.event_cost,booking.equipment_cost,booking.food_item_cost,booking.total_cost,booking.payment_status,"
				+ "member.first_name,member.last_name,member.email,member.phone_number,"
				+ "venue.venue_name,venue.venue_place,venue.venue_contact,booking.del_status"
				+ " FROM booking INNER JOIN member ON member.member_id=booking.member_id"
				+ " INNER JOIN venue ON venue.venue_id=booking.venue_id"
				+ " WHERE booking.member_id=? ORDER BY booking.date DESC ";

		return this.jdbcTemplate.query(query, new BookingDetailRowMapper(), userId);
	}

	// Update payment status
	@Override
	public int doPayment(int bookingId) {
		String query = "update booking set payment_status=?, del_status=? where booking_id= ?";
		Object[] args = { "Processed", 111, bookingId };
		return this.jdbcTemplate.update(query, args);
	}

	// Get List of Booking Detail by Venue Id
	@Override
	public List<BookingDetail> getBookingByVenueId(int venueId) {
		String query = "select booking.member_id,booking.venue_id,booking.booking_id,booking.date,booking.guest_count,booking.event_name,booking.equipment_name,"
				+ "booking.food_item_name,booking.event_cost,booking.equipment_cost,booking.food_item_cost,booking.total_cost,booking.payment_status,"
				+ "member.first_name,member.last_name,member.email,member.phone_number,"
				+ "venue.venue_name,venue.venue_place,venue.venue_contact,booking.del_status"
				+ " FROM booking INNER JOIN member ON member.member_id=booking.member_id"
				+ " INNER JOIN venue ON venue.venue_id=booking.venue_id" + " WHERE booking.venue_id=?";

		return this.jdbcTemplate.query(query, new BookingDetailRowMapper(), venueId);
	}

	// List of Dates for Paid Bookings by Venue Id
	@Override
	public List<Date> getBookedDatesByVenueId(int venueId) {
		String query = "select date from booking where venue_id = ? and payment_status=? order by date asc";
		return this.jdbcTemplate.query(query, new RowMapper<Date>() {
			public Date mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getDate("date");
			}
		}, venueId, "Processed");
	}

	
}


