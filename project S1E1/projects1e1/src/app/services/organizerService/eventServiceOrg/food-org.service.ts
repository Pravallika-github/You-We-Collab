import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../../helper';

@Injectable({
  providedIn: 'root'
})
export class FoodOrgService {

  constructor(private _http:HttpClient) { }

  //get Equipments by venue Id
  public getFoodItemsByVenueId(venueId:any){
    return this._http.get(`${baseUrl}/foodItem/getFoodItems/${venueId}`);
  }

  //Add new Food Item to database
  public addNewFoodItem(foodItem:any){
    return this._http.post(`${baseUrl}/foodItem/add`,foodItem);
 }

 //Delete Food Item
 public deleteFoodItem(foodItemId:any){
  return this._http.delete(`${baseUrl}/foodItem/deleteFoodItem/${foodItemId}`);
 }


 //get the sigle foodItem 
public getFoodItem(foodItemId: any){
  return this._http.get(`${baseUrl}/foodItem/getFoodItem/${foodItemId}`);
}

//update FoodI tem
public updateFoodItem(foodItem:any){
  return this._http.put(`${baseUrl}/foodItem/updateFoodItem`,foodItem);
}

}
