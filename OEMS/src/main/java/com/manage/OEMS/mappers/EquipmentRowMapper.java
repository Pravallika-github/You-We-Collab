package com.manage.OEMS.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.manage.OEMS.model.Equipment;

@Service
public class EquipmentRowMapper implements RowMapper<Equipment> {

	@Override
	public Equipment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
        Equipment equipment = new Equipment();
		
        equipment.setEquipmentId(rs.getInt("equipment_id"));
        equipment.setEquipmentName(rs.getString("equipment_name"));
        equipment.setEquipmentCost(rs.getInt("equipment_cost"));
        equipment.setVenueId(rs.getInt("venue_id"));
		
		
		return equipment;
	}

}
