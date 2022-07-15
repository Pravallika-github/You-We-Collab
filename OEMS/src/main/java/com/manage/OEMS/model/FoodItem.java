 package com.manage.OEMS.model;

public class FoodItem {
	
	private int foodItemId;
	private String foodItemName;
	private int foodItemCost;
	private int venueId;
	
	
	
	public FoodItem(int foodItemId, String foodItemName, int foodItemCost, int venueId) {
		super();
		this.foodItemId = foodItemId;
		this.foodItemName = foodItemName;
		this.foodItemCost = foodItemCost;
		this.venueId = venueId;
	}
	public FoodItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}
	public String getFoodItemName() {
		return foodItemName;
	}
	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}
	public int getFoodItemCost() {
		return foodItemCost;
	}
	public void setFoodItemCost(int foodItemCost) {
		this.foodItemCost = foodItemCost;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	
	
	@Override
	public String toString() {
		return "FoodItem [foodItemId=" + foodItemId + ", foodItemName=" + foodItemName + ", foodItemCost="
				+ foodItemCost + ", venueId=" + venueId + "]";
	}
	
	
	
	

}
