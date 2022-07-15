package com.manage.OEMS.service;

import java.util.List;

import com.manage.OEMS.exception.ResourceNotFoundException;
import com.manage.OEMS.model.Member;

public interface MemberService {

	public Member addMember(Member member);

	public Member Authenticate(String username, String password) throws ResourceNotFoundException;

	public Member getMember(int memberId);

	public int updateMember(Member member);

	public int deleteMember(int memberId);

	public List<Member> getAllUsers();

	public List<Member> getAllMembers();

}
