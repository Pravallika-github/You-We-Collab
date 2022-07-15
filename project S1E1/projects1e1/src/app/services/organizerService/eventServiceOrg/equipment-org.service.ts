import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../../helper';

@Injectable({
  providedIn: 'root'
})
export class EquipmentOrgService {

  constructor(private _http:HttpClient) { }

  //get Equipments by venue Id
  public getEquipmentsByVenueId(venueId:any){
    return this._http.get(`${baseUrl}/equipment/getEquipments/${venueId}`);
  }

  //Add new Equipment to database
  public addNewEquipment(equipment:any){
    return this._http.post(`${baseUrl}/equipment/add`,equipment);
 }

 //Delete Equipment
public deleteEquipment(equipmentId:any){
  return this._http.delete(`${baseUrl}/equipment/deleteEquipment/${equipmentId}`);
 }

 //get the sigle Equipment 
public getEquipment(equipmentId: any){
  return this._http.get(`${baseUrl}/equipment/getEquipment/${equipmentId}`);
}

//update Equipment
public updateEquipment(equipment:any){
  return this._http.put(`${baseUrl}/equipment/updateEquipment`,equipment);
} 

  
}
