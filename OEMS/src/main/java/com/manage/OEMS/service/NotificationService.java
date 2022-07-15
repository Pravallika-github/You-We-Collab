package com.manage.OEMS.service;

import java.util.List;

import com.manage.OEMS.model.Booking;
import com.manage.OEMS.model.Member;
import com.manage.OEMS.model.Notification;
import com.manage.OEMS.model.Venue;

public interface NotificationService {
	
	public int notificationOnRegistration(Member member); 

	public int notifyOnPayment(int bookingId);

	public int notifyOnBooking(Booking booking);
	
	public int notifyOnVenueAdd(Venue venue);

	public int deleteNotification(int notificationId);

	public List<Notification> getNotifications(int memberId);
	
}
