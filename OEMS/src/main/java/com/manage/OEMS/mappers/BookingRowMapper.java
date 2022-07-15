package com.manage.OEMS.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.manage.OEMS.model.Booking;

@Service
public class BookingRowMapper implements RowMapper<Booking> {

	@Override
	public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		
        Booking booking = new Booking();
		
        booking.setBookingId(rs.getInt("booking_id"));
        booking.setDate(rs.getDate("date"));
        booking.setGuestCount(rs.getInt("guest_count"));
        booking.setEventName(rs.getString("event_name"));
        booking.setEquipmentName(rs.getString("equipment_name"));
        booking.setFoodItemName(rs.getString("food_item_name"));
        booking.setEventCost(rs.getInt("event_cost"));
        booking.setEquipmentCost(rs.getInt("equipment_cost"));
        booking.setFoodItemCost(rs.getInt("food_item_cost"));
        booking.setTotalCost(rs.getInt("total_cost"));
        booking.setPaymentStatus(rs.getString("payment_status"));
        booking.setMemberId(rs.getInt("member_id"));
        booking.setVenueId(rs.getInt("venue_id"));
        booking.setDelStatus(rs.getInt("del_status"));
		
		return booking;
	}

}
