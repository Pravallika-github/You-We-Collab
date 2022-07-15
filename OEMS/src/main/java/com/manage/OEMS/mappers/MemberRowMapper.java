package com.manage.OEMS.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.manage.OEMS.model.Member;

@Service
public class MemberRowMapper implements RowMapper<Member> {
	
	

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Member member = new Member();
		
		member.setMemberId(rs.getInt("member_id"));
		member.setRole(rs.getString("role"));
		member.setFirstName(rs.getString("first_name"));
		member.setLastName(rs.getString("last_name"));
		member.setEmail(rs.getString("email"));
		member.setPhoneNumber(rs.getString("phone_number"));
		member.setPassword(rs.getString("password"));
		
		
		return member;
	}

}
