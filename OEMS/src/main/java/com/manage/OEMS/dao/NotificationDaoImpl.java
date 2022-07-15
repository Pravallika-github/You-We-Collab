package com.manage.OEMS.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manage.OEMS.mappers.NotificationRowMapper;
import com.manage.OEMS.model.Notification;

@Repository
public class NotificationDaoImpl implements NotificationDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NotificationRowMapper rowMapper;

	// Add Notification
	@Override
	public int addNotification(Notification notification) {
		Object[] args = { notification.getTime(), notification.getDate(), notification.getMessage(),
				notification.getMemberId() };
		String query = "INSERT INTO notification (time,date,message,member_id)" + "   VALUES (?,?,?,?)";
		this.jdbcTemplate.update(query, args);
		return 1;
	}

	// Update...
	@Override
	public int updateNotification(Notification notification) {
		String query = "update notification set time=?, message=? where notification_id=?";
		Object[] args = { notification.getTime(), notification.getMessage(), notification.getNotificationId() };
		return this.jdbcTemplate.update(query, args);
	}

	// Get List of Notifications
	@Override
	public List<Notification> getNotifications(int memberId) {
		String query = "select * from notification where member_id=? order by date desc, time desc";
		return this.jdbcTemplate.query(query, rowMapper, memberId);
	}

	// Delete...
	@Override
	public int deleteNotification(int notificationId) {
		String query = "delete from notification where notification_id=?";
		return this.jdbcTemplate.update(query, notificationId);

	}

}
