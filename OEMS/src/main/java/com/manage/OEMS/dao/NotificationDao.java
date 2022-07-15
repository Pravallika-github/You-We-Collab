package com.manage.OEMS.dao;

import java.util.List;

import com.manage.OEMS.model.Notification;

public interface NotificationDao {
	
    public int addNotification(Notification notification);
	
	public int updateNotification(Notification notification);
	
	public int deleteNotification(int notificationId);

	public List<Notification> getNotifications(int memberId);

}
