package com.manage.OEMS.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.manage.OEMS.model.FoodItem;

@Service
public class FoodItemRowMapper implements RowMapper<FoodItem> {

	@Override
	public FoodItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		FoodItem foodItem = new FoodItem();
		
		foodItem.setFoodItemId(rs.getInt("food_item_id"));
		foodItem.setFoodItemName(rs.getString("food_item_name"));
		foodItem.setFoodItemCost(rs.getInt("food_item_cost"));
		foodItem.setVenueId(rs.getInt("venue_id"));
			
			return foodItem;
	}

}
