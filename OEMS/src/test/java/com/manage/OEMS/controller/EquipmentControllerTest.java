package com.manage.OEMS.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.manage.OEMS.model.Equipment;
import com.manage.OEMS.service.EquipmentService;

@RunWith(JUnitPlatform.class)
class EquipmentControllerTest {

	@Mock
	private EquipmentService equipmentService;

	@InjectMocks
	private EquipmentController equipmentController;

	@BeforeEach
	public void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	// Method to Test getEquipmentsByVenueId
	@Test
	public void testGetEquipmentsByVenueId() throws Exception {

		int venueId = 1001;
		List<Equipment> equipments = new ArrayList<>();
		equipments.add(new Equipment(1001, "Music", 50, 60));
		when(equipmentService.getEquipmentsByVenueId(venueId)).thenReturn(equipments);
		assertEquals(equipmentController.getEquipmentsByVenueId(venueId).size(), 1);
	}

	// Method to Test addEquipment
	@Test
	public void testAddEquipment() throws Exception {
		Equipment equipment = new Equipment(101, "Music", 30, 1010);
		when(equipmentService.addEquipment(equipment)).thenReturn(equipment);
		Equipment equipment2 = equipmentController.addEquipment(equipment);
		assertEquals(equipment2.getEquipmentName(), "Music");
	}

	// Method to Test GetEquipment
	@Test
	public void testGetEquipment() throws Exception {

		int equipmentId = 1002;
		Equipment equipment = new Equipment(1002, "Music", 40, 30);
		when(equipmentService.getEquipment(equipmentId)).thenReturn(equipment);
		assertEquals(equipmentController.getEquipment(equipmentId), equipment);
	}

	// Method to Test UpdateEquipment
	@Test
	public void testUpdateEquipment() throws Exception {

		Equipment equipment = new Equipment(1004, "Music", 50, 1012);
		when(equipmentService.updateEquipment(equipment)).thenReturn(1);
		assertEquals(equipmentController.updateEquipment(equipment), 1);
	}

	// Method to Test deleteEquipment
	@Test
	public void testDeleteEquipment() throws Exception {
		int equipmentId = 1005;
		when(equipmentService.deleteEquipment(equipmentId)).thenReturn(1);
		assertEquals(equipmentController.deleteEquipment(equipmentId), 1);
	}

}