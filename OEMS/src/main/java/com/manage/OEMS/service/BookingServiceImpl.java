package com.manage.OEMS.service;

import java.sql.Date;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

@org.springframework.stereotype.Service
public class BookingServiceImpl implements BookingService {
	Booking newBooking = new Booking();

	@Autowired
	FoodItemDao foodItemDao;

	@Autowired
	EquipmentDao equipmentDao;

	@Autowired
	EventDao eventDao;

	@Autowired
	BookingDao bookingDao;

	@Autowired
	VenueDao venueDao;

	int foodItemCost;
	int equipmentCost;
	int eventCost;
	int totalCost;
	String foodNames;
	String equipmentNames;

	// Convert all raw data of booking from front end to good database form and save
	// to database//####
	@Override
	public Booking rectifyBooking(Booking localBooking) {
		this.foodItemCost = 0;
		this.equipmentCost = 0;
		this.eventCost = 0;
		this.totalCost = 0;
		this.foodNames = " ";
		this.equipmentNames = " ";

		// Get array of selected food Item Id in string format
		String[] selFood = localBooking.getSelectedFoodItems().trim().split(",");

		// Get food Items Cost and Names
		for (String f : selFood) {
			if (!(f.equals(""))) {

				int fId = Integer.parseInt(f);
				FoodItem food = this.foodItemDao.getFoodItem(fId);
				int ownCost = food.getFoodItemCost();
				this.foodItemCost = this.foodItemCost + ownCost;
				this.foodNames = this.foodNames + " " + food.getFoodItemName();
				;
			}

		}

		// Get array of selected Equipments id in string format
		String[] selEquip = localBooking.getSelectedEquipments().split(",");

		// Get Equipment Cost and Names
		for (String e : selEquip) {
			if (!(e.equals(""))) {

				int eId = Integer.parseInt(e);
				Equipment equip = this.equipmentDao.getEquipment(eId);
				int ownCost = equip.getEquipmentCost();
				this.equipmentCost = this.equipmentCost + ownCost;
				this.equipmentNames = this.equipmentNames + " " + equip.getEquipmentName();
			}
		}

		// Get Event Cost
		
		String eventName = localBooking.getEventName();
		int VenueId = localBooking.getVenueId();
		List<Event> events = this.eventDao.getEventsByVenueId(VenueId);
		for (Event e : events) {
			
			if (eventName.equals(e.getEventName())) {
				this.eventCost = e.getEventCost();
			}
		}

		// Final Food Item and Total Cost
		this.foodItemCost = this.foodItemCost * localBooking.getGuestCount();
		this.totalCost = this.foodItemCost + this.equipmentCost + this.eventCost;

		newBooking.setBookingId(localBooking.getBookingId());
		newBooking.setDate(localBooking.getDate());
		newBooking.setGuestCount(localBooking.getGuestCount());
		newBooking.setEventName(localBooking.getEventName());
		newBooking.setEquipmentName(this.equipmentNames);
		newBooking.setFoodItemName(this.foodNames);
		newBooking.setEventCost(this.eventCost);
		newBooking.setEquipmentCost(this.equipmentCost);
		newBooking.setFoodItemCost(this.foodItemCost);
		newBooking.setTotalCost(this.totalCost);
		newBooking.setPaymentStatus(localBooking.getPaymentStatus());
		newBooking.setMemberId(localBooking.getMemberId());
		newBooking.setVenueId(localBooking.getVenueId());
		newBooking.setDelStatus(1);

		return this.bookingDao.addBooking(newBooking);

	}

///////////////////////////// Date related processing.//////////////////////////////////////////////////////
	List<BookingDetail> upcomingBookings;
	List<BookingDetail> historyBookings;

	// this Method will return all upcoming and paid bookings//####
	@Override
	public List<BookingDetail> getBookingDetailByOrganizerId(int orgId,String tense) {

		List<Venue> venueList = this.venueDao.getVenueByOrganizerId(orgId);
		
		this.upcomingBookings = new ArrayList<>();
		this.historyBookings = new ArrayList<>();
		
		for (Venue v :venueList) {
			
			int venueId = v.getVenueId();
			List<BookingDetail> localList = this.bookingDao.getBookingByVenueId(venueId);
			for (BookingDetail bd : localList) {
				// int delStatus = bd.getDelStatus();
				LocalDate todayDate = LocalDate.now();
				LocalDate bookingDate = sqlToLocalDateConverter(bd.getDate());
				String paymentStatus = bd.getPaymentStatus();
				if ((todayDate.isBefore(bookingDate) || todayDate.isEqual(bookingDate))
						&& paymentStatus.equals("Processed")) {
					
					this.upcomingBookings.add(bd);
				} else if (todayDate.isAfter(bookingDate) && paymentStatus.equals("Processed")) {
					/* && (delStatus==1 || delStatus==11 || delStatus==110 || delStatus==111 ) */
					this.historyBookings.add(bd);
					
				}
			}
		}
		if(tense.equals("Past")) {
			return this.historyBookings;
		}else {
			return this.upcomingBookings;
		}
		
		
	}


