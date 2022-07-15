package com.manage.OEMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manage.OEMS.model.Equipment;
import com.manage.OEMS.service.EquipmentService;

@RestController
@RequestMapping("/equipment")
@CrossOrigin("*")
public class EquipmentController {

	@Autowired
	EquipmentService equipmentService;

	// Handler for get equipments by venueId
	@GetMapping("/getEquipments/{venueId}")
	public List<Equipment> getEquipmentsByVenueId(@PathVariable("venueId") int venueId) {
		return equipmentService.getEquipmentsByVenueId(venueId);
	}

	// Handler for adding new Equipment
	@PostMapping("/add")
	public Equipment addEquipment(@RequestBody Equipment equipment) {
		
		return this.equipmentService.addEquipment(equipment);
	}

	// Handler to get Equipment by ID
	@GetMapping("/getEquipment/{equipmentId}")
	public Equipment getEquipment(@PathVariable("equipmentId") int equipmentId) {
		return equipmentService.getEquipment(equipmentId);
	}

	// Handler to update Equipment
	@PutMapping("/updateEquipment")
	public int updateEquipment(@RequestBody Equipment equipment) {
		return equipmentService.updateEquipment(equipment);
	}

	// Handler to delete equipment 
	@DeleteMapping("/deleteEquipment/{equipmentId}")
	public int deleteEquipment(@PathVariable("equipmentId") int equipmentId) {
		return equipmentService.deleteEquipment(equipmentId);
	}

}
