package com.manage.OEMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manage.OEMS.dao.FoodItemDao;
import com.manage.OEMS.model.FoodItem;

@Service
public class FoodItemServiceImpl implements FoodItemService {

	@Autowired
	FoodItemDao foodItemDao;

	// Get food Items by venueId
	@Override
	public List<FoodItem> getFoodItemsByVenueId(int venueId) {
		return foodItemDao.getFoodItemsByVenueId(venueId);
	}

	// Add...
	@Override
	public FoodItem addFoodItem(FoodItem foodItem) {
		return this.foodItemDao.addFoodItem(foodItem);
	}

	// Get...
	@Override
	public FoodItem getFoodItem(int foodItemId) {
		return foodItemDao.getFoodItem(foodItemId);
	}

	// Update...
	@Override
	public int updateFoodItem(FoodItem foodItem) {
		return foodItemDao.updateFoodItem(foodItem);
	}

	//Delete...
	@Override
	public int deleteFoodItem(int foodItemId) {
		return foodItemDao.deleteFoodItem(foodItemId);
	}

}
