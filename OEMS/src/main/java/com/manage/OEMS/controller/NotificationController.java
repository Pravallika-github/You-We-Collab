package com.manage.OEMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.OEMS.model.Notification;
import com.manage.OEMS.service.NotificationService;

@RestController
@RequestMapping("/notification")
@CrossOrigin("*")
public class NotificationController {

	@Autowired
	NotificationService notificationService;

	// Get Notification...
	@GetMapping("/getNotification/{memberId}")
	public List<Notification> getNotifications(@PathVariable("memberId") int memberId) {
		return notificationService.getNotifications(memberId);
	}

	// Delete Notifications
	@DeleteMapping("/deleteNotification/{notificationId}")
	public int deleteNotification(@PathVariable("notificationId") int notificationId) {
		return notificationService.deleteNotification(notificationId);
	}

}
