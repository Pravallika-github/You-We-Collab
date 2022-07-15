package com.manage.OEMS.model;

import org.springframework.stereotype.Component;

@Component
public class Notification {
	
	private int notificationId;
	private String time;
	private String date;
	private String message;
	private int memberId;
	
	

	public Notification(int notificationId, String time, String date, String message, int memberId) {
		super();
		this.notificationId = notificationId;
		this.time = time;
		this.date = date;
		this.message = message;
		this.memberId = memberId;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", time=" + time + ", date=" + date + ", message="
				+ message + ", memberId=" + memberId + "]";
	}

	
}
