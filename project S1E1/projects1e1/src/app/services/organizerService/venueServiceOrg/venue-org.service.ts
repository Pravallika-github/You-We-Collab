import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import baseUrl from '../../helper';

@Injectable({
  providedIn: 'root'
})
export class VenueOrgService {


  constructor(private http:HttpClient) { }
  //Add new venue to database
public addVenueToDB(venue:any){
  return this.http.post(`${baseUrl}/venue/add`,venue);
}

//delete venue from database
 public deleteVenue(venueId:any){

  return this.http.delete(`${baseUrl}/venue/deleteVenue/${venueId}`);
}

//get the sigle Venue 
public getVenue(venueId: any){
  return this.http.get(`${baseUrl}/venue/getVenue/${venueId}`);
}

//update venue request
public updateVenue(venue:any){
  return this.http.put(`${baseUrl}/venue/updateVenue`,venue);
} 

public checkActiveBooking(venueId:any){
  return this.http.get(`${baseUrl}/booking/checkActiveBookings/${venueId}`);
}

}
