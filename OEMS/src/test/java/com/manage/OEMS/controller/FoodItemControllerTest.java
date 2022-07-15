package com.manage.OEMS.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import com.manage.OEMS.model.FoodItem;
import com.manage.OEMS.service.FoodItemService;

@RunWith(JUnitPlatform.class)
class FoodItemControllerTest {

	@Mock
	private FoodItemService foodItemService;

	@InjectMocks
	private FoodItemController foodItemController;

	@BeforeEach
	public void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	// Method to Test getFoodItemsByVenueId
	@Test
	public void testGetFoodItemsByVenueId() throws Exception {

		int venueId = 1001;
		List<FoodItem> foodItems = new ArrayList<>();
		foodItems.add(new FoodItem(1001, "curd rice", 50, 60));

		when(foodItemService.getFoodItemsByVenueId(venueId)).thenReturn(foodItems);
		assertEquals(foodItemController.getFoodItemsByVenueId(venueId).size(), 1);
	}

	// Method to Test addFooditem
	@Test
	public void testAddFooditem() throws Exception {
		FoodItem foodItem = new FoodItem(101, "curry", 30, 1010);
		when(foodItemService.addFoodItem(foodItem)).thenReturn(foodItem);
		FoodItem food = foodItemController.addFoodItem(foodItem);
		assertEquals(food.getFoodItemName(), "curry");
	}

	// Method to Test getFoodItem
	@Test
	public void testGetFoodItem() throws Exception {

		int foodItemId = 1002;
		FoodItem items1 = new FoodItem(1002, "rice", 40, 30);

		when(foodItemService.getFoodItem(foodItemId)).thenReturn(items1);
		assertEquals(foodItemController.getFoodItem(foodItemId), items1);
	}

	// Method to Test updateFoodItem
	@Test
	public void testUpdateFoodItem() throws Exception {

		FoodItem foodItem = new FoodItem(1004, "rice", 50, 1012);
		when(foodItemService.updateFoodItem(foodItem)).thenReturn(1);
		assertEquals(foodItemController.updateFoodItem(foodItem), 1);
	}

	// Method to Test deleteFoodItem
	@Test
	public void testDeleteFoodItem() throws Exception {
		int foodItemId = 1005;
		when(foodItemService.deleteFoodItem(foodItemId)).thenReturn(1);
		assertEquals(foodItemController.deleteFoodItem(foodItemId), 1);
	}
}