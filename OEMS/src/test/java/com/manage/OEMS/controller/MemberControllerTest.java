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
import com.manage.OEMS.exception.ResourceNotFoundException;
import com.manage.OEMS.model.Member;
import com.manage.OEMS.service.MemberService;
import com.manage.OEMS.service.NotificationService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class MemberControllerTest {

	@Mock
	private MemberService service;

	@Mock
	private NotificationService NotiService;

	@InjectMocks
	private MemberController controller;

	// Testing... addMember Handler
	@Test
	public void testAddMember() {

		Member member = new Member(106, "organizer", "saurabh", "chavan", "864", "chavan@123", "797");

		when(service.addMember(member)).thenReturn(member);
		assertEquals(member, controller.addMember(member));
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... Authenticate Handler
	@Test
	public void testAuthenticate() throws ResourceNotFoundException {

		Member member = new Member(106, "organizer", "saurabh", "chavan", "864", "chavan@123", "797");

		when(service.Authenticate("chavan@123", "797")).thenReturn(member);
		assertEquals(member, controller.Authenticate("chavan@123", "797"));
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... getMember Handler
	@Test
	public void testGetMember() {

		Member member = new Member(106, "organizer", "saurabh", "chavan", "864", "chavan@123", "797");

		when(service.getMember(106)).thenReturn(member);
		assertEquals(member, controller.getMember(106));
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... updateMember Handler
	@Test
	public void testUpdateMember() {

		Member member = new Member(106, "organizer", "saurabh", "chavan", "864", "chavan@123", "797");

		when(service.updateMember(member)).thenReturn(1);
		assertEquals(1, controller.updateMember(member));
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... deleteMember Handler
	@Test
	public void testDeleteMember() {
		when(service.deleteMember(101)).thenReturn(1);
		assertEquals(1, controller.deleteMember(101));
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... getAllUsers Handler
	@Test
	public void testGetAllUsers() {
		List<Member> members = new ArrayList<>();
		Member member = new Member(106, "user", "saurabh", "chavan", "864", "chavan@123", "797");

		members.add(member);
		when(service.getAllUsers()).thenReturn(members);
		assertEquals(members, controller.getAllUsers());
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Testing... getAllMembers Handler
	@Test
	public void testGetAllMembers() {
		List<Member> members = new ArrayList<>();
		Member member = new Member(106, "organizer", "saurabh", "chavan", "864", "chavan@123", "797");

		members.add(member);
		when(service.getAllMembers()).thenReturn(members);
		assertEquals(members, controller.getAllMembers());
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
