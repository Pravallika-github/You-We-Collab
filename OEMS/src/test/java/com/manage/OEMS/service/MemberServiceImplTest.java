package com.manage.OEMS.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.manage.OEMS.dao.MemberDao;
import com.manage.OEMS.exception.ResourceNotFoundException;
import com.manage.OEMS.model.Member;

class MemberServiceImplTest {

	@Mock
	MemberDao memberDao;

	@InjectMocks
	MemberServiceImpl service;

	@BeforeEach
	public void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);

	}

	@Test
	public void testAddMember() {
		Member member = new Member(101, "user", "anil", "kumar", "9864", "anil@457", "1234");
		when(service.addMember(member)).thenReturn(member);
		Member p = service.addMember(member);
		assertEquals(p.getRole(), "user");
	}

	@Test
	public void testgetMember() {
		int memberId = 102;
		Member member1 = new Member(102, "user", "ani", "kumar", "864", "kum@457", "234");
		when(service.getMember(memberId)).thenReturn(member1);
		// Member p = service.addMember(member);
		assertEquals(service.getMember(memberId), member1);
	}

	@Test
	public void testUpdateMember() {
		Member member = new Member(103, "user", "chaitanya", "kumar", "9834", "cheyy@57", "124");
		when(service.updateMember(member)).thenReturn(1);
		// Member p = service.addMember(member);
		assertEquals(service.updateMember(member), 1);

	}

	@Test
	public void testgetAllUsers() {

		List<Member> member2 = new ArrayList<>();
		member2.add(new Member(104, "user", "anil", "kumble", "864", "kum@457", "234"));
		member2.add(new Member(105, "user", "raj", "kumar", "364", "kum@498", "294"));
		when(service.getAllUsers()).thenReturn(member2);
		assertEquals(service.getAllUsers().size(), 2);
	}

	@Test
	public void testgetAllMembers() {

		List<Member> member3 = new ArrayList<>();
		member3.add(new Member(106, "organizer", "saurabh", "chavan", "864", "chavan@123", "797"));
		member3.add(new Member(107, "user", "ram", "lal", "369", "ram@898", "878"));
		when(service.getAllMembers()).thenReturn(member3);
		assertEquals(service.getAllMembers().size(), 2);
	}

	@Test
	public void testAuthenticate() throws ResourceNotFoundException {

		String username = "krishna";
		String password = "2244";

		Member member5 = new Member(109, "user", "krishna", "kumar", "234", "kum@457", "2244");
		when(service.Authenticate(username, password)).thenReturn(member5);

		assertEquals(service.Authenticate(username, password), member5);
	}

	@Test
	public void testdeleteMember() {
		int memberId = 108;
		when(service.deleteMember(memberId)).thenReturn(1);
		assertEquals(service.deleteMember(memberId), 1);

	}

}