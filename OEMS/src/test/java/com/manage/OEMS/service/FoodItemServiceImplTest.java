package com.manage.OEMS.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.manage.OEMS.dao.FoodItemDao;
import com.manage.OEMS.model.FoodItem;

public class FoodItemServiceImplTest {
	@Mock
	FoodItemDao foodItemDao;

	@InjectMocks
	FoodItemServiceImpl foodItemService;

	@BeforeEach
	public void setUpBeforeClass() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	
    // Method to Test getFoodItemsByVenueId
	@Test
	public void testGetFoodItemsByVenueId() {

		int venueId = 1001;
		List<FoodItem> foodItems = new ArrayList<>();
		foodItems.add(new FoodItem(1001, "curd rice", 50, 60));

		when(foodItemService.getFoodItemsByVenueId(venueId)).thenReturn(foodItems);
		assertEquals(foodItemService.getFoodItemsByVenueId(venueId).size(), 1);
	}

	
	// Method to Test addFooditem
	@Test
	public void testAddFooditem() {
		FoodItem foodItem = new FoodItem(101, "curry", 30, 1010);
		when(foodItemService.addFoodItem(foodItem)).thenReturn(foodItem);
		FoodItem food = foodItemService.addFoodItem(foodItem);
		assertEquals(food.getFoodItemName(), "curry");
	}

	// Method to Test getFoodItem
	@Test
	public void testGetFoodItem() {

		int foodItemId = 1002;
		FoodItem items1 = new FoodItem(1002, "rice", 40, 30);

		when(foodItemService.getFoodItem(foodItemId)).thenReturn(items1);
		assertEquals(foodItemService.getFoodItem(foodItemId), items1);
	}

	// Method to Test updateFoodItem
	@Test
	public void testUpdateFoodItem() {

		FoodItem foodItem = new FoodItem(1004, "rice", 50, 1012);
		when(foodItemService.updateFoodItem(foodItem)).thenReturn(1);
		assertEquals(foodItemService.updateFoodItem(foodItem), 1);
	}

	// Method to Test deleteFoodItem
	@Test
	public void testDeleteFoodItem() {
		int foodItemId = 1005;
		when(foodItemService.deleteFoodItem(foodItemId)).thenReturn(1);
		assertEquals(foodItemService.deleteFoodItem(foodItemId), 1);
	}
}
