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
import com.manage.OEMS.model.FoodItem;
import com.manage.OEMS.service.FoodItemService;

@RestController
@RequestMapping("/foodItem")
@CrossOrigin("*")
public class FoodItemController {

	@Autowired
	FoodItemService foodItemService;

	// Handler for get food Items by venueId
	@GetMapping("/getFoodItems/{venueId}")
	public List<FoodItem> getFoodItemsByVenueId(@PathVariable("venueId") int venueId) {
		return foodItemService.getFoodItemsByVenueId(venueId);
	}

	// Add Food Item
	@PostMapping("/add")
	public FoodItem addFoodItem(@RequestBody FoodItem foodItem) {
		
		return this.foodItemService.addFoodItem(foodItem);
	}

	// Get Food Item by Id
	@GetMapping("/getFoodItem/{foodItemId}")
	public FoodItem getFoodItem(@PathVariable("foodItemId") int foodItemId) {
		return foodItemService.getFoodItem(foodItemId);
	}

	// Update Food Item
	@PutMapping("/updateFoodItem")
	public int updateFoodItem(@RequestBody FoodItem foodItem) {
		return foodItemService.updateFoodItem(foodItem);
	}

	// Delete food item
	@DeleteMapping("/deleteFoodItem/{foodItemId}")
	public int deleteFoodItem(@PathVariable("foodItemId") int foodItemId) {
		return foodItemService.deleteFoodItem(foodItemId);
	}

}
