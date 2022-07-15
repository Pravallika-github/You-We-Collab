package com.manage.OEMS.model;


public class Member {

	
	private int memberId;
	
	private String role;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String password;


	
	
	
	public Member(int memberId, String role, String firstName, String lastName, String phoneNumber, String email,
			String password) {
		super();
		this.memberId = memberId;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}

	//getter and setters




	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

//toString Method
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", role=" + role + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", password="
				+ password + "]";
	}


}
