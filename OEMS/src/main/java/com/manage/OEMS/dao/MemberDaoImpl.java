package com.manage.OEMS.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.manage.OEMS.mappers.MemberRowMapper;
import com.manage.OEMS.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	MemberRowMapper rowMapper;

	// Add Member
	@Override
	public Member addMember(Member member) {

		Object[] args = { member.getRole(), member.getFirstName(), member.getLastName(), member.getEmail(),
				member.getPhoneNumber(), member.getPassword() };
		String query = "INSERT INTO member (role,first_name, last_name,email,phone_number,password)"
				+ "   VALUES (?,?,?,?,?,?)";
		this.jdbcTemplate.update(query, args);
		return member;
	}

	// Find by Username and Password
	@Override
	public Member findMemberByUsernameAndPassword(String username, String password) {
		String query = "select * from member where email=? and password=?";
		return this.jdbcTemplate.queryForObject(query, rowMapper, username, password);
	}

	// Update Member...
	@Override
	public int updateMember(Member member) {
		String query = "update member set first_name=?, last_name=?, email=?, phone_number=? where member_id=? ";
		Object[] args = { member.getFirstName(), member.getLastName(), member.getEmail(), member.getPhoneNumber(),
				member.getMemberId() };
		return this.jdbcTemplate.update(query, args);
	}

	// Get Member by Member Id
	@Override
	public Member getMember(int memberId) {
		String query = "select * from member where member_id = ?";
		return this.jdbcTemplate.queryForObject(query, rowMapper, memberId);
	}

	// Delete Member..
	@Override
	public int deleteMember(int memberId) {
		String query = "delete from member where member_id=?";
		Object[] args = { memberId };
		return this.jdbcTemplate.update(query, args);

	}

	// Find Member By Email
	@Override
	public Member getMember(String email) {
		String query = "select * from member where email=?";
		return this.jdbcTemplate.queryForObject(query, rowMapper, email);
	}

	// MemberId by Venue Id
	@Override
	public Integer getMemberIdByVenueId(int venueId) {
		String query = "select member_id from venue where venue_id=?";
		return this.jdbcTemplate.queryForObject(query, new RowMapper<Integer>() {
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt("member_id");
			}
		}, venueId);

	}

	//// Get All Users
	@Override
	public List<Member> getAllUsers() {
		String query = "select * from member where role=?";
		return this.jdbcTemplate.query(query, rowMapper, "user");
	}

	//// Get All Organizers
	@Override
	public List<Member> getAllOrganizers() {
		String query = "select * from member where role=?";
		return this.jdbcTemplate.query(query, rowMapper, "organizer");
	}

}