	// method to convert sqlDate to localDate//####
	public LocalDate sqlToLocalDateConverter(Date sqlDate) {
		return Date.valueOf(sqlDate.toString()).toLocalDate();
	}

	List<Date> allDates;
	List<Date> requiredDates;

	// Get all the upcoming dates only for particular venue//####
	@Override
	public List<Date> getUpcomingBookedDates(int venueId) {
		requiredDates = new ArrayList<>();
		LocalDate today = LocalDate.now();
		this.allDates = this.bookingDao.getBookedDatesByVenueId(venueId);
		for (Date d : allDates) {
			LocalDate bookedDate = sqlToLocalDateConverter(d);
			if ((today.isBefore(bookedDate) || today.isEqual(bookedDate))) {
				this.requiredDates.add(d);
			}
		}
		return this.requiredDates;
	}

	
	Boolean flag;
	// Check if date is already booked and Payment is Done.//####
	// return false if date is already booked or return true
	@Override
	public Boolean isAvailable(Booking tempBooking) {
		flag = true;
		String stringTempDate = tempBooking.getDate().toString();
		int venueId = tempBooking.getVenueId();
		List<Date> alreadyBookedDates = this.getUpcomingBookedDates(venueId);

		for (Date bookedate : alreadyBookedDates) {

			String stringbookedate = bookedate.toString();
			if (stringbookedate.equals(stringTempDate)) {
				this.flag = false;
			}
		}

		return this.flag;
	}

	// Check if booking is Available for payment with booking Id//####
	@Override
	public Boolean isAvailableForPayment(int tempBookingId) {
		flag = true;
		// get details of booking by booking id
		BookingDetail bookingDetail = bookingDao.getSingleBooking(tempBookingId);
		// get the date of booking
		Date bDate = bookingDetail.getDate();
		// get venue id from booking
		int venueId = bookingDetail.getVenueId();
		// call service get upcoming booking dates
		List<Date> alreadyBookedDates = this.getUpcomingBookedDates(venueId);
		// convert date to string
		String stringBDate = bDate.toString();
		// if the date matches with the already booked and paid dates then return false
		// otherwise return true
		for (Date bookedDate : alreadyBookedDates) {

			String stringBookedDate = bookedDate.toString();
			if (stringBookedDate.equals(stringBDate)) {
				this.flag = false;
			}
		}
		return this.flag;
	}

	// Service to get Booking data by booking ID//####
	@Override
	public Booking getBooking(int bookingId) {
		return bookingDao.getBooking(bookingId);
	}

	// Service to get list of all bookings//####
	@Override
	public List<BookingDetail> getBookings() {
		return bookingDao.getBookingDetail();
	}

	// Service to get list of bookings for USER//####
	@Override
	public List<BookingDetail> getBookingsByUserId(int userId) {
		return bookingDao.getBookingsByUserId(userId);
	}

	// Service to get Booking Detail by Booking ID//####
	@Override
	public BookingDetail bookingDetail(int bookingId) {
		return bookingDao.getSingleBooking(bookingId);
	}

	// Service to Make payment request//####
	@Override
	public int payment(int bookingId) {

		// Check if the booking for which payment is being made is already booked by any
		// other user
		// If that booking is available for payment then transfer request to add payment
		// data and return 1
		// Generate notification for the Payment.
		if (isAvailableForPayment(bookingId)) {
			this.bookingDao.doPayment(bookingId);
			return 1;
		} else {
			return 0;
		}
	}

	// Service to delete Booking//####
    @Override
	public int deleteBooking(@PathVariable("bookingId") int bookingId) {
		return bookingDao.deleteBooking(bookingId);
	}

	// Check Active Bookings Are present or not.//****
	@Override
	public int checkActiveBookings(int venueId) {
		int i=0;
		
		List<BookingDetail> localList = this.bookingDao.getBookingByVenueId(venueId);
		for (BookingDetail bd : localList) {
			LocalDate todayDate = LocalDate.now();
			LocalDate bookingDate = sqlToLocalDateConverter(bd.getDate());
			String paymentStatus = bd.getPaymentStatus();
			if ((todayDate.isBefore(bookingDate) || todayDate.isEqual(bookingDate))
					&& paymentStatus.equals("Processed")) {
				i = 1;
			} 
		}
		return i;
	}

}

