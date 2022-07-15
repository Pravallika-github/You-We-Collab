package com.manage.OEMS.dao;

import java.util.List;

import com.manage.OEMS.model.Equipment;

public interface EquipmentDao {

	public Equipment addEquipment(Equipment equipment);

	public int updateEquipment(Equipment equipment);

	public Equipment getEquipment(int equipmentId);

	public int deleteEquipment(int equipmentId);

	public List<Equipment> getEquipmentsByVenueId(int eventId);

	public int deleteEquipmentByVenueId(int venueId);

}
