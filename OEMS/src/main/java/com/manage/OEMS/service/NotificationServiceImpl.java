package com.manage.OEMS.service;

import java.time.LocalDate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.manage.OEMS.dao.BookingDao;
import com.manage.OEMS.dao.MemberDao;
import com.manage.OEMS.dao.NotificationDao;
import com.manage.OEMS.model.Booking;
import com.manage.OEMS.model.BookingDetail;
import com.manage.OEMS.model.Member;
import com.manage.OEMS.model.Notification;
import com.manage.OEMS.model.Venue;

@org.springframework.stereotype.Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	Notification notification;

	@Autowired
	MemberDao memberDao;

	@Autowired
	NotificationDao notificationDao;

	@Autowired
	BookingDao bookingDao;

	// Generate Notification On Registration//##
	@Override
	public int notificationOnRegistration(Member member) {
		Member newMember = memberDao.getMember(member.getEmail());

		this.notification.setMemberId(newMember.getMemberId());
		LocalDate localDate = LocalDate.now();
		String localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);
		this.notification.setDate(localDate.toString());
		this.notification.setTime(localTime);
		if (newMember.getRole().equals("user")) {
			String userNoti = "Welcome " + newMember.getFirstName()
					+ ", You have successfully registered on Online Event Management System. "
					+ "Now you can book your events on various venues.";
			this.notification.setMessage(userNoti);
		} else {
			String orgNoti = "Welcome " + member.getFirstName()
					+ ", You have successfully registered on Online Event Management System. "
					+ "Now you can add your venues on the portal";
			this.notification.setMessage(orgNoti);
		}

		return notificationDao.addNotification(notification);
	}

	// Generate notification On Booking//##
	@Override
	public int notifyOnBooking(Booking booking) {
		Notification notification = new Notification();

		notification.setMemberId(booking.getMemberId());
		LocalDate localDate = LocalDate.now();
		String localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);

		notification.setDate(localDate.toString());
		notification.setTime(localTime);

		String userNoti = "Dear User, Your booking data is stored temprory, Please make it fixed by completing payment";

		notification.setMessage(userNoti);
		notificationDao.addNotification(notification);
		return 1;

	}

	// Generate notification On payment//##
	@Override
	public int notifyOnPayment(int bookingId) {

		BookingDetail singleBooking = this.bookingDao.getSingleBooking(bookingId);

		int memberId = memberDao.getMemberIdByVenueId(singleBooking.getVenueId());

		Member member = memberDao.getMember(memberId);

		String userNoti = "Dear " + singleBooking.getFirstName() + ", Your payment of Rs. "
				+ singleBooking.getTotalCost() + " for booking ID " + singleBooking.getBookingId()
				+ " is processed successfully." + "Your " + singleBooking.getEventName()
				+ " event is booked on Venue Name " + singleBooking.getVenueName() + " at "
				+ singleBooking.getVenuePlace() + " on date " + singleBooking.getDate();

		String orgNoti = "Dear " + member.getFirstName() + ", Your venue " + singleBooking.getVenueName()
				+ " is booked by user " + singleBooking.getFirstName() + " " + singleBooking.getLastName()
				+ " for an event of " + singleBooking.getEventName() + " on date " + singleBooking.getDate();

		Notification notification = new Notification();
		notification.setMemberId(singleBooking.getMemberId());
		LocalDate localDate = LocalDate.now();
		String localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);

		notification.setDate(localDate.toString());
		notification.setTime(localTime);
		notification.setMessage(userNoti);

		notificationDao.addNotification(notification);

		Notification notification2 = new Notification();
		notification2.setMemberId(memberId);
		LocalDate localDate2 = LocalDate.now();
		String localTime2 = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);

		notification2.setDate(localDate2.toString());
		notification2.setTime(localTime2);
		notification2.setMessage(orgNoti);
		notificationDao.addNotification(notification2);
		return 1;

	}

	// Genetate notification on New Venue Add//##
	@Override
	public int notifyOnVenueAdd(Venue venue) {

		Member member = memberDao.getMember(venue.getMemberId());

		String orgNoti = "Dear " + member.getFirstName() + " Your venue with name " + venue.getVenueName()
				+ " at place " + venue.getVenuePlace() + " is Successfully added. ";

		Notification notification = new Notification();
		notification.setMemberId(venue.getMemberId());
		LocalDate localDate = LocalDate.now();
		String localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);
		notification.setDate(localDate.toString());
		notification.setTime(localTime);
		notification.setMessage(orgNoti);
		notificationDao.addNotification(notification);
		return 1;

	}

	// Get List of Notifications
	@Override
	public List<Notification> getNotifications(int memberId) {
		return notificationDao.getNotifications(memberId);
	}

	// Delete Notifications
	@Override
	public int deleteNotification(int notificationId) {
		return notificationDao.deleteNotification(notificationId);
	}

}
