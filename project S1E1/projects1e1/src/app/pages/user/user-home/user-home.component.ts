import { VenueUserService } from 'src/app/services/userService/venuesUser/venue-user.service';

import { HistoryService } from 'src/app/services/userService/history.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {
  venues:any;
  numVenue:any;
  bookings:any;
  numBookings:any;
  notifications:any;
  numNoti:any;
  constructor(private historyService :HistoryService,
              private venueUserService:VenueUserService) { }

  ngOnInit(): void {

    
    this.historyService.getBookingByUserId().subscribe(
      (data)=>{
        this.bookings = data;
        this.numBookings = this.bookings.length;
      },
      (error)=>{
        console.log(error);
      }
    );

    this.historyService.getNotifications().subscribe(
      (notifications:any)=>{
        this.notifications = notifications;
        this.numNoti = this.notifications.length;
      },
      (error)=>{
        console.log(error);
      }
      );

      this.venueUserService.getAllVenues().subscribe(
        (venues)=>{
          this.venues = venues;
          this.numVenue = this.venues.length;
        },
        (error)=>{
          console.log(error);
         
        }
        )
  }

}
