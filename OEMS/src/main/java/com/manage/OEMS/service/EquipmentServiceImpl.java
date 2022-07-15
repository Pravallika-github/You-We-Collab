package com.manage.OEMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.manage.OEMS.dao.EquipmentDao;
import com.manage.OEMS.model.Equipment;

@org.springframework.stereotype.Service
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	EquipmentDao equipmentDao;

	// get equipment by venueId
	@Override
	public List<Equipment> getEquipmentsByVenueId(int venueId) {
		return equipmentDao.getEquipmentsByVenueId(venueId);
	}

	// add equipment
	@Override
	public Equipment addEquipment(Equipment equipment) {
		return this.equipmentDao.addEquipment(equipment);
	}

	// get equipment
	@Override
	public Equipment getEquipment(int equipmentId) {
		return equipmentDao.getEquipment(equipmentId);
	}

	// update equipment
	@Override
	public int updateEquipment(Equipment equipment) {
		return equipmentDao.updateEquipment(equipment);
	}

	// delete equipment
	@Override
	public int deleteEquipment(int equipmentId) {
		return equipmentDao.deleteEquipment(equipmentId);
	}

}
