package com.manage.OEMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.manage.OEMS.dao.MemberDao;
import com.manage.OEMS.exception.ResourceNotFoundException;
import com.manage.OEMS.model.Member;

@org.springframework.stereotype.Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;

	// Add Member...
	@Override
	public Member addMember(Member member) {
		this.memberDao.addMember(member);
		return member;
	}

	// Find by Username and Password
	@Override
	public Member Authenticate(String username, String password) throws ResourceNotFoundException {

		try {
			return memberDao.findMemberByUsernameAndPassword(username, password);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Resource with given value is not found");
		}

	}

	// Get Member..
	@Override
	public Member getMember(int memberId) {
		return memberDao.getMember(memberId);
	}

	// Update Member
	@Override
	public int updateMember(Member member) {
		return memberDao.updateMember(member);
	}

	// Delete Member
	@Override
	public int deleteMember(int memberId) {
		return memberDao.deleteMember(memberId);
		
	}

	// List of Users
	@Override
	public List<Member> getAllUsers() {
		return memberDao.getAllUsers();
	}

	// List of Organizers
	@Override
	public List<Member> getAllMembers() {
		return memberDao.getAllOrganizers();
	}

}
