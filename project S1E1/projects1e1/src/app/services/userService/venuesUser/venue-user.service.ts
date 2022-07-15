import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../../helper';

@Injectable({
  providedIn: 'root'
})
export class VenueUserService {

  constructor(private _http:HttpClient) { }

  public getAllVenues(){
    return this._http.get(`${baseUrl}/venue/getVenues`);
  }

  //get single venue fron server
  public getVenue(venueId:any){
    return this._http.get(`${baseUrl}/venue/getVenue/${venueId}`);
  }

  //get all places
  public getAllPlaces(){
    return this._http.get(`${baseUrl}/venue/places`);
  }

  //get venue of selected place
  public getVenueOfPlace(place:any){
    return this._http.get(`${baseUrl}/venue/getVenues/${place}`)
  }

  //get event by event name 
  public getEventByEventName(eventName : any,venueId:any){
    return this._http.get(`${baseUrl}/event/getOne/${eventName}/${venueId}`)
  }

  

  //Book Event
  public bookEvent(booking:any){
    
    return this._http.post(`${baseUrl}/booking/add`,booking);

  }



}