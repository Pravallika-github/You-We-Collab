package com.manage.OEMS.mappers;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.manage.OEMS.model.Notification;

@Service
public class NotificationRowMapper implements RowMapper<Notification> {

	@Override
	public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Notification notification = new Notification();
			
		
		notification.setNotificationId(rs.getInt("notification_id"));
		notification.setTime(rs.getString("time"));
		notification.setDate(rs.getString("date"));
		notification.setMessage(rs.getString("message"));
		notification.setMemberId(rs.getInt("member_id"));
			
		return notification;
	}

}
