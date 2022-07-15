import { HttpClient } from '@angular/common/http';
import { LoginService } from './../login.service';
import { Injectable } from '@angular/core';
import baseUrl from '../helper';

@Injectable({
  providedIn: 'root'
})
export class HistoryService {

  constructor(private login:LoginService,private http :HttpClient) { }

  // Get Booking By User Id
 public getBookingByUserId(){
   return this.http.get(`${baseUrl}/booking/bookingsByUserId/${this.login.getMemberId()}`)
 }

 // make Payment
 public doPayment(bookingId:any){
   return this.http.get(`${baseUrl}/booking/doPayment/${bookingId}`)
 }

 // Get Booked Dates 
 public getDates(venueId:any){
  return this.http.get(`${baseUrl}/booking/getDates/${venueId}`)
}

// Get Notifications
public getNotifications(){
  return this.http.get(`${baseUrl}/notification/getNotification/${localStorage.getItem('memberId')}`)
}

// Cancel Booking
public cancelBooking(bookingId:any){
  return this.http.delete(`${baseUrl}/booking/deleteBooking/${bookingId}`);
}

// Delete Notifications
public deleteNoti(notiId:any){
  return this.http.delete(`${baseUrl}/notification/deleteNotification/${notiId}`);
}

}
