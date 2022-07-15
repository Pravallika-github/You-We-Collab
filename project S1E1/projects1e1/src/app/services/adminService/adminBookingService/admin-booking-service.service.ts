import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from '../../helper';

@Injectable({
  providedIn: 'root'
})
export class AdminBookingServiceService {
  constructor(private http: HttpClient) { }

  // List of All Bookings
 public getAllBookings(){
  return this.http.get(`${baseUrl}/booking/getAllBookings`);
 }

 // Single Booking Detail
  public bookingDetail(bookingId:any){
    return this.http.get(`${baseUrl}/booking/bookingDetail/${bookingId}`);
}

}
