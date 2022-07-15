package com.manage.OEMS.dao;

import java.util.List;

import com.manage.OEMS.model.FoodItem;

public interface FoodItemDao {
	
    public FoodItem addFoodItem(FoodItem foodItem);
	
	public int updateFoodItem(FoodItem foodItem);
	
	public FoodItem getFoodItem(int foodItemId);
	
	public int deleteFoodItem(int foodItemId);

	public List<FoodItem> getFoodItemsByVenueId(int venueId);

	public int deleteFoodItemByVenueId(int venueId);

}
