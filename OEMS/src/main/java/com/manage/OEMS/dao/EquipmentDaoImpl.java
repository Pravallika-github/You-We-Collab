package com.manage.OEMS.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manage.OEMS.mappers.EquipmentRowMapper;
import com.manage.OEMS.model.Equipment;

@Repository
public class EquipmentDaoImpl implements EquipmentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	EquipmentRowMapper rowMapper;

	// Add Equipment...
	@Override
	public Equipment addEquipment(Equipment equipment) {
		Object[] args = { equipment.getEquipmentName(), equipment.getEquipmentCost(), equipment.getVenueId() };

		String query = "INSERT INTO equipment (equipment_name, equipment_cost, venue_id)" + "   VALUES (?,?,?)";

		this.jdbcTemplate.update(query, args);
		return equipment;
	}

	// Update Equipment...
	@Override
	public int updateEquipment(Equipment equipment) {
		String query = "update equipment set equipment_name=?, equipment_cost=? where equipment_id=? ";

		Object[] args = { equipment.getEquipmentName(), equipment.getEquipmentCost(), equipment.getEquipmentId() };

		return this.jdbcTemplate.update(query, args);
	}

	// Get Equipment...
	@Override
	public Equipment getEquipment(int equipmentId) {
		String query = "select * from equipment where equipment_id=?";

		return this.jdbcTemplate.queryForObject(query, rowMapper, equipmentId);
	}

	// Delete Equipment...
	@Override
	public int deleteEquipment(int equipmentId) {
		String query = "delete from equipment where equipment_id=?";
		Object[] args = { equipmentId };
		return this.jdbcTemplate.update(query, args);
	}

	// Delete Equipment by Venue ID
	@Override
	public int deleteEquipmentByVenueId(int venueId) {
		String query = "delete from equipment where venue_id=?";
		return this.jdbcTemplate.update(query, venueId);
	}

	// Get List of Equipments by event ID
	@Override
	public List<Equipment> getEquipmentsByVenueId(int eventId) {
		String query = "select * from equipment where venue_id=?";
		return this.jdbcTemplate.query(query, rowMapper, eventId);
	}

}
