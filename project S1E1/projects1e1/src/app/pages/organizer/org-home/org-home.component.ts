import { HistoryService } from 'src/app/services/userService/history.service';
import { OrganizerService } from 'src/app/services/organizerService/organizer.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-org-home',
  templateUrl: './org-home.component.html',
  styleUrls: ['./org-home.component.css']
})
export class OrgHomeComponent implements OnInit {

  venues:any;
  numVenue:any;
  UpBookings:any;
  numUpBookings:any;
  notifications:any;
  numNoti:any;
  pastBookings:any;
  numPast:any;

  constructor(private orgService:OrganizerService,
              private historyService:HistoryService) { }

  ngOnInit(): void {
          // Number of Upcoming Bookings
          this.orgService.getFutureBookingsByOrgId().subscribe(
            (data)=>{
              this.UpBookings = data;
              this.numUpBookings = this.UpBookings.length;


              // Number of Past Bookings
             this.orgService.getPastBookingsByOrgId().subscribe(
              (data)=>{
               this.pastBookings = data;
               this.numPast = this.pastBookings.length;
              },
             (error)=>{
               console.log(error);
               }
              );

              
            },
            (error)=>{
              console.log(error);
            }
          );

    // Number of Venues 
    this.orgService.getVenueByOrganizerId().subscribe(
      (venues)=>{
        this.venues = venues;
        this.numVenue = this.venues.length;
      },
      (error)=>{
        console.log(error);
      }
      );


    // Number of Notifications
    this.historyService.getNotifications().subscribe(
      (notifications:any)=>{
        this.notifications = notifications;
        this.numNoti = this.notifications.length;


            


      },
      (error)=>{
        console.log(error);
      }
      )

  }

}
