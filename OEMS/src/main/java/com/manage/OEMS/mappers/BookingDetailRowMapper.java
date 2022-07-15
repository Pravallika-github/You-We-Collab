package com.manage.OEMS.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.manage.OEMS.model.BookingDetail;

public class BookingDetailRowMapper implements RowMapper<BookingDetail> {
	

@Override
public BookingDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		  
		  
		  BookingDetail bookingDetail = new BookingDetail();
		  
		  bookingDetail.setMemberId(rs.getInt("member_id"));
	      bookingDetail.setVenueId(rs.getInt("venue_id"));
		  
		  bookingDetail.setBookingId(rs.getInt("booking_id"));
	      bookingDetail.setDate(rs.getDate("date"));
	      bookingDetail.setGuestCount(rs.getInt("guest_count"));
	      bookingDetail.setEventName(rs.getString("event_name"));
	      bookingDetail.setEquipmentName(rs.getString("equipment_name"));
	      bookingDetail.setFoodItemName(rs.getString("food_item_name"));
	      bookingDetail.setEventCost(rs.getInt("event_cost"));
	      bookingDetail.setEquipmentCost(rs.getInt("equipment_cost"));
	      bookingDetail.setFoodItemCost(rs.getInt("food_item_cost"));
	      bookingDetail.setTotalCost(rs.getInt("total_cost"));
	      bookingDetail.setPaymentStatus(rs.getString("payment_status"));
	     
			
			bookingDetail.setFirstName(rs.getString("first_name"));
			bookingDetail.setLastName(rs.getString("last_name"));
			bookingDetail.setEmail(rs.getString("email"));
			bookingDetail.setPhoneNumber(rs.getString("phone_number"));
			
			
			bookingDetail.setVenueName(rs.getString("venue_name"));
			bookingDetail.setVenuePlace(rs.getString("venue_place"));
			bookingDetail.setVenueContact(rs.getString("venue_contact"));
			bookingDetail.setDelStatus(rs.getInt("del_status"));
			
			
	      return bookingDetail;
	      
	
};
	
}
