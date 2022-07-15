package com.manage.OEMS.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.manage.OEMS.model.Notification;
import com.manage.OEMS.service.NotificationService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class NotificationControllerTest {

	@Mock
	private NotificationService service;

	@InjectMocks
	private NotificationController controller;

	// Testing... getNotifications Handler
	@Test
	public void testGetNotifications() {
		List<Notification> notis = new ArrayList<>();
		Notification notification = new Notification(1, "8", "2021-07-08", "clear bill", 2);
		notis.add(notification);
		when(service.getNotifications(2)).thenReturn(notis);
		assertEquals(controller.getNotifications(2), notis);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... deleteNotification Handler
	@Test
	public void testDeleteNotification() {
		when(service.deleteNotification(1)).thenReturn(1);
		assertEquals(controller.deleteNotification(1), 1);
	}

}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
