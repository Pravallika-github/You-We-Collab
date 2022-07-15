package com.manage.OEMS.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.manage.OEMS.dao.BookingDao;
import com.manage.OEMS.dao.MemberDao;
import com.manage.OEMS.dao.NotificationDao;
import com.manage.OEMS.model.Booking;
import com.manage.OEMS.model.BookingDetail;
import com.manage.OEMS.model.Member;
import com.manage.OEMS.model.Notification;
import com.manage.OEMS.model.Venue;

class NotificationServiceImplTest {
	

	@BeforeEach
	public void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
	} 
	

	@Mock
	 NotificationDao notificationDao;
	
	@Mock
	 MemberDao memberDao;
	
	@Mock
	 Member member;
	
	@Mock
	 Venue venue;
	
	@Mock
	BookingDao bookingDao;
	
	@Mock
	 Notification notification;
	
	@InjectMocks
	NotificationServiceImpl notificationServiceImpl;

	// Test for deleteNotification Method
	@Test
    public void testDeleteNotification() {
      //  Notification notification=new Notification(1,"8","2021-07-08","clear bill",2);
        when(notificationServiceImpl.deleteNotification(1)).thenReturn(1);
        int event8=notificationServiceImpl.deleteNotification(1);
        assertEquals(event8,1);
    }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
	
	// Test for getNotifications Method
      @Test
      public void testGetNotifications() {
          List<Notification> notification=new ArrayList<>();
          notification.add(new Notification(1,"8","2021-07-08","clear bill",2));
          when(notificationServiceImpl.getNotifications(2)).thenReturn(notification);
          assertEquals(notificationServiceImpl.getNotifications(2).size(),1);
         
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
   // Test for notificationOnRegistration Method
      @Test
      public void testNotificationOnRegistration() {
    	  Member member = new Member(103, "user", "chaitanya", "kumar", "9834", "cheyy@57", "124");
    	  String email = "cheyy@57";
    	  //Notification notification=new Notification(1,"8","2021-07-08","clear bill",2);
    	  when(memberDao.getMember(email)).thenReturn(member);
    	  when(notificationServiceImpl.notificationOnRegistration(member)).thenReturn(1);
          assertEquals(notificationServiceImpl.notificationOnRegistration(member),1);
      }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

   // Test for notifyOnBooking Method
      @Test
      public void testNotifyOnBooking() {
    	  Date date = Date.valueOf("2021-07-01");
    	  Booking booking = new Booking(0, date, 10, "Wedding", null, null, 0, 0, 0, 0, "Pending", 14, 1, "1", "1");
    	  when(notificationServiceImpl.notifyOnBooking(booking)).thenReturn(1);
          assertEquals(notificationServiceImpl.notifyOnBooking(booking),1);
      }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
      // Test for notifyOnPayment Method
      @Test
      public void testNotifyOnPayment() {
    	  
    	  Date date = Date.valueOf("2021-07-01");
  		BookingDetail bookingDetail = new BookingDetail(1, 14, 9, date, 14, "Party", " Shooting Music", " Rice", 10000,
  				12500, 700, 23200, "Processed", "Saurabh", "Tiwari", "9999999999", "user@gmail.com", "Jagruti", "Pune",
  				"9864654654", 1);
  		 Member member = new Member(103, "user", "chaitanya", "kumar", "9834", "cheyy@57", "124");
  		
  		when(memberDao.getMemberIdByVenueId(1)).thenReturn(103);
  		when(memberDao.getMember(103)).thenReturn(member);
    	  when(bookingDao.getSingleBooking(1)).thenReturn(bookingDetail);
    	  when(notificationServiceImpl.notifyOnPayment(1)).thenReturn(1);
          assertEquals(notificationServiceImpl.notifyOnPayment(1),1);
      }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////     
      
      // Test for notifyOnVenueAdd Method
      @Test
      public void testNotifyOnVenueAdd() {
    	  
    	  Venue venue = new Venue(101, "Sai", "Shirdi", "987654", 1010);
    	  Member member = new Member(103, "user", "chaitanya", "kumar", "9834", "cheyy@57", "124");
    	  when(memberDao.getMember(1010)).thenReturn(member);
    	  
    	  when(notificationServiceImpl.notifyOnVenueAdd(venue)).thenReturn(1);
          assertEquals(notificationServiceImpl.notifyOnVenueAdd(venue),1);
      }

}