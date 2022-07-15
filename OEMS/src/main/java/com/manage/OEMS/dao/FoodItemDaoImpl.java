package com.manage.OEMS.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.manage.OEMS.mappers.FoodItemRowMapper;
import com.manage.OEMS.model.FoodItem;

@Repository
public class FoodItemDaoImpl implements FoodItemDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	FoodItemRowMapper rowMapper;

	/// Add new Food Item to Database
	@Override
	public FoodItem addFoodItem(FoodItem foodItem) {
		Object[] args = { foodItem.getFoodItemName(), foodItem.getFoodItemCost(), foodItem.getVenueId() };
		String query = "INSERT INTO food_item (food_item_name, food_item_cost, venue_id)" + "   VALUES (?,?,?)";
		this.jdbcTemplate.update(query, args);
		return foodItem;
	}

	// Update Food Item
	@Override
	public int updateFoodItem(FoodItem foodItem) {
		String query = "update food_item set food_item_name=?, food_item_cost=? where food_item_id=? ";
		Object[] args = { foodItem.getFoodItemName(), foodItem.getFoodItemCost(), foodItem.getFoodItemId() };
		return this.jdbcTemplate.update(query, args);
	}

	// Get Food Item
	@Override
	public FoodItem getFoodItem(int foodItemId) {
		String query = "select * from food_item where food_item_id=?";
		return this.jdbcTemplate.queryForObject(query, rowMapper, foodItemId);
	}

	// Delete Food Item
	@Override
	public int deleteFoodItem(int foodItemId) {
		String query = "delete from food_item where food_item_id=?";
		Object[] args = { foodItemId };
		return this.jdbcTemplate.update(query, args);
	}
	
	// Delete Food Item by Venue ID
		@Override
		public int deleteFoodItemByVenueId(int venueId) {
			String query = "delete from food_item where venue_id=?";
			return this.jdbcTemplate.update(query, venueId);
		}


	// List of Food Item by Venue ID
	@Override
	public List<FoodItem> getFoodItemsByVenueId(int venueId) {
		String query = "select * from food_item where venue_id=?";
		return this.jdbcTemplate.query(query, rowMapper, venueId);
	}

}
