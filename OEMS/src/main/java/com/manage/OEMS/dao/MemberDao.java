package com.manage.OEMS.dao;

import java.util.List;


import com.manage.OEMS.model.Member;

public interface MemberDao {
	
	public Member addMember(Member member);
	
	public int updateMember(Member member);
	
	public Member getMember(int memberId);
	
	public Member getMember(String email);
	
	public Member findMemberByUsernameAndPassword(String username, String password);
	
	public int deleteMember(int memberId);

	public Integer getMemberIdByVenueId(int venueId);

	public List<Member> getAllUsers();

	public List<Member> getAllOrganizers();

}
