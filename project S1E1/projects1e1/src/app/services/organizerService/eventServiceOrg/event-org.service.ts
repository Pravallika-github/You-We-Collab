import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../../helper';

@Injectable({
  providedIn: 'root'
})
export class EventOrgService {

  constructor(private _http:HttpClient) { }

  //get events by venue Id
  public getEventsByVenueId(venueId:any){
    return this._http.get(`${baseUrl}/event/getEvents/${venueId}`);
  }
     //Add new Event to database
  public addNewEvent(event:any){
   return this._http.post(`${baseUrl}/event/add`,event);
}

//Delete Event
public deleteEvent(eventId:any){
  return this._http.delete(`${baseUrl}/event/deleteEvent/${eventId}`);
 }


 //get the sigle Event 
public getEvent(eventId: any){
  return this._http.get(`${baseUrl}/event/getEvent/${eventId}`);
}

//update Event
public updateEvent(event:any){
  return this._http.put(`${baseUrl}/event/updateEvent`,event);
}

  
}
